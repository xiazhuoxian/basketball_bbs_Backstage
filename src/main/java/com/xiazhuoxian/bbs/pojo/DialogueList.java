package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.IdentityEnum;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class DialogueList {
    int id;
    UserInfo subjectUser;
    AdminInfo subjectAdmin;
    IdentityEnum subjectIdentity;
    UserInfo targetUser;
    AdminInfo targetAdmin;
    IdentityEnum targetIdentity;
    Boolean readingState;//false 未读 true 已读
    Timestamp updateTime;
    Date date;
    Time time;
    String dialogueRecord;

    public String getDialogueRecord() {
        return dialogueRecord;
    }

    public void setDialogueRecord(String dialogueRecord) {
        this.dialogueRecord = dialogueRecord;
    }

    public Boolean getReadingState() {
        return readingState;
    }

    public void setReadingState(Boolean readingState) {
        this.readingState = readingState;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getSubjectUser() {
        return subjectUser;
    }

    public void setSubjectUser(UserInfo subjectUser) {
        this.subjectUser = subjectUser;
    }

    public AdminInfo getSubjectAdmin() {
        return subjectAdmin;
    }

    public void setSubjectAdmin(AdminInfo subjectAdmin) {
        this.subjectAdmin = subjectAdmin;
    }

    public IdentityEnum getSubjectIdentity() {
        return subjectIdentity;
    }

    public void setSubjectIdentity(IdentityEnum subjectIdentity) {
        this.subjectIdentity = subjectIdentity;
    }

    public UserInfo getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(UserInfo targetUser) {
        this.targetUser = targetUser;
    }

    public AdminInfo getTargetAdmin() {
        return targetAdmin;
    }

    public void setTargetAdmin(AdminInfo targetAdmin) {
        this.targetAdmin = targetAdmin;
    }

    public IdentityEnum getTargetIdentity() {
        return targetIdentity;
    }

    public void setTargetIdentity(IdentityEnum targetIdentity) {
        this.targetIdentity = targetIdentity;
    }

    public DialogueList() {
    }

    public DialogueList(int id, UserInfo subjectUser, AdminInfo subjectAdmin, IdentityEnum subjectIdentity, UserInfo targetUser, AdminInfo targetAdmin, IdentityEnum targetIdentity) {
        this.id = id;
        this.subjectUser = subjectUser;
        this.subjectAdmin = subjectAdmin;
        this.subjectIdentity = subjectIdentity;
        this.targetUser = targetUser;
        this.targetAdmin = targetAdmin;
        this.targetIdentity = targetIdentity;
    }
}
