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

package org.apache.eventmesh.storage.kafka.admin;

import org.apache.eventmesh.api.admin.AbstractAdmin;
import org.apache.eventmesh.api.admin.TopicProperties;
import org.apache.eventmesh.common.config.ConfigService;
import org.apache.eventmesh.storage.kafka.config.ClientConfiguration;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.ListOffsetsResult;
import org.apache.kafka.clients.admin.OffsetSpec;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.TopicPartitionInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import io.cloudevents.CloudEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaAdmin extends AbstractAdmin {

    private static final Properties properties = new Properties();

    public KafkaAdmin() {
        super(new AtomicBoolean(false));

        ConfigService configService = ConfigService.getInstance();
        ClientConfiguration clientConfiguration = configService.buildConfigInstance(ClientConfiguration.class);

        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, clientConfiguration.getBootstrapServers());
    }

    @Override
    public List<TopicProperties> getTopic() throws Exception {
        Admin client = Admin.create(properties);
        Set<String> topicList = client.listTopics().names().get();
        try {
            List<TopicProperties> result = new ArrayList<>();
            for (String topic : topicList) {
                DescribeTopicsResult describeTopicsResult = client.describeTopics(Collections.singletonList(topic));
                TopicDescription topicDescription = describeTopicsResult.values().get(topic).get();

                long messageCount = topicDescription.partitions().stream()
                    .mapToInt(TopicPartitionInfo::partition)
                    .mapToLong(partition -> {
                        try {
                            return getLastOffset(topic, partition, client);
                        } catch (ExecutionException | InterruptedException e) {
                            log.error("Failed to get last offset", e);
                            throw new RuntimeException(e);
                        }
                    })
                    .sum();

                result.add(new TopicProperties(topic, messageCount));
            }
            result.sort(Comparator.comparing(t -> t.name));
            return result;
        } finally {
            client.close();
            log.info("KafkaAdmin closed");
        }
    }

    private long getLastOffset(String topic, int partition, Admin client) throws ExecutionException, InterruptedException {
        Map<TopicPartition, OffsetSpec> offsetSpecMap = Collections.singletonMap(
            new TopicPartition(topic, partition),
            new OffsetSpec.EarliestSpec()
        );

        Map<TopicPartition, ListOffsetsResult.ListOffsetsResultInfo> offsetResultMap = client.listOffsets(offsetSpecMap).all().get();
        return offsetResultMap.get(new TopicPartition(topic, partition)).offset();
    }

    @Override
    public void createTopic(String topicName) {
    }

    @Override
    public void deleteTopic(String topicName) {
    }

    @Override
    public List<CloudEvent> getEvent(String topicName, int offset, int length) throws Exception {
        return null;
    }

    @Override
    public void publish(CloudEvent cloudEvent) throws Exception {
    }

}
