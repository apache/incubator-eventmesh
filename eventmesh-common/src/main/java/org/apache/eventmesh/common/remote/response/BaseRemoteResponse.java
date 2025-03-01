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

package org.apache.eventmesh.common.remote.response;

import org.apache.eventmesh.common.remote.payload.IPayload;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
public abstract class BaseRemoteResponse<T> implements IPayload {
    @Setter
    private boolean success = true;
    @Setter
    private int errorCode;
    @Setter
    private String desc;

    private Map<String, String> header = new HashMap<>();
    @Setter
    private T data;

    public void addHeader(String key, String value) {
        if (key == null || value == null) {
            return;
        }
        header.put(key, value);
    }

    public void addHeaders(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        map.forEach((k, v) -> {
            if (k == null || v == null) {
                return;
            }
            this.header.put(k, v);
        });
    }
}
