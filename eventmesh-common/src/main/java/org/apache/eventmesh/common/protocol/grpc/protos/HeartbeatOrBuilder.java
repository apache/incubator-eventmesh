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

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: eventmesh-client.proto

package org.apache.eventmesh.common.protocol.grpc.protos;

@SuppressWarnings({"all"})
public interface HeartbeatOrBuilder extends
    // @@protoc_insertion_point(interface_extends:eventmesh.common.protocol.grpc.Heartbeat)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.eventmesh.common.protocol.grpc.RequestHeader header = 1;</code>
   */
  boolean hasHeader();
  /**
   * <code>.eventmesh.common.protocol.grpc.RequestHeader header = 1;</code>
   */
  RequestHeader getHeader();
  /**
   * <code>.eventmesh.common.protocol.grpc.RequestHeader header = 1;</code>
   */
  RequestHeaderOrBuilder getHeaderOrBuilder();

  /**
   * <code>.eventmesh.common.protocol.grpc.Heartbeat.ClientType clientType = 2;</code>
   */
  int getClientTypeValue();
  /**
   * <code>.eventmesh.common.protocol.grpc.Heartbeat.ClientType clientType = 2;</code>
   */
  Heartbeat.ClientType getClientType();

  /**
   * <code>string producerGroup = 3;</code>
   */
  String getProducerGroup();
  /**
   * <code>string producerGroup = 3;</code>
   */
  com.google.protobuf.ByteString
      getProducerGroupBytes();

  /**
   * <code>string consumerGroup = 4;</code>
   */
  String getConsumerGroup();
  /**
   * <code>string consumerGroup = 4;</code>
   */
  com.google.protobuf.ByteString
      getConsumerGroupBytes();

  /**
   * <code>repeated .eventmesh.common.protocol.grpc.Heartbeat.HeartbeatItem heartbeatItems = 5;</code>
   */
  java.util.List<Heartbeat.HeartbeatItem>
      getHeartbeatItemsList();
  /**
   * <code>repeated .eventmesh.common.protocol.grpc.Heartbeat.HeartbeatItem heartbeatItems = 5;</code>
   */
  Heartbeat.HeartbeatItem getHeartbeatItems(int index);
  /**
   * <code>repeated .eventmesh.common.protocol.grpc.Heartbeat.HeartbeatItem heartbeatItems = 5;</code>
   */
  int getHeartbeatItemsCount();
  /**
   * <code>repeated .eventmesh.common.protocol.grpc.Heartbeat.HeartbeatItem heartbeatItems = 5;</code>
   */
  java.util.List<? extends Heartbeat.HeartbeatItemOrBuilder>
      getHeartbeatItemsOrBuilderList();
  /**
   * <code>repeated .eventmesh.common.protocol.grpc.Heartbeat.HeartbeatItem heartbeatItems = 5;</code>
   */
  Heartbeat.HeartbeatItemOrBuilder getHeartbeatItemsOrBuilder(
      int index);
}
