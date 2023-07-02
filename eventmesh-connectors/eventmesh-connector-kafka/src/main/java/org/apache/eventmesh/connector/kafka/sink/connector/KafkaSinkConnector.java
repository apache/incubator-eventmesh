/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.eventmesh.connector.kafka.sink.connector;
import io.cloudevents.kafka.CloudEventSerializer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.apache.eventmesh.connector.kafka.sink.config.KafkaSinkConfig;
import org.apache.eventmesh.openconnect.api.config.Config;
import org.apache.eventmesh.openconnect.api.data.ConnectRecord;
import org.apache.eventmesh.openconnect.api.sink.Sink;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.serialization.StringSerializer;

@Slf4j
public class KafkaSinkConnector implements Sink {

    private KafkaSinkConfig sinkConfig;

    private Properties props = new Properties();
    Producer<String, String> producer;

    @Override
    public Class<? extends Config> configClass() {
        return KafkaSinkConfig.class;
    }

    @Override
    public void init(Config config) throws Exception {
        // init config for rocketmq source connector
        this.sinkConfig = (KafkaSinkConfig) config;
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, sinkConfig.getConnectorConfig().getBootstrapServers());
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, sinkConfig.getConnectorConfig().getKeyConverter());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CloudEventSerializer.class);
        producer = new KafkaProducer<>(props);
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void commit(ConnectRecord record) {

    }

    @Override
    public String name() {
        return this.sinkConfig.getConnectorConfig().getConnectorName();
    }

    @Override
    public void stop() {
        producer.close();
    }

    @Override
    public void put(List<ConnectRecord> sinkRecords) {
        for (ConnectRecord connectRecord : sinkRecords) {
            ProducerRecord message = convertRecordToMessage(connectRecord);
            producer.send(message, (metadata, exception) -> {
                if (exception == null) {
                    System.out.printf("Produced message to topic %s partition [%d] @ offset %d%n",
                        metadata.topic(), metadata.partition(), metadata.offset());
                } else {
                    System.err.println("Failed to produce message: " + exception.getMessage());
                }
            });
        }
    }

    public ProducerRecord convertRecordToMessage(ConnectRecord connectRecord) {
        List<Header> headers = new ArrayList<>();
        for (String key : connectRecord.getExtensions().keySet()) {
            headers.add(new RecordHeader(key, connectRecord.getExtension(key).getBytes(StandardCharsets.UTF_8)));
        }
        ProducerRecord message = new ProducerRecord(this.sinkConfig.getConnectorConfig().getTopic(), null,"",new String((byte[]) connectRecord.getData(), StandardCharsets.UTF_8),headers);
        return message;
    }
}
