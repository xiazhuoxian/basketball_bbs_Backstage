package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.JurisdictionEnum;
import com.xiazhuoxian.bbs.enums.SexEnum;

import java.sql.Timestamp;

public class AdminInfo {
    int adminId;//用户id
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
    JurisdictionEnum jurisdiction;//管理员权限
    IdentityEnum identity;//身份


    public AdminInfo(int adminId, String icon) {
        this.adminId = adminId;
        this.icon = icon;
    }

    public IdentityEnum getIdentity() {

        return identity;
    }

    public void setIdentity(IdentityEnum identity) {
        this.identity = identity;
    }

    public AdminInfo(int adminId, String loginName, String loginPassword, String nickname, String address, String phone, SexEnum sex, String icon, String secretProtectionQuestion, String secretProtectionAnswer, Timestamp createTime, Timestamp updateTime, JurisdictionEnum jurisdiction, IdentityEnum identity) {

        this.adminId = adminId;
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
        this.jurisdiction = jurisdiction;
        this.identity = identity;
    }

    public AdminInfo(int adminId) {
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public JurisdictionEnum getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(JurisdictionEnum jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public AdminInfo() {
    }

    public AdminInfo(int adminId, String loginName, String loginPassword, String nickname, String address, String phone, SexEnum sex, String icon, String secretProtectionQuestion, String secretProtectionAnswer, Timestamp createTime, Timestamp updateTime, JurisdictionEnum jurisdiction) {

        this.adminId = adminId;
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
        this.jurisdiction = jurisdiction;
    }
}
