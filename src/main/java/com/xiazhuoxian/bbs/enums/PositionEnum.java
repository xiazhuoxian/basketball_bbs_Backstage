package com.xiazhuoxian.bbs.enums;

public enum  PositionEnum {
    PG("PG","控球后卫"),
    SG("SG","得分后卫"),
    SF("SF","小前锋"),
    PF("PF","大前锋"),
    C("C","中锋");

    String position;
    String name;

    public String getName() {
        return name;
    }

    PositionEnum() {
    }

    PositionEnum(String position, String name) {

        this.position = position;
        this.name = name;
    }
}
