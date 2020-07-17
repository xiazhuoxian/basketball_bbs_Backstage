package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface MessageService {
    public int insertMessage(MessageParam messageParam)throws IOException;
    public int deleteMessageById(int id);
    public int updateMessageReadingState(int id);
    public int clearUnread(MessageParam messageParam);
    public int selectDialogueMessageAndSetMessagerAlreadyread(Message message);
    public Paging selectAllMessageByMessageType(MessageParam messageParam);
    public List<Message> selectUnreadMessage(MessageParam messageParam);
    public List<Message> selectDialogueMessage(MessageParam messageParam);
    public int insertDialogueList(DiaLogueListParam diaLogueListParam);
    public int updateDiaLogueListUpdateTime(DialogueList dialogueList);
    public int deleteDialogueListById(int id);
    public int selectDialogueMessageAndSetDialogueAlreadyread(DialogueList dialogueList);
    public int selectDialogueListIfExit(DialogueList dialogueList);
    public List<DialogueList> selectDialogueListBySubjectId(DiaLogueListParam diaLogueListParam);
}

