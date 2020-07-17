package com.xiazhuoxian.bbs.enums;

public enum  SeasonClassificationEnum {
    PRESEASON("PRESEASON","季前赛"),
    REGULAR_SEASON("REGULAR_SEASON","常规赛"),
    PLAYOFFS("PLAYOFFS","季后赛");

    private String seasonClassification;
    private String name;

    public String getName(){
        return name;
    }

    SeasonClassificationEnum(String seasonClassification, String name) {
        this.seasonClassification = seasonClassification;
        this.name = name;
    }
}
