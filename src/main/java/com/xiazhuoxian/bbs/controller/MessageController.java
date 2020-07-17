package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/insertMessage")
    @ResponseBody
    public int insertMessage(MessageParam messageParam)throws IOException {
        return messageService.insertMessage(messageParam);
    }

    @RequestMapping("/deleteMessageById")
    @ResponseBody
    public int deleteMessageById(int id){
        return messageService.deleteMessageById(id);
    }

    @RequestMapping("/updateMessageReadingState")
    @ResponseBody
    public int updateMessageReadingState(int id){
        return messageService.updateMessageReadingState(id);
    }

    @RequestMapping("/clearUnread")
    @ResponseBody
    public int clearUnread(MessageParam messageParam){
        return messageService.clearUnread(messageParam);
    }

    @RequestMapping("/selectAllMessageByMessageType")
    @ResponseBody
    public Paging selectAllMessageByMessageType(MessageParam messageParam){
        return messageService.selectAllMessageByMessageType(messageParam);
    }

    @RequestMapping("/selectUnreadMessage")
    @ResponseBody
    public List<Message> selectUnreadMessage(MessageParam messageParam){
        return messageService.selectUnreadMessage(messageParam);
    }

    @RequestMapping("/selectDialogueMessage")
    @ResponseBody
    public List<Message> selectDialogueMessage(MessageParam messageParam){
        return messageService.selectDialogueMessage(messageParam);
    }

    @RequestMapping("/insertDialogueList")
    @ResponseBody
    public int insertDialogueList(DiaLogueListParam diaLogueListParam){
        return messageService.insertDialogueList(diaLogueListParam);
    }

    @RequestMapping("/deleteDialogueListById")
    @ResponseBody
    public int deleteDialogueListById(int id){
        return messageService.deleteDialogueListById(id);
    }

    @RequestMapping("/selectDialogueListBySubjectId")
    @ResponseBody
    public List<DialogueList> selectDialogueListBySubjectId(DiaLogueListParam diaLogueListParam){
        return messageService.selectDialogueListBySubjectId(diaLogueListParam);
    }
}
