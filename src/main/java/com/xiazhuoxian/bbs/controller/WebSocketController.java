package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.DialogueList;
import com.xiazhuoxian.bbs.service.serviceImpl.WebSocketServerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebSocketController {
    @GetMapping("/sendAllWebSocket")
    public String test() {
        String text="你们好！这是websocket群体发送！";
        //WebSocketServerImpl.sendAllMessage(text);
        WebSocketServerImpl webSocketServer=new WebSocketServerImpl();
        webSocketServer.sendAllMessage(text);
        return text;
    }

    @GetMapping("/sendOneWebSocket/{IdentityRecognition}")
    public String sendOneWebSocket(@PathVariable("IdentityRecognition") String IdentityRecognition) {
        String text=IdentityRecognition+" 你好！ 这是websocket单人发送！";
        //WebSocketServerImpl.sendOneMessage(userName,text);
        WebSocketServerImpl webSocketServer=new WebSocketServerImpl();
        webSocketServer.sendOneMessage(IdentityRecognition,text);
        return text;
    }

    @GetMapping("/dialogue/{IdentityRecognition}")
    public String dialogue(@PathVariable("IdentityRecognition") String IdentityRecognition, DialogueList dialogueList) {
        WebSocketServerImpl webSocketServer=new WebSocketServerImpl();
        webSocketServer.dialogue(IdentityRecognition,dialogueList);
        return "success";
    }
}
