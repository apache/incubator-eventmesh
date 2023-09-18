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

package org.apache.eventmesh.common.protocol.workflow.protos;

/**
 * Protobuf type {@code eventmesh.workflow.api.protocol.ExecuteRequest}
 */
@SuppressWarnings({"all"})
public final class ExecuteRequest
        extends
            com.google.protobuf.GeneratedMessageV3
        implements
            // @@protoc_insertion_point(message_implements:eventmesh.workflow.api.protocol.ExecuteRequest)
            ExecuteRequestOrBuilder {

    private static final long serialVersionUID = 0L;
    // Use ExecuteRequest.newBuilder() to construct.
    private ExecuteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }
    private ExecuteRequest() {
        id_ = "";
        instanceId_ = "";
        taskInstanceId_ = "";
        input_ = "";
    }

    @Override
    @SuppressWarnings({"unused"})
    protected Object newInstance(
                                 UnusedPrivateParameter unused) {
        return new ExecuteRequest();
    }

    @Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }
    private ExecuteRequest(
                           com.google.protobuf.CodedInputStream input,
                           com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                                                                                        throws com.google.protobuf.InvalidProtocolBufferException {
        this();
        if (extensionRegistry == null) {
            throw new NullPointerException();
        }
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
                        String s = input.readStringRequireUtf8();

                        id_ = s;
                        break;
                    }
                    case 18: {
                        String s = input.readStringRequireUtf8();

                        instanceId_ = s;
                        break;
                    }
                    case 26: {
                        String s = input.readStringRequireUtf8();

                        taskInstanceId_ = s;
                        break;
                    }
                    case 34: {
                        String s = input.readStringRequireUtf8();

                        input_ = s;
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
            this.unknownFields = unknownFields.build();
            makeExtensionsImmutable();
        }
    }
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return EventmeshWorkflowGrpc.internal_static_eventmesh_workflow_api_protocol_ExecuteRequest_descriptor;
    }

    @Override
    protected FieldAccessorTable internalGetFieldAccessorTable() {
        return EventmeshWorkflowGrpc.internal_static_eventmesh_workflow_api_protocol_ExecuteRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        ExecuteRequest.class, Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private volatile Object id_;
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    @Override
    public String getId() {
        Object ref = id_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            id_ = s;
            return s;
        }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    @Override
    public com.google.protobuf.ByteString getIdBytes() {
        Object ref = id_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (String) ref);
            id_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int INSTANCE_ID_FIELD_NUMBER = 2;
    private volatile Object instanceId_;
    /**
     * <code>string instance_id = 2;</code>
     * @return The instanceId.
     */
    @Override
    public String getInstanceId() {
        Object ref = instanceId_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            instanceId_ = s;
            return s;
        }
    }
    /**
     * <code>string instance_id = 2;</code>
     * @return The bytes for instanceId.
     */
    @Override
    public com.google.protobuf.ByteString getInstanceIdBytes() {
        Object ref = instanceId_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (String) ref);
            instanceId_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int TASK_INSTANCE_ID_FIELD_NUMBER = 3;
    private volatile Object taskInstanceId_;
    /**
     * <code>string task_instance_id = 3;</code>
     * @return The taskInstanceId.
     */
    @Override
    public String getTaskInstanceId() {
        Object ref = taskInstanceId_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            taskInstanceId_ = s;
            return s;
        }
    }
    /**
     * <code>string task_instance_id = 3;</code>
     * @return The bytes for taskInstanceId.
     */
    @Override
    public com.google.protobuf.ByteString getTaskInstanceIdBytes() {
        Object ref = taskInstanceId_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (String) ref);
            taskInstanceId_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int INPUT_FIELD_NUMBER = 4;
    private volatile Object input_;
    /**
     * <code>string input = 4;</code>
     * @return The input.
     */
    @Override
    public String getInput() {
        Object ref = input_;
        if (ref instanceof String) {
            return (String) ref;
        } else {
            com.google.protobuf.ByteString bs =
                    (com.google.protobuf.ByteString) ref;
            String s = bs.toStringUtf8();
            input_ = s;
            return s;
        }
    }
    /**
     * <code>string input = 4;</code>
     * @return The bytes for input.
     */
    @Override
    public com.google.protobuf.ByteString getInputBytes() {
        Object ref = input_;
        if (ref instanceof String) {
            com.google.protobuf.ByteString b =
                    com.google.protobuf.ByteString.copyFromUtf8(
                            (String) ref);
            input_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    private byte memoizedIsInitialized = -1;
    @Override
    public final boolean isInitialized() {
        byte isInitialized = memoizedIsInitialized;
        if (isInitialized == 1)
            return true;
        if (isInitialized == 0)
            return false;

        memoizedIsInitialized = 1;
        return true;
    }

    @Override
    public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
        if (!getIdBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
        }
        if (!getInstanceIdBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, instanceId_);
        }
        if (!getTaskInstanceIdBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 3, taskInstanceId_);
        }
        if (!getInputBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 4, input_);
        }
        unknownFields.writeTo(output);
    }

    @Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1)
            return size;

        size = 0;
        if (!getIdBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
        }
        if (!getInstanceIdBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, instanceId_);
        }
        if (!getTaskInstanceIdBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, taskInstanceId_);
        }
        if (!getInputBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, input_);
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
        if (!(obj instanceof ExecuteRequest)) {
            return super.equals(obj);
        }
        ExecuteRequest other = (ExecuteRequest) obj;

        if (!getId()
                .equals(other.getId()))
            return false;
        if (!getInstanceId()
                .equals(other.getInstanceId()))
            return false;
        if (!getTaskInstanceId()
                .equals(other.getTaskInstanceId()))
            return false;
        if (!getInput()
                .equals(other.getInput()))
            return false;
        if (!unknownFields.equals(other.unknownFields))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        if (memoizedHashCode != 0) {
            return memoizedHashCode;
        }
        int hash = 41;
        hash = (19 * hash) + getDescriptor().hashCode();
        hash = (37 * hash) + ID_FIELD_NUMBER;
        hash = (53 * hash) + getId().hashCode();
        hash = (37 * hash) + INSTANCE_ID_FIELD_NUMBER;
        hash = (53 * hash) + getInstanceId().hashCode();
        hash = (37 * hash) + TASK_INSTANCE_ID_FIELD_NUMBER;
        hash = (53 * hash) + getTaskInstanceId().hashCode();
        hash = (37 * hash) + INPUT_FIELD_NUMBER;
        hash = (53 * hash) + getInput().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static ExecuteRequest parseFrom(
                                           java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static ExecuteRequest parseFrom(
                                           java.nio.ByteBuffer data,
                                           com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ExecuteRequest parseFrom(
                                           com.google.protobuf.ByteString data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static ExecuteRequest parseFrom(
                                           com.google.protobuf.ByteString data,
                                           com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ExecuteRequest parseFrom(byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }
    public static ExecuteRequest parseFrom(
                                           byte[] data,
                                           com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ExecuteRequest parseFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }
    public static ExecuteRequest parseFrom(
                                           java.io.InputStream input,
                                           com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ExecuteRequest parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }
    public static ExecuteRequest parseDelimitedFrom(
                                                    java.io.InputStream input,
                                                    com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ExecuteRequest parseFrom(
                                           com.google.protobuf.CodedInputStream input) throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }
    public static ExecuteRequest parseFrom(
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
    public static Builder newBuilder(ExecuteRequest prototype) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @Override
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE
                ? new Builder()
                : new Builder().mergeFrom(this);
    }

    @Override
    protected Builder newBuilderForType(
                                        BuilderParent parent) {
        return new Builder(parent);
    }
    /**
     * Protobuf type {@code eventmesh.workflow.api.protocol.ExecuteRequest}
     */
    public static final class Builder
            extends
                com.google.protobuf.GeneratedMessageV3.Builder<Builder>
            implements
                // @@protoc_insertion_point(builder_implements:eventmesh.workflow.api.protocol.ExecuteRequest)
                ExecuteRequestOrBuilder {

        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return EventmeshWorkflowGrpc.internal_static_eventmesh_workflow_api_protocol_ExecuteRequest_descriptor;
        }

        @Override
        protected FieldAccessorTable internalGetFieldAccessorTable() {
            return EventmeshWorkflowGrpc.internal_static_eventmesh_workflow_api_protocol_ExecuteRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            ExecuteRequest.class, Builder.class);
        }

        // Construct using org.apache.eventmesh.common.protocol.workflow.protos.ExecuteRequest.newBuilder()
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
            id_ = "";

            instanceId_ = "";

            taskInstanceId_ = "";

            input_ = "";

            return this;
        }

        @Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return EventmeshWorkflowGrpc.internal_static_eventmesh_workflow_api_protocol_ExecuteRequest_descriptor;
        }

        @Override
        public ExecuteRequest getDefaultInstanceForType() {
            return ExecuteRequest.getDefaultInstance();
        }

        @Override
        public ExecuteRequest build() {
            ExecuteRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @Override
        public ExecuteRequest buildPartial() {
            ExecuteRequest result = new ExecuteRequest(this);
            result.id_ = id_;
            result.instanceId_ = instanceId_;
            result.taskInstanceId_ = taskInstanceId_;
            result.input_ = input_;
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
            if (other instanceof ExecuteRequest) {
                return mergeFrom((ExecuteRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(ExecuteRequest other) {
            if (other == ExecuteRequest.getDefaultInstance())
                return this;
            if (!other.getId().isEmpty()) {
                id_ = other.id_;
                onChanged();
            }
            if (!other.getInstanceId().isEmpty()) {
                instanceId_ = other.instanceId_;
                onChanged();
            }
            if (!other.getTaskInstanceId().isEmpty()) {
                taskInstanceId_ = other.taskInstanceId_;
                onChanged();
            }
            if (!other.getInput().isEmpty()) {
                input_ = other.input_;
                onChanged();
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
            ExecuteRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (ExecuteRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private Object id_ = "";
        /**
         * <code>string id = 1;</code>
         * @return The id.
         */
        public String getId() {
            Object ref = id_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                id_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }
        /**
         * <code>string id = 1;</code>
         * @return The bytes for id.
         */
        public com.google.protobuf.ByteString getIdBytes() {
            Object ref = id_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                id_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }
        /**
         * <code>string id = 1;</code>
         * @param value The id to set.
         * @return This builder for chaining.
         */
        public Builder setId(
                             String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            id_ = value;
            onChanged();
            return this;
        }
        /**
         * <code>string id = 1;</code>
         * @return This builder for chaining.
         */
        public Builder clearId() {

            id_ = getDefaultInstance().getId();
            onChanged();
            return this;
        }
        /**
         * <code>string id = 1;</code>
         * @param value The bytes for id to set.
         * @return This builder for chaining.
         */
        public Builder setIdBytes(
                                  com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            id_ = value;
            onChanged();
            return this;
        }

        private Object instanceId_ = "";
        /**
         * <code>string instance_id = 2;</code>
         * @return The instanceId.
         */
        public String getInstanceId() {
            Object ref = instanceId_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                instanceId_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }
        /**
         * <code>string instance_id = 2;</code>
         * @return The bytes for instanceId.
         */
        public com.google.protobuf.ByteString getInstanceIdBytes() {
            Object ref = instanceId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                instanceId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }
        /**
         * <code>string instance_id = 2;</code>
         * @param value The instanceId to set.
         * @return This builder for chaining.
         */
        public Builder setInstanceId(
                                     String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            instanceId_ = value;
            onChanged();
            return this;
        }
        /**
         * <code>string instance_id = 2;</code>
         * @return This builder for chaining.
         */
        public Builder clearInstanceId() {

            instanceId_ = getDefaultInstance().getInstanceId();
            onChanged();
            return this;
        }
        /**
         * <code>string instance_id = 2;</code>
         * @param value The bytes for instanceId to set.
         * @return This builder for chaining.
         */
        public Builder setInstanceIdBytes(
                                          com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            instanceId_ = value;
            onChanged();
            return this;
        }

        private Object taskInstanceId_ = "";
        /**
         * <code>string task_instance_id = 3;</code>
         * @return The taskInstanceId.
         */
        public String getTaskInstanceId() {
            Object ref = taskInstanceId_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                taskInstanceId_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }
        /**
         * <code>string task_instance_id = 3;</code>
         * @return The bytes for taskInstanceId.
         */
        public com.google.protobuf.ByteString getTaskInstanceIdBytes() {
            Object ref = taskInstanceId_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                taskInstanceId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }
        /**
         * <code>string task_instance_id = 3;</code>
         * @param value The taskInstanceId to set.
         * @return This builder for chaining.
         */
        public Builder setTaskInstanceId(
                                         String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            taskInstanceId_ = value;
            onChanged();
            return this;
        }
        /**
         * <code>string task_instance_id = 3;</code>
         * @return This builder for chaining.
         */
        public Builder clearTaskInstanceId() {

            taskInstanceId_ = getDefaultInstance().getTaskInstanceId();
            onChanged();
            return this;
        }
        /**
         * <code>string task_instance_id = 3;</code>
         * @param value The bytes for taskInstanceId to set.
         * @return This builder for chaining.
         */
        public Builder setTaskInstanceIdBytes(
                                              com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            taskInstanceId_ = value;
            onChanged();
            return this;
        }

        private Object input_ = "";
        /**
         * <code>string input = 4;</code>
         * @return The input.
         */
        public String getInput() {
            Object ref = input_;
            if (!(ref instanceof String)) {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                String s = bs.toStringUtf8();
                input_ = s;
                return s;
            } else {
                return (String) ref;
            }
        }
        /**
         * <code>string input = 4;</code>
         * @return The bytes for input.
         */
        public com.google.protobuf.ByteString getInputBytes() {
            Object ref = input_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (String) ref);
                input_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }
        /**
         * <code>string input = 4;</code>
         * @param value The input to set.
         * @return This builder for chaining.
         */
        public Builder setInput(
                                String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            input_ = value;
            onChanged();
            return this;
        }
        /**
         * <code>string input = 4;</code>
         * @return This builder for chaining.
         */
        public Builder clearInput() {

            input_ = getDefaultInstance().getInput();
            onChanged();
            return this;
        }
        /**
         * <code>string input = 4;</code>
         * @param value The bytes for input to set.
         * @return This builder for chaining.
         */
        public Builder setInputBytes(
                                     com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            input_ = value;
            onChanged();
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

        // @@protoc_insertion_point(builder_scope:eventmesh.workflow.api.protocol.ExecuteRequest)
    }

    // @@protoc_insertion_point(class_scope:eventmesh.workflow.api.protocol.ExecuteRequest)
    private static final ExecuteRequest DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE = new ExecuteRequest();
    }

    public static ExecuteRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ExecuteRequest> PARSER = new com.google.protobuf.AbstractParser<ExecuteRequest>() {

        @Override
        public ExecuteRequest parsePartialFrom(
                                               com.google.protobuf.CodedInputStream input,
                                               com.google.protobuf.ExtensionRegistryLite extensionRegistry) throws com.google.protobuf.InvalidProtocolBufferException {
            return new ExecuteRequest(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<ExecuteRequest> parser() {
        return PARSER;
    }

    @Override
    public com.google.protobuf.Parser<ExecuteRequest> getParserForType() {
        return PARSER;
    }

    @Override
    public ExecuteRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
