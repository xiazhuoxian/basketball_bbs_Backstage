package com.xiazhuoxian.bbs.pojo;

import java.sql.Timestamp;

public class Blacklist {
    int id;//黑名单表id
    int userId;//用户id
    int blacklistUserId;//被列入黑名单的用户
    Timestamp updateTime;//最后更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBlacklistUserId() {
        return blacklistUserId;
    }

    public void setBlacklistUserId(int blacklistUserId) {
        this.blacklistUserId = blacklistUserId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Blacklist() {

    }

    public Blacklist(int id, int userId, int blacklistUserId, Timestamp updateTime) {

        this.id = id;
        this.userId = userId;
        this.blacklistUserId = blacklistUserId;
        this.updateTime = updateTime;
    }
}
