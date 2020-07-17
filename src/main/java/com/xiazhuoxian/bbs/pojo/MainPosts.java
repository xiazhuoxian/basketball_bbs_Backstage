package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.StatusEnum;

import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;

public class MainPosts {
    Integer mainPostsId;
    PlateClassification plateClassification;
    UnionClassification unionClassification;
    CommunityClassification communityClassification;
    StatusEnum status;
    String title;
    String content;
    IdentityEnum posterIdentity;
    AdminInfo adminInfo;
    UserInfo userInfo;
    int numberOfCollected;//被收藏次数
    int numberOfRecommended;//被推荐次数
    int numberOfRead;//被阅读次数
    int numberOfCommented;//被评论次数
    Timestamp createTime;
    Timestamp updateTime;
    Date updateDate;
    Time time;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setMainPostsId(Integer mainPostsId) {
        this.mainPostsId = mainPostsId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public MainPosts(int mainPostsId) {
        this.mainPostsId = mainPostsId;
    }

    public MainPosts(int mainPostsId, PlateClassification plateClassification, UnionClassification unionClassification, CommunityClassification communityClassification, String title, String content, Timestamp updateTime) {
        this.mainPostsId = mainPostsId;
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.communityClassification = communityClassification;
        this.title = title;
        this.content = content;
        this.updateTime = updateTime;
    }

    public MainPosts(PlateClassification plateClassification, UnionClassification unionClassification, CommunityClassification communityClassification, StatusEnum status, String title, String content, IdentityEnum posterIdentity, int numberOfCollected, int numberOfRecommended, int numberOfRead, int numberOfCommented, Timestamp createTime, Timestamp updateTime) {
        this.plateClassification = plateClassification;

        this.unionClassification = unionClassification;
        this.communityClassification = communityClassification;
        this.status = status;
        this.title = title;
        this.content = content;
        this.posterIdentity = posterIdentity;
        this.numberOfCollected = numberOfCollected;
        this.numberOfRecommended = numberOfRecommended;
        this.numberOfRead = numberOfRead;
        this.numberOfCommented = numberOfCommented;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public MainPosts() {
    }

    public MainPosts(int mainPostsId, PlateClassification plateClassification, UnionClassification unionClassification, CommunityClassification communityClassification, StatusEnum status, String title, String content, IdentityEnum posterIdentity, AdminInfo adminInfo, UserInfo userInfo, int numberOfCollected, int numberOfRecommended, int numberOfRead, int numberOfCommented, Timestamp createTime, Timestamp updateTime) {

        this.mainPostsId = mainPostsId;
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.communityClassification = communityClassification;
        this.status = status;
        this.title = title;
        this.content = content;
        this.posterIdentity = posterIdentity;
        this.adminInfo = adminInfo;
        this.userInfo = userInfo;
        this.numberOfCollected = numberOfCollected;
        this.numberOfRecommended = numberOfRecommended;
        this.numberOfRead = numberOfRead;
        this.numberOfCommented = numberOfCommented;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public int getMainPostsId() {

        return mainPostsId;
    }

    public void setMainPostsId(int mainPostsId) {
        this.mainPostsId = mainPostsId;
    }

    public PlateClassification getPlateClassification() {
        return plateClassification;
    }

    public void setPlateClassification(PlateClassification plateClassification) {
        this.plateClassification = plateClassification;
    }

    public UnionClassification getUnionClassification() {
        return unionClassification;
    }

    public void setUnionClassification(UnionClassification unionClassification) {
        this.unionClassification = unionClassification;
    }

    public CommunityClassification getCommunityClassification() {
        return communityClassification;
    }

    public void setCommunityClassification(CommunityClassification communityClassification) {
        this.communityClassification = communityClassification;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public IdentityEnum getPosterIdentity() {
        return posterIdentity;
    }

    public void setPosterIdentity(IdentityEnum posterIdentity) {
        this.posterIdentity = posterIdentity;
    }

    public AdminInfo getAdminInfo() {
        return adminInfo;
    }

    public void setAdminInfo(AdminInfo adminInfo) {
        this.adminInfo = adminInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getNumberOfCollected() {
        return numberOfCollected;
    }

    public void setNumberOfCollected(int numberOfCollected) {
        this.numberOfCollected = numberOfCollected;
    }

    public int getNumberOfRecommended() {
        return numberOfRecommended;
    }

    public void setNumberOfRecommended(int numberOfRecommended) {
        this.numberOfRecommended = numberOfRecommended;
    }

    public int getNumberOfRead() {
        return numberOfRead;
    }

    public void setNumberOfRead(int numberOfRead) {
        this.numberOfRead = numberOfRead;
    }

    public int getNumberOfCommented() {
        return numberOfCommented;
    }

    public void setNumberOfCommented(int numberOfCommented) {
        this.numberOfCommented = numberOfCommented;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
