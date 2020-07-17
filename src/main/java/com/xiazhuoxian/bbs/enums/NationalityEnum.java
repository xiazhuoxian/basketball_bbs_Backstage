package com.xiazhuoxian.bbs.enums;

public enum  NationalityEnum {
    CHINA("CHINA","中国"),
    USA("USA","美国"),
    UK("UK","英国");

    String nationality;
    String name;

    public String getName() {
        return name;
    }

    NationalityEnum(String nationality, String name) {

        this.nationality = nationality;
        this.name = name;
    }
}
