package com.xiazhuoxian.bbs.pojo;

public class CommunityClassification {
    int communityId;//社区表id
    String communityName;//社区名

    public CommunityClassification(int communityId) {
        this.communityId = communityId;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public CommunityClassification() {

    }

    public CommunityClassification(int communityId, String communityName) {

        this.communityId = communityId;
        this.communityName = communityName;
    }
}
