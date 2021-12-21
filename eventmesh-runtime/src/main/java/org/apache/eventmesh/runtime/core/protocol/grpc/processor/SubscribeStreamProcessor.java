package org.apache.eventmesh.runtime.core.protocol.grpc.processor;

import io.grpc.stub.StreamObserver;
import org.apache.eventmesh.common.protocol.grpc.common.StatusCode;
import org.apache.eventmesh.common.protocol.grpc.protos.EventMeshMessage;
import org.apache.eventmesh.common.protocol.grpc.protos.RequestHeader;
import org.apache.eventmesh.common.protocol.grpc.protos.Response;
import org.apache.eventmesh.common.protocol.grpc.protos.Subscription;
import org.apache.eventmesh.common.utils.JsonUtils;
import org.apache.eventmesh.runtime.boot.EventMeshGrpcServer;
import org.apache.eventmesh.runtime.core.protocol.grpc.consumer.ConsumerManager;
import org.apache.eventmesh.runtime.core.protocol.grpc.consumer.consumergroup.ConsumerGroupClient;
import org.apache.eventmesh.runtime.core.protocol.grpc.service.ServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscribeStreamProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private EventMeshGrpcServer eventMeshGrpcServer;

    public SubscribeStreamProcessor(EventMeshGrpcServer eventMeshGrpcServer) {
        this.eventMeshGrpcServer = eventMeshGrpcServer;
    }

    public void process(Subscription subscription, StreamObserver<EventMeshMessage> responseObserver) throws Exception {

        RequestHeader header = subscription.getHeader();
        String protocolDesc = header.getProtocolDesc();

        if (!ServiceUtils.validateHeader(header)) {
            sendResp(subscription, StatusCode.EVENTMESH_PROTOCOL_HEADER_ERR, responseObserver);
            return;
        }

        if (!ServiceUtils.validateSubscription(protocolDesc, subscription)) {
            sendResp(subscription, StatusCode.EVENTMESH_PROTOCOL_BODY_ERR, responseObserver);
            return;
        }

        ConsumerManager consumerManager = eventMeshGrpcServer.getConsumerManager();

        String consumerGroup = subscription.getConsumerGroup();
        List<Subscription.SubscriptionItem> subscriptionItems = subscription.getSubscriptionItemsList();

        for (Subscription.SubscriptionItem item : subscriptionItems) {
            ConsumerGroupClient newClient = ConsumerGroupClient.builder()
                .env(header.getEnv())
                .idc(header.getIdc())
                .sys(header.getSys())
                .ip(header.getIp())
                .pid(header.getPid())
                .consumerGroup(consumerGroup)
                .topic(item.getTopic())
                .subscriptionMode(item.getMode())
                .protocolDesc(protocolDesc)
                .eventEmitter(responseObserver)
                .lastUpTime(new Date())
                .build();

            consumerManager.registerClient(newClient);
        }

        consumerManager.restartEventMeshConsumer(consumerGroup);
    }

    private void sendResp(Subscription subscription, StatusCode code, StreamObserver<EventMeshMessage> responseObserver) {
        Map<String, String> resp = new HashMap<>();
        resp.put("respCode", code.getRetCode());
        resp.put("respMsg", code.getErrMsg());

        RequestHeader header = subscription.getHeader();
        EventMeshMessage eventMeshMessage = EventMeshMessage.newBuilder()
            .setHeader(header)
            .setContent(JsonUtils.serialize(resp))
            .build();

        responseObserver.onNext(eventMeshMessage);
        responseObserver.onCompleted();
    }
}