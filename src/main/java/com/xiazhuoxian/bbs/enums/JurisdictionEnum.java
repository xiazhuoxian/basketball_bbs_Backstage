package com.xiazhuoxian.bbs.enums;

public enum JurisdictionEnum {
    NEWS("NEWS","新闻"),
    VIDEO("VIDEO","视频"),
    COMMUNITY("COMMUNITY","社区");

    private String Jurisdiction;
    private String name;

    public String getName() {
        return name;
    }

    JurisdictionEnum(String Jurisdiction, String name) {
        this.Jurisdiction = Jurisdiction;
        this.name = name;
    }
}
