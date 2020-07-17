package com.xiazhuoxian.bbs.enums;

public enum StatusEnum {
    LOCKING("LOCKING","锁定"),//锁定
    MUTED("MUTED","禁言"),//禁言
    NORMAL("NORMAL","正常");//正常

    private String status;
    private String name;

    public String getName() {
        return name;
    }

    StatusEnum(String status, String name) {
        this.status = status;
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
}
