package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.DialogueList;
import com.xiazhuoxian.bbs.pojo.Message;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    public int insertMessage(Message message);
    public int deleteMessageById(int id);
    public int updateMessageReadingState(int id);
    public int clearUnread(Message message);
    public int selectDialogueMessageAndSetMessagerAlreadyread(Message message);
    public List<Message> selectAllMessageByMessageType(@Param("paging")Paging paging, @Param("message")Message message);
    public List<Message> selectUnreadMessage(Message message);
    public List<Message> selectDialogueMessage(Message message);
    public int insertDialogueList(DialogueList dialogueList);
    public int deleteDialogueListById(int id);
    public int updateDiaLogueListUpdateTime(DialogueList dialogueList);
    public int selectDialogueMessageAndSetDialogueAlreadyread(DialogueList dialogueList);
    public int selectDialogueListIfExit(DialogueList dialogueList);
    public List<DialogueList> selectDialogueListBySubjectId(DialogueList dialogueList);
}
