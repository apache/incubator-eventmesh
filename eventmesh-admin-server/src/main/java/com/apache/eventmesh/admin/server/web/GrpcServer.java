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

package com.apache.eventmesh.admin.server.web;

import com.apache.eventmesh.admin.server.AdminServerProperties;
import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.concurrent.TimeUnit;

@Controller
@Slf4j
public class GrpcServer extends BaseServer {

    @Autowired
    AdminGrpcServer adminGrpcServer;

    @Autowired
    AdminServerProperties properties;

    private Server server;

    @Override
    public void start() throws Exception {
        NettyServerBuilder serverBuilder = NettyServerBuilder.forPort(getPort()).addService(adminGrpcServer);
        if (properties.isEnableSSL()) {
            serverBuilder.sslContext(null);
        }
        server = serverBuilder.build();
        server.start();
    }

    @Override
    public void destroy() {
        try {
            if (server != null) {
                server.shutdown();
                if(!server.awaitTermination(30, TimeUnit.SECONDS)) {
                    log.warn("[{}] server don't graceful stop in 30s, it will shutdown now", this.getClass().getSimpleName());
                    server.shutdownNow();
                }
            }
        } catch (InterruptedException e) {
            log.warn("destroy [{}] server fail", this.getClass().getSimpleName(), e);
        }
    }

    @Override
    public int getPort() {
        return properties.getPort();
    }
}
