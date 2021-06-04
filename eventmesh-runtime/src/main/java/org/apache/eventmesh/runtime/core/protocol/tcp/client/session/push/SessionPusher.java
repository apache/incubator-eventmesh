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

package org.apache.eventmesh.runtime.core.protocol.tcp.client.session.push;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.eventmesh.common.Constants;
import org.apache.eventmesh.common.protocol.tcp.Command;
import org.apache.eventmesh.common.protocol.tcp.EventMeshMessage;
import org.apache.eventmesh.common.protocol.tcp.Header;
import org.apache.eventmesh.common.protocol.tcp.OPStatus;
import org.apache.eventmesh.common.protocol.tcp.Package;
import org.apache.eventmesh.runtime.constants.EventMeshConstants;
import org.apache.eventmesh.runtime.core.protocol.tcp.client.session.Session;
import org.apache.eventmesh.runtime.util.EventMeshUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class SessionPusher {

    private final Logger messageLogger = LoggerFactory.getLogger("message");

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicLong deliveredMsgsCount = new AtomicLong(0);

    private AtomicLong deliverFailMsgsCount = new AtomicLong(0);

    private ConcurrentHashMap<String /** seq */, DownStreamMsgContext> downStreamMap = new ConcurrentHashMap<String, DownStreamMsgContext>();

    private Session session;

    public SessionPusher(Session session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "SessionPusher{" +
                "deliveredMsgsCount=" + deliveredMsgsCount.longValue() +
                ",deliverFailCount=" + deliverFailMsgsCount.longValue() +
                ",unAckMsg=" + CollectionUtils.size(downStreamMap) + '}';
    }

    public void push(final DownStreamMsgContext downStreamMsgContext) {
        Command cmd;
        if (EventMeshUtil.isBroadcast(downStreamMsgContext.msgExt.getSystemProperties(Constants.PROPERTY_MESSAGE_DESTINATION))) {
            cmd = Command.BROADCAST_MESSAGE_TO_CLIENT;
        } else if (EventMeshUtil.isService(downStreamMsgContext.msgExt.getSystemProperties(Constants.PROPERTY_MESSAGE_DESTINATION))) {
            cmd = Command.REQUEST_TO_CLIENT;
        } else {
            cmd = Command.ASYNC_MESSAGE_TO_CLIENT;
        }

        Package pkg = new Package();
        downStreamMsgContext.msgExt.getSystemProperties().put(EventMeshConstants.REQ_EVENTMESH2C_TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        EventMeshMessage body = null;
        int retCode = 0;
        String retMsg = null;
        try {
            body = EventMeshUtil.encodeMessage(downStreamMsgContext.msgExt);
            pkg.setBody(body);
            pkg.setHeader(new Header(cmd, OPStatus.SUCCESS.getCode(), null, downStreamMsgContext.seq));
            messageLogger.info("pkg|mq2eventMesh|cmd={}|mqMsg={}|user={}", cmd, EventMeshUtil.printMqMessage(body), session.getClient());
        } catch (Exception e) {
            pkg.setHeader(new Header(cmd, OPStatus.FAIL.getCode(), e.getStackTrace().toString(), downStreamMsgContext.seq));
            retCode = -1;
            retMsg = e.toString();
        } finally {
            session.getClientGroupWrapper().get().getEventMeshTcpMonitor().getEventMesh2clientMsgNum().incrementAndGet();

            session.getContext().writeAndFlush(pkg).addListener(
                    new ChannelFutureListener() {
                        @Override
                        public void operationComplete(ChannelFuture future) throws Exception {
                            if (!future.isSuccess()) {
                                logger.error("downstreamMsg fail,seq:{}, retryTimes:{}, msg:{}", downStreamMsgContext.seq, downStreamMsgContext.retryTimes, downStreamMsgContext.msgExt);
                                deliverFailMsgsCount.incrementAndGet();

                                //how long to isolate client when push fail
                                long isolateTime = System.currentTimeMillis() + session.getEventMeshTCPConfiguration().eventMeshTcpPushFailIsolateTimeInMills;
                                session.setIsolateTime(isolateTime);
                                logger.warn("isolate client:{},isolateTime:{}", session.getClient(), isolateTime);

                                //retry
                                long delayTime = EventMeshUtil.isService(downStreamMsgContext.msgExt.getSystemProperties(Constants.PROPERTY_MESSAGE_DESTINATION)) ? 0 : session.getEventMeshTCPConfiguration().eventMeshTcpMsgRetryDelayInMills;
                                downStreamMsgContext.delay(delayTime);
                                session.getClientGroupWrapper().get().getEventMeshTcpRetryer().pushRetry(downStreamMsgContext);
                            } else {
                                deliveredMsgsCount.incrementAndGet();
                                logger.info("downstreamMsg success,seq:{}, retryTimes:{}, bizSeq:{}", downStreamMsgContext.seq, downStreamMsgContext.retryTimes, EventMeshUtil.getMessageBizSeq(downStreamMsgContext.msgExt));

                                if (session.isIsolated()) {
                                    logger.info("cancel isolated,client:{}", session.getClient());
                                    session.setIsolateTime(System.currentTimeMillis());
                                }
                            }
                        }
                    }
            );
        }
    }

    public void unAckMsg(String seq, DownStreamMsgContext downStreamMsgContext) {
        downStreamMap.put(seq, downStreamMsgContext);
        logger.info("put msg in unAckMsg,seq:{},unAckMsgSize:{}", seq, getTotalUnackMsgs());
    }

    public int getTotalUnackMsgs() {
        return downStreamMap.size();
    }

    public ConcurrentHashMap<String, DownStreamMsgContext> getUnAckMsg() {
        return downStreamMap;
    }

    public AtomicLong getDeliveredMsgsCount() {
        return deliveredMsgsCount;
    }

    public AtomicLong getDeliverFailMsgsCount() {
        return deliverFailMsgsCount;
    }
}
