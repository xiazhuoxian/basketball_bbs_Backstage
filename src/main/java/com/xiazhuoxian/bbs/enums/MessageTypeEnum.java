package com.xiazhuoxian.bbs.enums;

public enum MessageTypeEnum {
    PRIVATE_LETTER("PRIVATE_LETTER","私信"),
    REPLY("REPLY","回复"),
    NOTICE("NOTICE","通知"),
    PUBLIC_NOTICE("PUBLIC_NOTICE","公告");

    private String messageType;
    private String name;

    public String getName() {
        return name;
    }

    MessageTypeEnum(String messageType, String name) {
        this.messageType = messageType;
        this.name = name;
    }
}
