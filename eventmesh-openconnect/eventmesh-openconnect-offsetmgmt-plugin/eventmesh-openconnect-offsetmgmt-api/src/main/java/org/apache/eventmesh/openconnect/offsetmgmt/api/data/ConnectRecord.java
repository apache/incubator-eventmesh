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

package org.apache.eventmesh.openconnect.offsetmgmt.api.data;

import java.util.Objects;
import java.util.Set;

/**
 * SourceDataEntries are generated by SourceTasks and passed to specific message queue to store.
 */
public class ConnectRecord {

    private Long timestamp;

    private Object data;

    private RecordPosition position;

    private KeyValue extensions;

    public ConnectRecord(RecordPartition recordPartition, RecordOffset recordOffset,
                         Long timestamp) {
        this(recordPartition, recordOffset, timestamp, null);
    }

    public ConnectRecord(RecordPartition recordPartition, RecordOffset recordOffset,
                         Long timestamp, Object data) {
        this.position = new RecordPosition(recordPartition, recordOffset);
        this.timestamp = timestamp;
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public KeyValue getExtensions() {
        return extensions;
    }

    public void setExtensions(KeyValue extensions) {
        this.extensions = extensions;
    }

    public RecordPosition getPosition() {
        return position;
    }

    public void setPosition(RecordPosition position) {
        this.position = position;
    }

    public void addExtension(KeyValue extensions) {
        if (this.extensions == null) {
            this.extensions = new DefaultKeyValue();
        }
        Set<String> keySet = extensions.keySet();
        for (String key : keySet) {
            this.extensions.put(key, extensions.getString(key));
        }
    }

    public void addExtension(String key, String value) {
        if (this.extensions == null) {
            this.extensions = new DefaultKeyValue();
        }
        this.extensions.put(key, value);
    }

    public String getExtension(String key) {
        if (this.extensions == null) {
            return null;
        }
        return this.extensions.getString(key);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConnectRecord)) {
            return false;
        }
        ConnectRecord that = (ConnectRecord) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(data, that.data)
                && Objects.equals(position, that.position) && Objects.equals(extensions, that.extensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, data, position, extensions);
    }

    @Override
    public String toString() {
        return "ConnectRecord{"
                + "timestamp=" + timestamp
                + ", data=" + data
                + ", position=" + position
                + ", extensions=" + extensions
                + "}";
    }
}
