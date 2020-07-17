package com.xiazhuoxian.bbs.enums;

public enum SexEnum {
    MALE("MALE","男"),
    FEMALE("FEMALE","女");

    private String sex;
    private String name;

    public String getName() {
        return name;
    }

    SexEnum(String sex, String name) {
        this.sex = sex;
        this.name = name;
    }
}
