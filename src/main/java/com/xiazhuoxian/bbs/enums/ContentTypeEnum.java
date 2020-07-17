package com.xiazhuoxian.bbs.enums;

public enum ContentTypeEnum {
    HTML("HTML","富文本"),
    TEXT("TEXT","文字"),
    IMG("IMG","图片");

    private String contentType;
    private String name;

    public String getName() {
        return name;
    }

    ContentTypeEnum(String contentType, String name) {
        this.contentType = contentType;
        this.name = name;
    }

}
