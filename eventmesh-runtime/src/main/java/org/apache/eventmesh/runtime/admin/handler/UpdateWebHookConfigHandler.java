package org.apache.eventmesh.runtime.admin.handler;

import org.apache.eventmesh.admin.rocketmq.util.JsonUtils;
import org.apache.eventmesh.admin.rocketmq.util.NetUtils;
import org.apache.eventmesh.runtime.boot.EventMeshTCPServer;
import org.apache.eventmesh.webhook.admin.AdminWebHookConfigOperationManage;
import org.apache.eventmesh.webhook.api.WebHookConfig;
import org.apache.eventmesh.webhook.api.WebHookConfigOperation;

import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class UpdateWebHookConfigHandler implements HttpHandler {

    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.sendResponseHeaders(200, 0);

        // get requestBody and resolve to WebHookConfig
        String requestBody = NetUtils.parsePostBody(httpExchange);
        WebHookConfig webHookConfig = JsonUtils.toObject(requestBody, WebHookConfig.class);

        AdminWebHookConfigOperationManage manage = new AdminWebHookConfigOperationManage();
        try (OutputStream out = httpExchange.getResponseBody()) {
            WebHookConfigOperation operation = manage.getHookConfigOperationManage();
            Integer code = operation.updateWebHookConfig(webHookConfig); // operating result
            String result = 1 == code ? "updateWebHookConfig Succeed!" : "updateWebHookConfig Failed!";
            out.write(result.getBytes());
        } catch (Exception e) {
            logger.error("get WebHookConfigOperation implementation Failed.", e);
        }
    }
}
