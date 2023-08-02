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

package org.apache.eventmesh.runtime.core.producer;

import java.util.Objects;

public class ProducerGroupConf {

    private String groupName;
    private String sysId;
    private String token;

    public ProducerGroupConf(String groupName) {
        this.groupName = groupName;
    }

    public ProducerGroupConf(String groupName, String token) {
        this.groupName = groupName;
        this.token = token;
    }

    public ProducerGroupConf(String groupName, String sysId, String token) {
        this.sysId = sysId;
        this.groupName = groupName;
        this.token = token;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getToken() {
        return token;
    }

    public String getSysId() {
        return sysId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("producerGroupConfig={")
            .append("groupName=").append(groupName).append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProducerGroupConf that = (ProducerGroupConf) o;

        return Objects.equals(groupName, that.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName);
    }
}
