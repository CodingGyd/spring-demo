package com.gyd.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket")
public class WebSocketService {
    private Session session;


    //保存连接
    private static CopyOnWriteArraySet<WebSocketService> webSocketService = new CopyOnWriteArraySet<>();

    /**
     * 建立连接
     * @param session
     */
    @OnOpen
    public void opOpen(Session session) {
        this.session = session;
        webSocketService.add(this);
        System.out.println("有新的连接=============》" + webSocketService.size());
    }

    /**
     * 断开连接
     */
    @OnClose
    public void onClose() {
        webSocketService.remove(this);
        System.out.println("断开连接=============》" + webSocketService.size());
    }

    /**
     * 接收客户端消息
     * @param message
     */
    @OnMessage
    public void onMessage(String message) {
        System.out.println("收到客户端消息" + message);
    }

    /**
     * 发送消息到客户端
     * @param message
     */
    public void sendMessage(String message) {
        for (WebSocketService webSocketService2 : webSocketService) {
            System.out.println("广播消息" + message);
            webSocketService2.session.getAsyncRemote().sendText(message);
        }
    }

    /**
     * 传输消息错误触发事件
     */
    @OnError
    public void onError(Throwable error) {

    }
}
