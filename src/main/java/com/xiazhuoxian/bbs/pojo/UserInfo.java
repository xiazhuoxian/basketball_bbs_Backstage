package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.SexEnum;
import com.xiazhuoxian.bbs.enums.StatusEnum;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class UserInfo {
    int userId;//用户id
    String loginName;//用户名
    String loginPassword;//用户密码
    String nickname;//昵称
    String address;//地址
    String phone;//电话
    SexEnum sex;//性别
    String icon;//头像
    String secretProtectionQuestion;//密保问题
    String secretProtectionAnswer;//密保答案
    Timestamp createTime;//创建时间
    Timestamp updateTime;//最后更新时间
    StatusEnum status;
    IdentityEnum identity;//身份
    Date createDate;
    Time time;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public UserInfo(int userId) {
        this.userId = userId;
    }

    public UserInfo() {

    }

    public UserInfo(int userId, String icon) {
        this.userId = userId;
        this.icon = icon;
    }

    public UserInfo(String loginName, String loginPassword, String nickname, String address, String phone, SexEnum sex, String icon, String secretProtectionQuestion, String secretProtectionAnswer, Timestamp createTime, Timestamp updateTime, StatusEnum status, IdentityEnum identity) {
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.icon = icon;
        this.secretProtectionQuestion = secretProtectionQuestion;
        this.secretProtectionAnswer = secretProtectionAnswer;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.identity = identity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSecretProtectionQuestion() {
        return secretProtectionQuestion;
    }

    public void setSecretProtectionQuestion(String secretProtectionQuestion) {
        this.secretProtectionQuestion = secretProtectionQuestion;
    }

    public String getSecretProtectionAnswer() {
        return secretProtectionAnswer;
    }

    public void setSecretProtectionAnswer(String secretProtectionAnswer) {
        this.secretProtectionAnswer = secretProtectionAnswer;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public IdentityEnum getIdentity() {
        return identity;
    }

    public void setIdentity(IdentityEnum identity) {
        this.identity = identity;
    }

    public UserInfo(int userId, String loginName, String loginPassword, String nickname, String address, String phone, SexEnum sex, String icon, String secretProtectionQuestion, String secretProtectionAnswer, Timestamp createTime, Timestamp updateTime, StatusEnum status, IdentityEnum identity) {

        this.userId = userId;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
        this.nickname = nickname;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.icon = icon;
        this.secretProtectionQuestion = secretProtectionQuestion;
        this.secretProtectionAnswer = secretProtectionAnswer;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.identity = identity;
    }
}
