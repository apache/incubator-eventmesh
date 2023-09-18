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

import java.util.Objects;

/**
 * Protobuf type {@code eventmesh.catalog.api.protocol.RegistryResponse}
 */
@SuppressWarnings({"all"})
public final class RegistryResponse
        extends
            com.google.protobuf.GeneratedMessageV3
        implements
            // @@protoc_insertion_point(message_implements:eventmesh.catalog.api.protocol.RegistryResponse)
            RegistryResponseOrBuilder {

    private static final long serialVersionUID = 5690543722366991453L;

    // Use RegistryResponse.newBuilder() to construct.
    private RegistryResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private RegistryResponse() {
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
                                 UnusedPrivateParameter unused) {
        return new RegistryResponse();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private RegistryResponse(
                             com.google.protobuf.CodedInputStream input,
                             com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                                                                                          throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        Objects.requireNonNull(input, "CodedInputStream can not be null");
        Objects.requireNonNull(extensionRegistry, "ExtensionRegistryLite can not be null");

        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                com.google.protobuf.UnknownFieldSet.newBuilder();
        try {
            boolean done = false;
            while (!done) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        done = true;
                        break;
                    default: {
                        if (!parseUnknownField(
                                input, unknownFields, extensionRegistry, tag)) {
                            done = true;
                        }
                        break;
                    }
                }
            }
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(this);
        } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(
                    e).setUnfinishedMessage(this);
        } finally {
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_RegistryResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable internalGetFieldAccessorTable() {
        return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_RegistryResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        RegistryResponse.class, Builder.class);
    }

    private byte memoizedIsInitialized = -1;

    @Override
    public final boolean isInitialized() {
        if (memoizedIsInitialized == 1) {
            return true;
        }
        if (memoizedIsInitialized == 0) {
            return false;
        }

        memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) {
            return size;
        }

        size = 0;
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return memoizedSize;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegistryResponse)) {
            return super.equals(obj);
        }
        RegistryResponse other = (RegistryResponse) obj;

        if (!unknownFields.equals(other.unknownFields)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static RegistryResponse parseFrom(
                                             java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RegistryResponse parseFrom(
                                             java.nio.ByteBuffer data,
                                             com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RegistryResponse parseFrom(
                                             com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RegistryResponse parseFrom(
                                             com.google.protobuf.ByteString data,
                                             com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RegistryResponse parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static RegistryResponse parseFrom(
                                             byte[] data,
                                             com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static RegistryResponse parseFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static RegistryResponse parseFrom(
                                             java.io.InputStream input,
                                             com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static RegistryResponse parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static RegistryResponse parseDelimitedFrom(
                                                      java.io.InputStream input,
                                                      com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static RegistryResponse parseFrom(
                                             com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static RegistryResponse parseFrom(
                                             com.google.protobuf.CodedInputStream input,
                                             com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @Override
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(RegistryResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override
    public Builder toBuilder() {
        return this.equals(DEFAULT_INSTANCE)
                ? new Builder()
                : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(BuilderParent parent) {
        return new Builder(parent);
    }

    /**
     * Protobuf type {@code eventmesh.catalog.api.protocol.RegistryResponse}
     */
    public static final class Builder
            extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder>
            implements
                // @@protoc_insertion_point(builder_implements:eventmesh.catalog.api.protocol.RegistryResponse)
                RegistryResponseOrBuilder {

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_RegistryResponse_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_RegistryResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            RegistryResponse.class, Builder.class);
        }

        // Construct using org.apache.eventmesh.common.protocol.catalog.protos.RegistryResponse.newBuilder()
        private Builder() {
            maybeForceBuilderInitialization();
        }

        private Builder(
                        BuilderParent parent) {
            super(parent);
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_RegistryResponse_descriptor;
        }

        @Override
        public RegistryResponse getDefaultInstanceForType() {
            return RegistryResponse.getDefaultInstance();
        }

        @Override
        public RegistryResponse build() {
            RegistryResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public RegistryResponse buildPartial() {
            RegistryResponse result = new RegistryResponse(this);
            onBuilt();
            return result;
        }

        @Override
        public Builder clone() {
            return super.clone();
        }

        @Override
        public Builder setField(
                                com.google.protobuf.Descriptors.FieldDescriptor field,
                                Object value) {
            return super.setField(field, value);
        }

        @Override
        public Builder clearField(
                                  com.google.protobuf.Descriptors.FieldDescriptor field) {
            return super.clearField(field);
        }

        @Override
        public Builder clearOneof(
                                  com.google.protobuf.Descriptors.OneofDescriptor oneof) {
            return super.clearOneof(oneof);
        }

        @Override
        public Builder setRepeatedField(
                                        com.google.protobuf.Descriptors.FieldDescriptor field,
                                        int index, Object value) {
            return super.setRepeatedField(field, index, value);
        }

        @Override
        public Builder addRepeatedField(
                                        com.google.protobuf.Descriptors.FieldDescriptor field,
                                        Object value) {
            return super.addRepeatedField(field, value);
        }

        @Override
        public Builder mergeFrom(com.google.protobuf.Message other) {
            if (other instanceof RegistryResponse) {
                return mergeFrom((RegistryResponse) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(RegistryResponse other) {
            if (other.equals(RegistryResponse.getDefaultInstance())) {
                return this;
            }
            this.mergeUnknownFields(other.unknownFields);
            onChanged();
            return this;
        }

        @Override
        public final boolean isInitialized() {
            return true;
        }

        @Override
        public Builder mergeFrom(
                                 com.google.protobuf.CodedInputStream input,
                                 com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
            RegistryResponse parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (RegistryResponse) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        @Override
        public final Builder setUnknownFields(
                                              final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.setUnknownFields(unknownFields);
        }

        @Override
        public final Builder mergeUnknownFields(
                                                final com.google.protobuf.UnknownFieldSet unknownFields) {
            return super.mergeUnknownFields(unknownFields);
        }

        // @@protoc_insertion_point(builder_scope:eventmesh.catalog.api.protocol.RegistryResponse)
    }

    // @@protoc_insertion_point(class_scope:eventmesh.catalog.api.protocol.RegistryResponse)
    private static final RegistryResponse DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new RegistryResponse();
    }

    public static RegistryResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<RegistryResponse> PARSER = new com.google.protobuf.AbstractParser<RegistryResponse>() {

        @Override
        public RegistryResponse parsePartialFrom(
                                                 com.google.protobuf.CodedInputStream input,
                                                 com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
            return new RegistryResponse(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<RegistryResponse> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<RegistryResponse> getParserForType() {
        return PARSER;
    }

    @Override
    public RegistryResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
