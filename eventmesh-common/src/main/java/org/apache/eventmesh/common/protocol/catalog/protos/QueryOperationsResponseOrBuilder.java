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
public interface QueryOperationsResponseOrBuilder
        extends
            // @@protoc_insertion_point(interface_extends:eventmesh.catalog.api.protocol.QueryOperationsResponse)
            com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    java.util.List<Operation> getOperationsList();

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    Operation getOperations(int index);

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    int getOperationsCount();

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    java.util.List<? extends OperationOrBuilder> getOperationsOrBuilderList();

    /**
     * <code>repeated .eventmesh.catalog.api.protocol.Operation operations = 1;</code>
     */
    OperationOrBuilder getOperationsOrBuilder(
                                              int index);
}
