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

/**
 * Protobuf type {@code eventmesh.catalog.api.protocol.QueryOperationsResponse}
 */
@SuppressWarnings({"all"})
public final class QueryOperationsResponse
        extends
            com.google.protobuf.GeneratedMessageV3
        implements
            // @@protoc_insertion_point(message_implements:eventmesh.catalog.api.protocol.QueryOperationsResponse)
            QueryOperationsResponseOrBuilder {

    private static final long serialVersionUID = 0L;

    // Use QueryOperationsResponse.newBuilder() to construct.
    private QueryOperationsResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private QueryOperationsResponse() {
        operations_ = java.util.Collections.emptyList();
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
                                 UnusedPrivateParameter unused) {
        return new QueryOperationsResponse();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private QueryOperationsResponse(
                                    com.google.protobuf.CodedInputStream input,
                                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                                                                                                 throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
        int mutable_bitField0_ = 0;
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
                    case 10: {
                        if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                            operations_ = new java.util.ArrayList<Operation>();
                            mutable_bitField0_ |= 0x00000001;
                        }
                        operations_.add(
                                input.readMessage(Operation.parser(), extensionRegistry));
                        break;
                    }
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
            if (((mutable_bitField0_ & 0x00000001) != 0)) {
                operations_ = java.util.Collections.unmodifiableList(operations_);
            }
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_descriptor;
    }

    @Override
    protected FieldAccessorTable internalGetFieldAccessorTable() {
        return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        QueryOperationsResponse.class, Builder.class);
    }

    public static final int OPERATIONS_FIELD_NUMBER = 1;
    private java.util.List<Operation> operations_;

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    @Override
    public java.util.List<Operation> getOperationsList() {
        return operations_;
    }

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    @Override
    public java.util.List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
        return operations_;
    }

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    @Override
    public int getOperationsCount() {
        return operations_.size();
    }

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    @Override
    public Operation getOperations(int index) {
        return operations_.get(index);
    }

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    @Override
    public OperationOrBuilder getOperationsOrBuilder(
                                                     int index) {
        return operations_.get(index);
    }

    private byte memoizedIsInitialized = -1;

    @Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1) {
            return true;
        }
        if (isInitialized == 0) {
            return false;
        }

        memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        for (Operation operation : operations_) {
            output.writeMessage(1, operation);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1) {
            return size;
        }

        size = 0;
        for (Operation operation : operations_) {
            size += com.google.protobuf.CodedOutputStream
                    .computeMessageSize(1, operation);
        }
        size += unknownFields.getSerializedSize();
        memoizedSize = size;
        return size;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QueryOperationsResponse)) {
            return super.equals(obj);
        }
        QueryOperationsResponse other = (QueryOperationsResponse) obj;

        if (!getOperationsList()
                .equals(other.getOperationsList())) {
            return false;
        }
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
        if (getOperationsCount() > 0) {
            hash = (37 * hash) + OPERATIONS_FIELD_NUMBER;
            hash = (53 * hash) + getOperationsList().hashCode();
        }
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static QueryOperationsResponse parseFrom(
                                                    java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static QueryOperationsResponse parseFrom(
                                                    java.nio.ByteBuffer data,
                                                    com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static QueryOperationsResponse parseFrom(
                                                    com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static QueryOperationsResponse parseFrom(
                                                    com.google.protobuf.ByteString data,
                                                    com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static QueryOperationsResponse parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static QueryOperationsResponse parseFrom(
                                                    byte[] data,
                                                    com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static QueryOperationsResponse parseFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static QueryOperationsResponse parseFrom(
                                                    java.io.InputStream input,
                                                    com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static QueryOperationsResponse parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static QueryOperationsResponse parseDelimitedFrom(
                                                             java.io.InputStream input,
                                                             com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static QueryOperationsResponse parseFrom(
                                                    com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static QueryOperationsResponse parseFrom(
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

    public static Builder newBuilder(QueryOperationsResponse prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    @Override
    public Builder toBuilder() {
        return this.equals(DEFAULT_INSTANCE)
                ? new Builder()
                : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
                                        BuilderParent parent) {
        return new Builder(parent);
    }

    /**
     * Protobuf type {@code eventmesh.catalog.api.protocol.QueryOperationsResponse}
     */
    public static final class Builder
            extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder>
            implements
                // @@protoc_insertion_point(builder_implements:eventmesh.catalog.api.protocol.QueryOperationsResponse)
                QueryOperationsResponseOrBuilder {

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            QueryOperationsResponse.class, Builder.class);
        }

        // Construct using org.apache.eventmesh.common.protocol.catalog.protos.QueryOperationsResponse.newBuilder()
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
                getOperationsFieldBuilder();
            }
        }

        @Override
        public Builder clear() {
            super.clear();
            if (operationsBuilder_ == null) {
                operations_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
            } else {
                operationsBuilder_.clear();
            }
            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return EventmeshCatalogGrpc.internal_static_eventmesh_catalog_api_protocol_QueryOperationsResponse_descriptor;
        }

        @Override
        public QueryOperationsResponse getDefaultInstanceForType() {
            return QueryOperationsResponse.getDefaultInstance();
        }

        @Override
        public QueryOperationsResponse build() {
            QueryOperationsResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public QueryOperationsResponse buildPartial() {
            QueryOperationsResponse result = new QueryOperationsResponse(this);
            int from_bitField0_ = bitField0_;
            if (operationsBuilder_ == null) {
                if (((bitField0_ & 0x00000001) != 0)) {
                    operations_ = java.util.Collections.unmodifiableList(operations_);
                    bitField0_ = (bitField0_ & ~0x00000001);
                }
                result.operations_ = operations_;
            } else {
                result.operations_ = operationsBuilder_.build();
            }
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
            if (other instanceof QueryOperationsResponse) {
                return mergeFrom((QueryOperationsResponse) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(QueryOperationsResponse other) {
            if (other.equals(QueryOperationsResponse.getDefaultInstance())) {
                return this;
            }
            if (operationsBuilder_ == null) {
                if (!other.operations_.isEmpty()) {
                    if (operations_.isEmpty()) {
                        operations_ = other.operations_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                    } else {
                        ensureOperationsIsMutable();
                        operations_.addAll(other.operations_);
                    }
                    onChanged();
                }
            } else {
                if (!other.operations_.isEmpty()) {
                    if (operationsBuilder_.isEmpty()) {
                        operationsBuilder_.dispose();
                        operationsBuilder_ = null;
                        operations_ = other.operations_;
                        bitField0_ = (bitField0_ & ~0x00000001);
                        operationsBuilder_ =
                                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getOperationsFieldBuilder() : null;
                    } else {
                        operationsBuilder_.addAllMessages(other.operations_);
                    }
                }
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
            QueryOperationsResponse parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (QueryOperationsResponse) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private int bitField0_;

        private java.util.List<Operation> operations_ =
                java.util.Collections.emptyList();

        private void ensureOperationsIsMutable() {
            if (!((bitField0_ & 0x00000001) != 0)) {
                operations_ = new java.util.ArrayList<Operation>(operations_);
                bitField0_ |= 0x00000001;
            }
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> operationsBuilder_;

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public java.util.List<Operation> getOperationsList() {
            if (operationsBuilder_ == null) {
                return java.util.Collections.unmodifiableList(operations_);
            } else {
                return operationsBuilder_.getMessageList();
            }
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public int getOperationsCount() {
            if (operationsBuilder_ == null) {
                return operations_.size();
            } else {
                return operationsBuilder_.getCount();
            }
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Operation getOperations(int index) {
            if (operationsBuilder_ == null) {
                return operations_.get(index);
            } else {
                return operationsBuilder_.getMessage(index);
            }
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder setOperations(
                                     int index, Operation value) {
            if (operationsBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureOperationsIsMutable();
                operations_.set(index, value);
                onChanged();
            } else {
                operationsBuilder_.setMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder setOperations(
                                     int index, Operation.Builder builderForValue) {
            if (operationsBuilder_ == null) {
                ensureOperationsIsMutable();
                operations_.set(index, builderForValue.build());
                onChanged();
            } else {
                operationsBuilder_.setMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder addOperations(Operation value) {
            if (operationsBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureOperationsIsMutable();
                operations_.add(value);
                onChanged();
            } else {
                operationsBuilder_.addMessage(value);
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder addOperations(
                                     int index, Operation value) {
            if (operationsBuilder_ == null) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureOperationsIsMutable();
                operations_.add(index, value);
                onChanged();
            } else {
                operationsBuilder_.addMessage(index, value);
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder addOperations(
                                     Operation.Builder builderForValue) {
            if (operationsBuilder_ == null) {
                ensureOperationsIsMutable();
                operations_.add(builderForValue.build());
                onChanged();
            } else {
                operationsBuilder_.addMessage(builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder addOperations(
                                     int index, Operation.Builder builderForValue) {
            if (operationsBuilder_ == null) {
                ensureOperationsIsMutable();
                operations_.add(index, builderForValue.build());
                onChanged();
            } else {
                operationsBuilder_.addMessage(index, builderForValue.build());
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder addAllOperations(
                                        Iterable<? extends Operation> values) {
            if (operationsBuilder_ == null) {
                ensureOperationsIsMutable();
                com.google.protobuf.AbstractMessageLite.Builder.addAll(
                        values, operations_);
                onChanged();
            } else {
                operationsBuilder_.addAllMessages(values);
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder clearOperations() {
            if (operationsBuilder_ == null) {
                operations_ = java.util.Collections.emptyList();
                bitField0_ = (bitField0_ & ~0x00000001);
                onChanged();
            } else {
                operationsBuilder_.clear();
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Builder removeOperations(int index) {
            if (operationsBuilder_ == null) {
                ensureOperationsIsMutable();
                operations_.remove(index);
                onChanged();
            } else {
                operationsBuilder_.remove(index);
            }
            return this;
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Operation.Builder getOperationsBuilder(
                                                      int index) {
            return getOperationsFieldBuilder().getBuilder(index);
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public OperationOrBuilder getOperationsOrBuilder(
                                                         int index) {
            if (operationsBuilder_ == null) {
                return operations_.get(index);
            } else {
                return operationsBuilder_.getMessageOrBuilder(index);
            }
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public java.util.List<? extends OperationOrBuilder> getOperationsOrBuilderList() {
            if (operationsBuilder_ != null) {
                return operationsBuilder_.getMessageOrBuilderList();
            } else {
                return java.util.Collections.unmodifiableList(operations_);
            }
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Operation.Builder addOperationsBuilder() {
            return getOperationsFieldBuilder().addBuilder(
                    Operation.getDefaultInstance());
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public Operation.Builder addOperationsBuilder(
                                                      int index) {
            return getOperationsFieldBuilder().addBuilder(
                    index, Operation.getDefaultInstance());
        }

        /**
         * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
         */
        public java.util.List<Operation.Builder> getOperationsBuilderList() {
            return getOperationsFieldBuilder().getBuilderList();
        }

        private com.google.protobuf.RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder> getOperationsFieldBuilder() {
            if (operationsBuilder_ == null) {
                operationsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<Operation, Operation.Builder, OperationOrBuilder>(
                        operations_,
                        ((bitField0_ & 0x00000001) != 0),
                        getParentForChildren(),
                        isClean());
                operations_ = null;
            }
            return operationsBuilder_;
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

        // @@protoc_insertion_point(builder_scope:eventmesh.catalog.api.protocol.QueryOperationsResponse)
    }

    // @@protoc_insertion_point(class_scope:eventmesh.catalog.api.protocol.QueryOperationsResponse)
    private static final QueryOperationsResponse DEFAULT_INSTANCE;

    static {
        DEFAULT_INSTANCE = new QueryOperationsResponse();
    }

    public static QueryOperationsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<QueryOperationsResponse> PARSER =
            new com.google.protobuf.AbstractParser<QueryOperationsResponse>() {

                @Override
                public QueryOperationsResponse parsePartialFrom(
                                                                com.google.protobuf.CodedInputStream input,
                                                                com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
                    return new QueryOperationsResponse(input, extensionRegistry);
                }
            };

    public static com.google.protobuf.Parser<QueryOperationsResponse> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<QueryOperationsResponse> getParserForType() {
        return PARSER;
    }

    @Override
    public QueryOperationsResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
