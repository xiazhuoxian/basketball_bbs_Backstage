package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.ContentTypeEnum;
import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.MessageTypeEnum;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Message {
    int id;
    UserInfo userSender;
    AdminInfo adminSender;
    IdentityEnum senderIdentity;
    UserInfo userReceiver;
    AdminInfo adminRecriver;
    IdentityEnum receiverIdentity;
    MessageTypeEnum messageType;
    ContentTypeEnum contentType;
    MainPostsComments comments;
    String content;
    Timestamp updateTime;
    Boolean readingState;//false 未读 true 已读
    Boolean senderRecord;//发送人的消息记录是否保存，true保存，false删除
    Boolean receiverRecord;//接收人的消息是否保存
    Date data;
    Time time;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Boolean getSenderRecord() {
        return senderRecord;
    }

    public void setSenderRecord(Boolean senderRecord) {
        this.senderRecord = senderRecord;
    }

    public Boolean getReceiverRecord() {
        return receiverRecord;
    }

    public void setReceiverRecord(Boolean receiverRecord) {
        this.receiverRecord = receiverRecord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUserSender() {
        return userSender;
    }

    public void setUserSender(UserInfo userSender) {
        this.userSender = userSender;
    }

    public AdminInfo getAdminSender() {
        return adminSender;
    }

    public void setAdminSender(AdminInfo adminSender) {
        this.adminSender = adminSender;
    }

    public IdentityEnum getSenderIdentity() {
        return senderIdentity;
    }

    public void setSenderIdentity(IdentityEnum senderIdentity) {
        this.senderIdentity = senderIdentity;
    }

    public UserInfo getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(UserInfo userReceiver) {
        this.userReceiver = userReceiver;
    }

    public AdminInfo getAdminRecriver() {
        return adminRecriver;
    }

    public void setAdminRecriver(AdminInfo adminRecriver) {
        this.adminRecriver = adminRecriver;
    }

    public IdentityEnum getReceiverIdentity() {
        return receiverIdentity;
    }

    public void setReceiverIdentity(IdentityEnum receiverIdentity) {
        this.receiverIdentity = receiverIdentity;
    }

    public MessageTypeEnum getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeEnum messageType) {
        this.messageType = messageType;
    }

    public ContentTypeEnum getContentType() {
        return contentType;
    }

    public void setContentType(ContentTypeEnum contentType) {
        this.contentType = contentType;
    }

    public MainPostsComments getComments() {
        return comments;
    }

    public void setComments(MainPostsComments comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getReadingState() {
        return readingState;
    }

    public void setReadingState(Boolean readingState) {
        this.readingState = readingState;
    }

    public Message() {

    }

    public Message(int id, UserInfo userSender, AdminInfo adminSender, IdentityEnum senderIdentity, UserInfo userReceiver, AdminInfo adminRecriver, IdentityEnum receiverIdentity, MessageTypeEnum messageType, ContentTypeEnum contentType, MainPostsComments comments, String content, Timestamp updateTime, Boolean readingState) {

        this.id = id;
        this.userSender = userSender;
        this.adminSender = adminSender;
        this.senderIdentity = senderIdentity;
        this.userReceiver = userReceiver;
        this.adminRecriver = adminRecriver;
        this.receiverIdentity = receiverIdentity;
        this.messageType = messageType;
        this.contentType = contentType;
        this.comments = comments;
        this.content = content;
        this.updateTime = updateTime;
        this.readingState = readingState;
    }
}
