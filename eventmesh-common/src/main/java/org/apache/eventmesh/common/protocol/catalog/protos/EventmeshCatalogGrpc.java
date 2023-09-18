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

package org.apache.eventmesh.common.protocol.catalog.protos;

@SuppressWarnings({"all"})
public final class EventmeshCatalogGrpc {

    private EventmeshCatalogGrpc() {
    }

    public static void registerAllExtensions(
                                             com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
                                             com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_eventmesh_catalog_api_protocol_RegistryRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_eventmesh_catalog_api_protocol_RegistryRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_eventmesh_catalog_api_protocol_RegistryResponse_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_eventmesh_catalog_api_protocol_RegistryResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_eventmesh_catalog_api_protocol_QueryOperationsRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_eventmesh_catalog_api_protocol_QueryOperationsRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_eventmesh_catalog_api_protocol_Operation_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_eventmesh_catalog_api_protocol_Operation_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

    static {
        String[] descriptorData = {
                "\n\rcatalog.proto\022\036eventmesh.catalog.api.p" +
                        "rotocol\"8\n\017RegistryRequest\022\021\n\tfile_name\030" +
                        "\001 \001(\t\022\022\n\ndefinition\030\002 \001(\t\"\022\n\020RegistryRes" +
                        "ponse\"D\n\026QueryOperationsRequest\022\024\n\014servi" +
                        "ce_name\030\001 \001(\t\022\024\n\014operation_id\030\002 \001(\t\"?\n\tO" +
                        "peration\022\024\n\014channel_name\030\001 \001(\t\022\016\n\006schema" +
                        "\030\002 \001(\t\022\014\n\004type\030\003 \001(\t\"X\n\027QueryOperationsR" +
                        "esponse\022=\n\noperations\030\001 \003(\0132).eventmesh." +
                        "catalog.api.protocol.Operation2\201\002\n\007Catal" +
                        "og\022o\n\010Registry\022/.eventmesh.catalog.api.p" +
                        "rotocol.RegistryRequest\0320.eventmesh.cata" +
                        "log.api.protocol.RegistryResponse\"\000\022\204\001\n\017" +
                        "QueryOperations\0226.eventmesh.catalog.api." +
                        "protocol.QueryOperationsRequest\0327.eventm" +
                        "esh.catalog.api.protocol.QueryOperations" +
                        "Response\"\000B\223\001\n3org.apache.eventmesh.comm" +
                        "on.protocol.catalog.protosB\024EventmeshCat" +
                        "alogGrpcP\001ZDgithub.com/apache/incubator-" +
                        "eventmesh/eventmesh-catalog-go/api/proto" +
                        "b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_eventmesh_catalog_api_protocol_RegistryRequest_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_eventmesh_catalog_api_protocol_RegistryRequest_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_eventmesh_catalog_api_protocol_RegistryRequest_descriptor,
                        new String[]{"FileName", "Definition",});
        internal_static_eventmesh_catalog_api_protocol_RegistryResponse_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_eventmesh_catalog_api_protocol_RegistryResponse_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_eventmesh_catalog_api_protocol_RegistryResponse_descriptor,
                        new String[]{});
        internal_static_eventmesh_catalog_api_protocol_QueryOperationsRequest_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_eventmesh_catalog_api_protocol_QueryOperationsRequest_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_eventmesh_catalog_api_protocol_QueryOperationsRequest_descriptor,
                        new String[]{"ServiceName", "OperationId",});
        internal_static_eventmesh_catalog_api_protocol_Operation_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_eventmesh_catalog_api_protocol_Operation_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_eventmesh_catalog_api_protocol_Operation_descriptor,
                new String[]{"ChannelName", "Schema", "Type",});
        internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_fieldAccessorTable =
                new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                        internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_descriptor,
                        new String[]{"Operations",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}
