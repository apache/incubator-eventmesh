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

public final class EventmeshGrpc {
  private EventmeshGrpc() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_RequestHeader_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_RequestHeader_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_Response_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_Subscription_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_Subscription_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_Subscription_SubscriptionItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_Subscription_SubscriptionItem_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_Heartbeat_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_Heartbeat_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_eventmesh_common_protocol_grpc_Heartbeat_HeartbeatItem_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_eventmesh_common_protocol_grpc_Heartbeat_HeartbeatItem_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\026eventmesh-client.proto\022\036eventmesh.comm" +
      "on.protocol.grpc\"\266\001\n\rRequestHeader\022\013\n\003en" +
      "v\030\001 \001(\t\022\016\n\006region\030\002 \001(\t\022\013\n\003idc\030\003 \001(\t\022\n\n\002" +
      "ip\030\004 \001(\t\022\013\n\003pid\030\005 \001(\t\022\013\n\003sys\030\006 \001(\t\022\020\n\010us" +
      "ername\030\007 \001(\t\022\020\n\010password\030\010 \001(\t\022\017\n\007versio" +
      "n\030\t \001(\t\022\020\n\010language\030\n \001(\t\022\016\n\006seqNum\030\013 \001(" +
      "\t\"\236\001\n\007Message\022=\n\006header\030\001 \001(\0132-.eventmes" +
      "h.common.protocol.grpc.RequestHeader\022\025\n\r" +
      "producerGroup\030\002 \001(\t\022\r\n\005topic\030\003 \001(\t\022\017\n\007co" +
      "ntent\030\004 \001(\t\022\013\n\003ttl\030\005 \001(\t\022\020\n\010uniqueId\030\006 \001" +
      "(\t\"O\n\010Response\022\020\n\010respCode\030\001 \001(\t\022\017\n\007resp" +
      "Msg\030\002 \001(\t\022\020\n\010respTime\030\003 \001(\t\022\016\n\006seqNum\030\004 " +
      "\001(\t\"\212\002\n\014Subscription\022=\n\006header\030\001 \001(\0132-.e" +
      "ventmesh.common.protocol.grpc.RequestHea" +
      "der\022\025\n\rconsumerGroup\030\002 \001(\t\022X\n\021subscripti" +
      "onItems\030\003 \003(\0132=.eventmesh.common.protoco" +
      "l.grpc.Subscription.SubscriptionItem\032J\n\020" +
      "SubscriptionItem\022\r\n\005topic\030\001 \001(\t\022\014\n\004mode\030" +
      "\002 \001(\t\022\014\n\004type\030\003 \001(\t\022\013\n\003url\030\004 \001(\t\"\212\002\n\tHea" +
      "rtbeat\022=\n\006header\030\001 \001(\0132-.eventmesh.commo" +
      "n.protocol.grpc.RequestHeader\022\022\n\nclientT" +
      "ype\030\002 \001(\t\022\025\n\rproducerGroup\030\003 \001(\t\022\025\n\rcons" +
      "umerGroup\030\004 \001(\t\022O\n\016heartbeatItems\030\005 \003(\0132" +
      "7.eventmesh.common.protocol.grpc.Heartbe" +
      "at.HeartbeatItem\032+\n\rHeartbeatItem\022\r\n\005top" +
      "ic\030\001 \001(\t\022\013\n\003url\030\002 \001(\t2\263\002\n\020PublisherServi" +
      "ce\022\\\n\007publish\022\'.eventmesh.common.protoco" +
      "l.grpc.Message\032(.eventmesh.common.protoc" +
      "ol.grpc.Response\022a\n\014requestReply\022\'.event" +
      "mesh.common.protocol.grpc.Message\032(.even" +
      "tmesh.common.protocol.grpc.Response\022^\n\tb" +
      "roadcast\022\'.eventmesh.common.protocol.grp" +
      "c.Message\032(.eventmesh.common.protocol.gr" +
      "pc.Response2\311\002\n\017ConsumerService\022c\n\tsubsc" +
      "ribe\022,.eventmesh.common.protocol.grpc.Su" +
      "bscription\032(.eventmesh.common.protocol.g" +
      "rpc.Response\022j\n\017subscribeStream\022,.eventm" +
      "esh.common.protocol.grpc.Subscription\032\'." +
      "eventmesh.common.protocol.grpc.Message0\001" +
      "\022e\n\013unsubscribe\022,.eventmesh.common.proto" +
      "col.grpc.Subscription\032(.eventmesh.common" +
      ".protocol.grpc.Response2t\n\020HeartbeatServ" +
      "ice\022`\n\theartbeat\022).eventmesh.common.prot" +
      "ocol.grpc.Heartbeat\032(.eventmesh.common.p" +
      "rotocol.grpc.ResponseBC\n0org.apache.even" +
      "tmesh.common.protocol.grpc.protosB\rEvent" +
      "meshGrpcP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_eventmesh_common_protocol_grpc_RequestHeader_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_eventmesh_common_protocol_grpc_RequestHeader_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_RequestHeader_descriptor,
        new String[] { "Env", "Region", "Idc", "Ip", "Pid", "Sys", "Username", "Password", "Version", "Language", "SeqNum", });
    internal_static_eventmesh_common_protocol_grpc_Message_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_eventmesh_common_protocol_grpc_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_Message_descriptor,
        new String[] { "Header", "ProducerGroup", "Topic", "Content", "Ttl", "UniqueId", });
    internal_static_eventmesh_common_protocol_grpc_Response_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_eventmesh_common_protocol_grpc_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_Response_descriptor,
        new String[] { "RespCode", "RespMsg", "RespTime", "SeqNum", });
    internal_static_eventmesh_common_protocol_grpc_Subscription_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_eventmesh_common_protocol_grpc_Subscription_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_Subscription_descriptor,
        new String[] { "Header", "ConsumerGroup", "SubscriptionItems", });
    internal_static_eventmesh_common_protocol_grpc_Subscription_SubscriptionItem_descriptor =
      internal_static_eventmesh_common_protocol_grpc_Subscription_descriptor.getNestedTypes().get(0);
    internal_static_eventmesh_common_protocol_grpc_Subscription_SubscriptionItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_Subscription_SubscriptionItem_descriptor,
        new String[] { "Topic", "Mode", "Type", "Url", });
    internal_static_eventmesh_common_protocol_grpc_Heartbeat_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_eventmesh_common_protocol_grpc_Heartbeat_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_Heartbeat_descriptor,
        new String[] { "Header", "ClientType", "ProducerGroup", "ConsumerGroup", "HeartbeatItems", });
    internal_static_eventmesh_common_protocol_grpc_Heartbeat_HeartbeatItem_descriptor =
      internal_static_eventmesh_common_protocol_grpc_Heartbeat_descriptor.getNestedTypes().get(0);
    internal_static_eventmesh_common_protocol_grpc_Heartbeat_HeartbeatItem_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_eventmesh_common_protocol_grpc_Heartbeat_HeartbeatItem_descriptor,
        new String[] { "Topic", "Url", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
