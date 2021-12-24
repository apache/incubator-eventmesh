package org.apache.eventmesh.runtime.core.protocol.grpc.service;

import io.grpc.stub.StreamObserver;
import org.apache.eventmesh.common.protocol.grpc.common.StatusCode;
import org.apache.eventmesh.common.protocol.grpc.protos.EventMeshMessage;
import org.apache.eventmesh.common.protocol.grpc.protos.PublisherServiceGrpc;
import org.apache.eventmesh.common.protocol.grpc.protos.Response;
import org.apache.eventmesh.runtime.boot.EventMeshGrpcServer;
import org.apache.eventmesh.runtime.constants.EventMeshConstants;
import org.apache.eventmesh.runtime.core.protocol.grpc.processor.SendAsyncMessageProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

public class ProducerService extends PublisherServiceGrpc.PublisherServiceImplBase {

    private final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final Logger cmdLogger = LoggerFactory.getLogger("cmd");

    private final EventMeshGrpcServer eventMeshGrpcServer;

    private final ThreadPoolExecutor threadPoolExecutor;

    public ProducerService(EventMeshGrpcServer eventMeshGrpcServer,
                           ThreadPoolExecutor threadPoolExecutor) {
        this.eventMeshGrpcServer = eventMeshGrpcServer;
        this.threadPoolExecutor = threadPoolExecutor;
    }

    public void publish(EventMeshMessage request, StreamObserver<Response> responseObserver) {
        cmdLogger.info("cmd={}|{}|client2eventMesh|from={}|to={}", "AsyncPublish",
            EventMeshConstants.PROTOCOL_GRPC, request.getHeader().getIp(),
            eventMeshGrpcServer.getEventMeshGrpcConfiguration().eventMeshIp);

        EventEmitter<Response> emitter = new EventEmitter<>(responseObserver);
        threadPoolExecutor.submit(() -> {
            SendAsyncMessageProcessor sendAsyncMessageProcessor = new SendAsyncMessageProcessor(eventMeshGrpcServer);
            try {
                sendAsyncMessageProcessor.process(request, emitter);
            } catch (Exception e) {
                logger.error("Error code {}, error message {}", StatusCode.EVENTMESH_SEND_ASYNC_MSG_ERR.getRetCode(),
                    StatusCode.EVENTMESH_SEND_ASYNC_MSG_ERR.getErrMsg(), e);
                ServiceUtils.sendResp(StatusCode.EVENTMESH_SEND_ASYNC_MSG_ERR, e.getMessage(), emitter);
            }
        });
    }

}
