package com.xiazhuoxian.bbs.enums;

public enum IdentityEnum {
    ADMIN("ADMIN","管理员"),
    USER("USER","用户");

    private String identity;
    private String name;

    public String getName() {
        return name;
    }

    IdentityEnum(String identity, String name) {
        this.identity = identity;
        this.name = name;
    }

}
