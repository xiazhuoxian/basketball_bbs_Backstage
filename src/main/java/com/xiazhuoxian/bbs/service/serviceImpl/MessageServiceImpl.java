package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.controller.UploadController;
import com.xiazhuoxian.bbs.controller.WebSocketController;
import com.xiazhuoxian.bbs.enums.MessageTypeEnum;
import com.xiazhuoxian.bbs.mapper.MessageMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    MessageMapper messageMapper;
    @Autowired
    UploadController uploadController;
    @Autowired
    WebSocketController webSocketController;

    @Override
    public int insertMessage(MessageParam messageParam)throws IOException {
        if(messageParam.getSenderIdentity().toString().equals("ADMIN")){
            messageParam.setAdminSender(new AdminInfo(messageParam.getSenderId()));
        }else if(messageParam.getSenderIdentity().toString().equals("USER")){
            messageParam.setUserSender(new UserInfo(messageParam.getSenderId()));
        }
        if(messageParam.getReceiverIdentity().toString().equals("ADMIN")){
            messageParam.setAdminRecriver(new AdminInfo(messageParam.getReceiverId()));
        }else if(messageParam.getReceiverIdentity().toString().equals("USER")){
            messageParam.setUserReceiver(new UserInfo(messageParam.getReceiverId()));
        }
        if(messageParam.getContentType().toString().equals("IMG")){
            String imgAdress=uploadController.privateLetterImg(messageParam.getImgFile());
            messageParam.setContent(imgAdress);
        }
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        messageParam.setUpdateTime(updateTime);
        messageParam.setReadingState(false);
        messageParam.setSenderRecord(true);
        messageParam.setReceiverRecord(true);
        int result=messageMapper.insertMessage(messageParam);
        //私信成功，通过websocket通知用户
        if(result!=0&&messageParam.getMessageType().toString().equals("PRIVATE_LETTER")){
            //处理己方消息列表
            DialogueList list=new DialogueList();
            list.setSubjectIdentity(messageParam.getSenderIdentity());
            list.setTargetIdentity(messageParam.getReceiverIdentity());
            if(messageParam.getSenderIdentity().toString().equals("ADMIN")){
                list.setSubjectAdmin(new AdminInfo(messageParam.getSenderId()));
            }else {
                list.setSubjectUser(new UserInfo(messageParam.getSenderId()));
            }
            if (messageParam.getReceiverIdentity().toString().equals("ADMIN")){
                list.setTargetAdmin(new AdminInfo(messageParam.getReceiverId()));
            }else {
                list.setTargetUser(new UserInfo(messageParam.getReceiverId()));
            }
            list.setUpdateTime(updateTime);
            messageMapper.updateDiaLogueListUpdateTime(list);
            //处理对方消息列表
            DialogueList dialogueList=new DialogueList();
            dialogueList.setSubjectIdentity(messageParam.getReceiverIdentity());
            dialogueList.setTargetIdentity(messageParam.getSenderIdentity());
            if(messageParam.getReceiverIdentity().toString().equals("ADMIN")){
                dialogueList.setSubjectAdmin(new AdminInfo(messageParam.getReceiverId()));
            }else {
                dialogueList.setSubjectUser(new UserInfo(messageParam.getReceiverId()));
            }
            if (messageParam.getSenderIdentity().toString().equals("ADMIN")){
                dialogueList.setTargetAdmin(new AdminInfo(messageParam.getSenderId()));
            }else {
                dialogueList.setTargetUser(new UserInfo(messageParam.getSenderId()));
            }
            dialogueList.setUpdateTime(updateTime);
            dialogueList.setReadingState(false);
            if(messageMapper.selectDialogueListIfExit(dialogueList)!=0){
                messageMapper.updateDiaLogueListUpdateTime(dialogueList);
            }else {
                messageMapper.insertDialogueList(dialogueList);
            }
            String IdentityRecognition=messageParam.getReceiverIdentity().toString()+messageParam.getReceiverId();
            webSocketController.dialogue(IdentityRecognition,dialogueList);
            //webSocketController.sendOneWebSocket(IdentityRecognition);
        }
        return result;
    }

    @Override
    public int deleteMessageById(int id){
        return messageMapper.deleteMessageById(id);
    }

    @Override
    public int updateMessageReadingState(int id){
        return messageMapper.updateMessageReadingState(id);
    }

    @Override
    public int clearUnread(MessageParam messageParam){
        if(messageParam.getReceiverIdentity().toString().equals("ADMIN")){
            messageParam.setAdminRecriver(new AdminInfo(messageParam.getReceiverId()));
        }else if(messageParam.getReceiverIdentity().toString().equals("USER")){
            messageParam.setUserReceiver(new UserInfo(messageParam.getReceiverId()));
        }
        return messageMapper.clearUnread(messageParam);
    }

    @Override
    public int selectDialogueMessageAndSetMessagerAlreadyread(Message message){
        return messageMapper.selectDialogueMessageAndSetMessagerAlreadyread(message);
    }

    @Override
    public Paging selectAllMessageByMessageType(MessageParam messageParam){
        int itemsDisplayedPerPage=10;
        Paging paging=new Paging(messageParam.getCurrentPageNumber(),itemsDisplayedPerPage);
        if(messageParam.getReceiverIdentity().toString().equals("ADMIN")){
            messageParam.setAdminRecriver(new AdminInfo(messageParam.getReceiverId()));
        }else if(messageParam.getReceiverIdentity().toString().equals("USER")){
            messageParam.setUserReceiver(new UserInfo(messageParam.getReceiverId()));
        }
        List<Message> result=messageMapper.selectAllMessageByMessageType(paging,messageParam);
        paging.setMessagesResult(result);
        paging.setTotalItems(paging.getMessagesResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }

    @Override
    public List<Message> selectUnreadMessage(MessageParam messageParam){
        if(messageParam.getReceiverIdentity().toString().equals("ADMIN")){
            messageParam.setAdminRecriver(new AdminInfo(messageParam.getReceiverId()));
        }else if(messageParam.getReceiverIdentity().toString().equals("USER")){
            messageParam.setUserReceiver(new UserInfo(messageParam.getReceiverId()));
        }
        return messageMapper.selectUnreadMessage(messageParam);
    }

    @Override
    public List<Message> selectDialogueMessage(MessageParam messageParam){
        DialogueList dialogueList=new DialogueList();
        dialogueList.setSubjectIdentity(messageParam.getReceiverIdentity());
        dialogueList.setTargetIdentity(messageParam.getSenderIdentity());
        if(messageParam.getReceiverIdentity().toString().equals("ADMIN")){
            messageParam.setAdminRecriver(new AdminInfo(messageParam.getReceiverId()));
            dialogueList.setSubjectAdmin(new AdminInfo(messageParam.getReceiverId()));
        }else if(messageParam.getReceiverIdentity().toString().equals("USER")){
            messageParam.setUserReceiver(new UserInfo(messageParam.getReceiverId()));
            dialogueList.setSubjectUser(new UserInfo(messageParam.getReceiverId()));
        }
        if(messageParam.getSenderIdentity().toString().equals("ADMIN")){
            messageParam.setAdminSender(new AdminInfo(messageParam.getSenderId()));
            dialogueList.setTargetAdmin(new AdminInfo(messageParam.getSenderId()));
        }else if(messageParam.getSenderIdentity().toString().equals("USER")){
            messageParam.setUserSender(new UserInfo(messageParam.getSenderId()));
            dialogueList.setTargetUser(new UserInfo(messageParam.getSenderId()));
        }
        messageParam.setMessageType(MessageTypeEnum.PRIVATE_LETTER);
        List<Message> result=messageMapper.selectDialogueMessage(messageParam);
        messageMapper.selectDialogueMessageAndSetMessagerAlreadyread(messageParam);
        messageMapper.selectDialogueMessageAndSetDialogueAlreadyread(dialogueList);
        for(Message param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setData(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }
        return result;
    }

    @Override
    public int insertDialogueList(DiaLogueListParam diaLogueListParam){
        if(diaLogueListParam.getSubjectIdentity().toString().equals("ADMIN")){
            diaLogueListParam.setSubjectAdmin(new AdminInfo(diaLogueListParam.getSubjectId()));
        }else if(diaLogueListParam.getSubjectIdentity().toString().equals("USER")){
            diaLogueListParam.setSubjectUser(new UserInfo(diaLogueListParam.getSubjectId()));
        }
        if(diaLogueListParam.getTargetIdentity().toString().equals("ADMIN")){
            diaLogueListParam.setTargetAdmin(new AdminInfo(diaLogueListParam.getTargetId()));
        }else if(diaLogueListParam.getTargetIdentity().toString().equals("USER")){
            diaLogueListParam.setTargetUser(new UserInfo(diaLogueListParam.getTargetId()));
        }
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        diaLogueListParam.setUpdateTime(updateTime);
        diaLogueListParam.setReadingState(true);
        if(messageMapper.selectDialogueListIfExit(diaLogueListParam)!=0){
            messageMapper.updateDiaLogueListUpdateTime(diaLogueListParam);
        }else {
            messageMapper.insertDialogueList(diaLogueListParam);
        }
        return 1;
    }

    @Override
    public int deleteDialogueListById(int id){
        return messageMapper.deleteDialogueListById(id);
    }

    @Override
    public int selectDialogueMessageAndSetDialogueAlreadyread(DialogueList dialogueList){
        return messageMapper.selectDialogueMessageAndSetDialogueAlreadyread(dialogueList);
    }

    @Override
    public int updateDiaLogueListUpdateTime(DialogueList dialogueList){
        return messageMapper.updateDiaLogueListUpdateTime(dialogueList);
    }

    @Override
    public int selectDialogueListIfExit(DialogueList dialogueList){
        return messageMapper.selectDialogueListIfExit(dialogueList);
    }

    @Override
    public List<DialogueList> selectDialogueListBySubjectId(DiaLogueListParam diaLogueListParam){
        if(diaLogueListParam.getSubjectIdentity().toString().equals("ADMIN")){
            diaLogueListParam.setSubjectAdmin(new AdminInfo(diaLogueListParam.getSubjectId()));
        }else if(diaLogueListParam.getSubjectIdentity().toString().equals("USER")){
            diaLogueListParam.setSubjectUser(new UserInfo(diaLogueListParam.getSubjectId()));
        }
        List<DialogueList> result=messageMapper.selectDialogueListBySubjectId(diaLogueListParam);
        for(DialogueList param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setDate(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }
        return result;
    }
}
