package org.apache.eventmesh.runtime.core.protocol.grpc.processor;

import org.apache.eventmesh.common.protocol.grpc.common.StatusCode;
import org.apache.eventmesh.common.protocol.grpc.protos.RequestHeader;
import org.apache.eventmesh.common.protocol.grpc.protos.Response;
import org.apache.eventmesh.common.protocol.grpc.protos.Subscription;
import org.apache.eventmesh.runtime.boot.EventMeshGrpcServer;
import org.apache.eventmesh.runtime.core.protocol.grpc.consumer.ConsumerManager;
import org.apache.eventmesh.runtime.core.protocol.grpc.consumer.EventMeshConsumer;
import org.apache.eventmesh.runtime.core.protocol.grpc.consumer.consumergroup.ConsumerGroupClient;
import org.apache.eventmesh.runtime.core.protocol.grpc.consumer.consumergroup.GrpcType;
import org.apache.eventmesh.runtime.core.protocol.grpc.service.EventEmitter;
import org.apache.eventmesh.runtime.core.protocol.grpc.service.ServiceUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class SubscribeProcessor {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private final EventMeshGrpcServer eventMeshGrpcServer;

    private final GrpcType grpcType = GrpcType.WEBHOOK;

    public SubscribeProcessor(EventMeshGrpcServer eventMeshGrpcServer) {
        this.eventMeshGrpcServer = eventMeshGrpcServer;
    }

    public void process(Subscription subscription, EventEmitter<Response> emitter) throws Exception {
        RequestHeader header = subscription.getHeader();

        if (!ServiceUtils.validateHeader(header)) {
            ServiceUtils.sendResp(StatusCode.EVENTMESH_PROTOCOL_HEADER_ERR, emitter);
            return;
        }

        if (!ServiceUtils.validateSubscription(grpcType, subscription)) {
            ServiceUtils.sendResp(StatusCode.EVENTMESH_PROTOCOL_BODY_ERR, emitter);
            return;
        }

        ConsumerManager consumerManager = eventMeshGrpcServer.getConsumerManager();

        String consumerGroup = subscription.getConsumerGroup();
        String url = subscription.getUrl();
        List<Subscription.SubscriptionItem> subscriptionItems = subscription.getSubscriptionItemsList();

        // Collect new clients in the subscription
        List<ConsumerGroupClient> newClients = new LinkedList<>();
        for (Subscription.SubscriptionItem item : subscriptionItems) {
            ConsumerGroupClient newClient = ConsumerGroupClient.builder()
                .env(header.getEnv())
                .idc(header.getIdc())
                .sys(header.getSys())
                .ip(header.getIp())
                .pid(header.getPid())
                .consumerGroup(consumerGroup)
                .topic(item.getTopic())
                .grpcType(grpcType)
                .subscriptionMode(item.getMode())
                .url(url)
                .lastUpTime(new Date())
                .build();
            newClients.add(newClient);
        }

        // register new clients into ConsumerManager
        for (ConsumerGroupClient newClient : newClients) {
            consumerManager.registerClient(newClient);
        }

        // register new clients into EventMeshConsumer
        EventMeshConsumer eventMeshConsumer = consumerManager.getEventMeshConsumer(consumerGroup);

        boolean requireRestart = false;
        for (ConsumerGroupClient newClient : newClients) {
            if (eventMeshConsumer.registerClient(newClient)) {
                requireRestart = true;
            }
        }

        // restart consumer group if required
        if (requireRestart) {
            logger.info("ConsumerGroup {} topic info changed, restart EventMesh Consumer", consumerGroup);
            consumerManager.restartEventMeshConsumer(consumerGroup);
        } else {
            logger.warn("EventMesh consumer [{}] didn't restart.", consumerGroup);
        }

        ServiceUtils.sendResp(StatusCode.SUCCESS, "subscribe success", emitter);
    }
}