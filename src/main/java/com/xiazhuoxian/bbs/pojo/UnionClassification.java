package com.xiazhuoxian.bbs.pojo;

public class UnionClassification {
    int unionId;
    String unionName;

    public int getUnionId() {
        return unionId;
    }

    public UnionClassification(int unionId) {
        this.unionId = unionId;
    }

    public void setUnionId(int unionId) {
        this.unionId = unionId;
    }

    public String getUnionName() {
        return unionName;
    }

    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

    public UnionClassification() {

    }

    public UnionClassification(int unionId, String unionName) {

        this.unionId = unionId;
        this.unionName = unionName;
    }
}
