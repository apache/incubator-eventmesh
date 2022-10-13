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

package org.apache.eventmesh.runtime.boot;

import org.apache.eventmesh.common.config.ConfigurationWrapper;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class EventMeshServerTest {

    private ConfigurationWrapper wrapper;

    @Before
    public void before() {
        String file = EventMeshServerTest.class.getResource("/eventmesh.properties").getFile();
        File f = new File(file);
        System.setProperty("confPath", f.getParent());
        wrapper = new ConfigurationWrapper(f.getParent(), f.getName(), false);
    }

    @Test
    public void test() throws Exception {
        EventMeshServer server = new EventMeshServer(wrapper);
        server.init();
        server.start();
        server.shutdown();
    }
}
