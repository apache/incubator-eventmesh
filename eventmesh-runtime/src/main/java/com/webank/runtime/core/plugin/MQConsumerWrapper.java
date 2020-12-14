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

package com.webank.runtime.core.plugin;

import com.webank.api.consumer.MeshMQPushConsumer;
import com.webank.eventmesh.common.config.CommonConfiguration;
import com.webank.runtime.constants.ProxyConstants;
import com.webank.runtime.patch.ProxyConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ServiceLoader;

public class MQConsumerWrapper extends MQWrapper {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    protected MeshMQPushConsumer meshMQConsumer;

    public void setInstanceName(String instanceName) {

        meshMQConsumer.setInstanceName(instanceName);
    }

    public void subscribe(String topic) throws Exception {

        meshMQConsumer.subscribe(topic);
    }

    public void unsubscribe(String topic) throws Exception {
        meshMQConsumer.unsubscribe(topic);
    }

    public boolean isPause() {
        return meshMQConsumer.isPause();
    }

    public void pause() {
        meshMQConsumer.pause();
    }

    public synchronized void init(boolean isBroadcast, CommonConfiguration commonConfiguration,
                                  String consumerGroup) throws Exception {
        meshMQConsumer = getMeshMQConsumer();
        if (meshMQConsumer == null){
            logger.error("can't load the meshMQConsumer plugin, please check.");
            throw new RuntimeException("doesn't load the meshMQConsumer plugin, please check.");
        }
        if (isBroadcast){
            consumerGroup = ProxyConstants.CONSUMER_GROUP_NAME_PREFIX + ProxyConstants.BROADCAST_PREFIX + consumerGroup;
        }else {
            consumerGroup = ProxyConstants.CONSUMER_GROUP_NAME_PREFIX + consumerGroup;
        }
        meshMQConsumer.init(isBroadcast, commonConfiguration, consumerGroup);
        inited.compareAndSet(false, true);
    }

    private MeshMQPushConsumer getMeshMQConsumer() {
        ServiceLoader<MeshMQPushConsumer> meshMQConsumerServiceLoader = ServiceLoader.load(MeshMQPushConsumer.class);
        if (meshMQConsumerServiceLoader.iterator().hasNext()){
            return meshMQConsumerServiceLoader.iterator().next();
        }
        return null;
    }

    public synchronized void start() throws Exception {

        meshMQConsumer.start();
        started.compareAndSet(false, true);
    }

    public synchronized void shutdown() throws Exception {

        meshMQConsumer.shutdown();
        inited.compareAndSet(false, true);
        started.compareAndSet(false, true);
    }

    public void registerMessageListener(MessageListenerConcurrently messageListenerConcurrently) {
        meshMQConsumer.registerMessageListener(messageListenerConcurrently);
    }

    public void updateOffset(List<MessageExt> msgs, ProxyConsumeConcurrentlyContext proxyConsumeConcurrentlyContext) {

        meshMQConsumer.updateOffset(msgs, proxyConsumeConcurrentlyContext);
    }
}
