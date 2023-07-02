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

package org.apache.eventmesh.connector.kafka.source.connector;

import io.cloudevents.CloudEvent;
import io.cloudevents.kafka.CloudEventDeserializer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.eventmesh.connector.kafka.config.KafkaServerConfig;
import org.apache.eventmesh.connector.kafka.source.config.KafkaSourceConfig;
import org.apache.eventmesh.openconnect.api.config.Config;
import org.apache.eventmesh.openconnect.api.data.ConnectRecord;
import org.apache.eventmesh.openconnect.api.data.RecordOffset;
import org.apache.eventmesh.openconnect.api.data.RecordPartition;
import org.apache.eventmesh.openconnect.api.source.Source;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class KafkaSourceConnector implements Source {

    private KafkaSourceConfig sourceConfig;

    private KafkaConsumer<String, CloudEvent> kafkaConsumer;
    @Override
    public Class<? extends Config> configClass() {
        return KafkaServerConfig.class;
    }

    @Override
    public void init(Config config) throws Exception {
        this.sourceConfig = (KafkaSourceConfig) config;
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, sourceConfig.getConnectorConfig().getBootstrapServers());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, CloudEventDeserializer.class);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, sourceConfig.getConnectorConfig().getGroupID());
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");

        this.kafkaConsumer = new KafkaConsumer<String, CloudEvent>(props);
    }

    @Override
    public void start() throws Exception {
        kafkaConsumer.subscribe(Collections.singleton(sourceConfig.getConnectorConfig().getTopic()));
    }

    @Override
    public void commit(ConnectRecord record) {

    }

    @Override
    public String name() {
        return this.sourceConfig.getConnectorConfig().getConnectorName();
    }

    @Override
    public void stop() {
        kafkaConsumer.unsubscribe();
    }

    @Override
    public List<ConnectRecord> poll() {
        ConsumerRecords<String, CloudEvent> records = kafkaConsumer.poll(Duration.ofMillis(100));
        List<ConnectRecord> connectRecords = new ArrayList<>(records.count());
        for (ConsumerRecord<String, CloudEvent> record : records) {
            Long timestamp = System.currentTimeMillis();
            String key = record.key();
            CloudEvent value = record.value();
            RecordPartition recordPartition = convertToRecordPartition(record.topic(), record.partition());
            RecordOffset recordOffset = convertToRecordOffset(record.offset());
            ConnectRecord connectRecord = new ConnectRecord(recordPartition, recordOffset, timestamp, value);
            connectRecord.addExtension("key", key);
            connectRecords.add(connectRecord);
        }
        kafkaConsumer.commitAsync();
        return connectRecords;
    }

    public static RecordOffset convertToRecordOffset(Long offset) {
        Map<String, String> offsetMap = new HashMap<>();
        offsetMap.put("queueOffset", offset + "");
        return new RecordOffset(offsetMap);
    }

    public static RecordPartition convertToRecordPartition(String topic, int partition) {
        Map<String, String> map = new HashMap<>();
        map.put("topic", topic);
        map.put("partition", String.valueOf(partition));
        return new RecordPartition(map);
    }
}
