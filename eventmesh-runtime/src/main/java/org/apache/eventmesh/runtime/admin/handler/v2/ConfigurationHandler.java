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

package org.apache.eventmesh.runtime.admin.handler.v2;

import inet.ipaddr.IPAddress;

import org.apache.eventmesh.runtime.admin.handler.AbstractHttpHandler;
import org.apache.eventmesh.runtime.admin.response.v2.GetConfigurationResponse;
import org.apache.eventmesh.runtime.common.EventMeshHttpHandler;
import org.apache.eventmesh.runtime.configuration.EventMeshGrpcConfiguration;
import org.apache.eventmesh.runtime.configuration.EventMeshHTTPConfiguration;
import org.apache.eventmesh.runtime.configuration.EventMeshTCPConfiguration;

import java.util.ArrayList;
import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.filter.ValueFilter;

import lombok.extern.slf4j.Slf4j;

/**
 * This class handles the {@code /v2/configuration} endpoint, corresponding to the {@code eventmesh-dashboard} path {@code /}.
 * <p>
 * This handler is responsible for retrieving the current configuration information of the EventMesh node, including service name, service
 * environment, and listening ports for various protocols.
 *
 * @see AbstractHttpHandler
 */

@Slf4j
@EventMeshHttpHandler(path = "/v2/configuration")
public class ConfigurationHandler extends AbstractHttpHandler {

    private final EventMeshTCPConfiguration eventMeshTCPConfiguration;
    private final EventMeshHTTPConfiguration eventMeshHTTPConfiguration;
    private final EventMeshGrpcConfiguration eventMeshGrpcConfiguration;

    /**
     * Constructs a new instance with the provided configurations.
     *
     * @param eventMeshTCPConfiguration  the TCP configuration for EventMesh
     * @param eventMeshHTTPConfiguration the HTTP configuration for EventMesh
     * @param eventMeshGrpcConfiguration the gRPC configuration for EventMesh
     */
    public ConfigurationHandler(
        EventMeshTCPConfiguration eventMeshTCPConfiguration,
        EventMeshHTTPConfiguration eventMeshHTTPConfiguration,
        EventMeshGrpcConfiguration eventMeshGrpcConfiguration) {
        super();
        this.eventMeshTCPConfiguration = eventMeshTCPConfiguration;
        this.eventMeshHTTPConfiguration = eventMeshHTTPConfiguration;
        this.eventMeshGrpcConfiguration = eventMeshGrpcConfiguration;
    }

    @Override
    protected void get(HttpRequest httpRequest, ChannelHandlerContext ctx) throws Exception {
        GetConfigurationResponse getConfigurationResponse = new GetConfigurationResponse(
            eventMeshTCPConfiguration,
            eventMeshHTTPConfiguration,
            eventMeshGrpcConfiguration
        );
        String result = JSON.toJSONString(getConfigurationResponse, new IPAddressToStringFilter());
        writeJson(ctx, result);
    }

    static class IPAddressToStringFilter implements ValueFilter {
        @Override
        public Object apply(Object object, String name, Object value) {
            if (name.equals("eventMeshIpv4BlackList") || name.equals("eventMeshIpv6BlackList")) {
                if (value instanceof List) {
                    List<String> ipList = new ArrayList<>();
                    for (Object o : (List<?>) value) {
                        if (o instanceof IPAddress) {
                            ipList.add(((IPAddress) o).toNormalizedString());
                        }
                    }
                    return ipList;
                }
            }
            return value;
        }
    }
}
