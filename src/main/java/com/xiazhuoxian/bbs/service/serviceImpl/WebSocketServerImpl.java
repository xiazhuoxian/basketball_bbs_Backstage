package com.xiazhuoxian.bbs.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.xiazhuoxian.bbs.pojo.DialogueList;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@Component
@ServerEndpoint("/websocket/{IdentityRecognition}")
//此注解相当于设置访问URL
public class WebSocketServerImpl {
    private Session session;

    private static CopyOnWriteArraySet<WebSocketServerImpl> webSockets =new CopyOnWriteArraySet<>();
    private static Map<String,Session> sessionPool = new HashMap<String,Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam(value="IdentityRecognition")String IdentityRecognition) {
        this.session = session;
        webSockets.add(this);
        sessionPool.put(IdentityRecognition, session);
        System.out.println(IdentityRecognition+"【websocket消息】有新的连接，总数为:"+webSockets.size());
    }

    @OnClose
    public void onClose() {
        webSockets.remove(this);
        System.out.println("【websocket消息】连接断开，总数为:"+webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("【websocket消息】收到客户端消息:"+message);
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for(WebSocketServerImpl webSocket : webSockets) {
            System.out.println("【websocket消息】广播消息:"+message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为单点消息
    public void sendOneMessage(String IdentityRecognition, String message) {
        System.out.println("【websocket消息】单点消息:"+message);
        Session session = sessionPool.get(IdentityRecognition);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 私信对话
    public void dialogue(String IdentityRecognition, DialogueList dialogueList) {
        System.out.println("私信："+IdentityRecognition+"："+dialogueList);
        Session session = sessionPool.get(IdentityRecognition);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(JSON.toJSONString(dialogueList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
