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

package org.apache.eventmesh.common.protocol.http.header.message;

import static org.junit.Assert.assertEquals;

import org.apache.eventmesh.common.Constants;
import org.apache.eventmesh.common.protocol.http.common.ProtocolKey;
import org.apache.eventmesh.common.protocol.http.common.ProtocolVersion;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableMap;

public class PushMessageRequestHeaderTest {

    private PushMessageRequestHeader header;

    @Before
    public void before() {
        Map<String, Object> headerParam = ImmutableMap.of(
                ProtocolKey.REQUEST_CODE, 200,
                ProtocolKey.LANGUAGE, Constants.LANGUAGE_JAVA,
                ProtocolKey.VERSION, "1.0",
                ProtocolKey.EventMeshInstanceKey.EVENTMESHCLUSTER, "default cluster",
                ProtocolKey.EventMeshInstanceKey.EVENTMESHIP, "127.0.0.1",
                ProtocolKey.EventMeshInstanceKey.EVENTMESHENV, "DEV",
                ProtocolKey.EventMeshInstanceKey.EVENTMESHIDC, "IDC"
        );
        header = PushMessageRequestHeader.buildHeader(headerParam);
    }

    @Test
    public void testToMap() {
        Map<String, Object> map = header.toMap();
        assertEquals(200, map.get(ProtocolKey.REQUEST_CODE));
        assertEquals(Constants.LANGUAGE_JAVA, map.get(ProtocolKey.LANGUAGE));
        assertEquals(ProtocolVersion.V1, map.get(ProtocolKey.VERSION));
        assertEquals("default cluster", map.get(ProtocolKey.EventMeshInstanceKey.EVENTMESHCLUSTER));
        assertEquals("127.0.0.1", map.get(ProtocolKey.EventMeshInstanceKey.EVENTMESHIP));
        assertEquals("DEV", map.get(ProtocolKey.EventMeshInstanceKey.EVENTMESHENV));
        assertEquals("IDC", map.get(ProtocolKey.EventMeshInstanceKey.EVENTMESHIDC));
    }
}
