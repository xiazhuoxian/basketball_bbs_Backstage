package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.IdentityEnum;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class MainPostsComments {
    int mainPostsCommentsId;
    IdentityEnum posterIdentity;
    AdminInfo adminInfo;
    UserInfo userInfo;
    PlateClassification plateClassification;
    UnionClassification unionClassification;
    CommunityClassification communityClassification;
    MainPosts mainPosts;
    Integer parentCommentId;
    String parentCommentPosterNickname;
    Integer headCommentId;
    int numberOfComment;
    int numberOfLiked;
    String content;
    Timestamp updateTime;
    Date updateDate;
    Time time;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public MainPostsComments(int mainPostsCommentsId, String content, Timestamp updateTime) {
        this.mainPostsCommentsId = mainPostsCommentsId;
        this.content = content;
        this.updateTime = updateTime;
    }

    public MainPostsComments(IdentityEnum posterIdentity, PlateClassification plateClassification, UnionClassification unionClassification, CommunityClassification communityClassification, MainPosts mainPosts, Integer parentCommentId, String parentCommentPosterNickname, Integer headCommentId, int numberOfComment, int numberOfLiked, String content, Timestamp updateTime) {
        this.posterIdentity = posterIdentity;
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.communityClassification = communityClassification;
        this.mainPosts = mainPosts;
        this.parentCommentId = parentCommentId;
        this.parentCommentPosterNickname = parentCommentPosterNickname;
        this.headCommentId = headCommentId;
        this.numberOfComment = numberOfComment;
        this.numberOfLiked = numberOfLiked;
        this.content = content;
        this.updateTime = updateTime;
    }

    public int getMainPostsCommentsId() {
        return mainPostsCommentsId;
    }

    public void setMainPostsCommentsId(int mainPostsCommentsId) {
        this.mainPostsCommentsId = mainPostsCommentsId;
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

    public MainPosts getMainPosts() {
        return mainPosts;
    }

    public void setMainPosts(MainPosts mainPosts) {
        this.mainPosts = mainPosts;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getParentCommentPosterNickname() {
        return parentCommentPosterNickname;
    }

    public void setParentCommentPosterNickname(String parentCommentPosterNickname) {
        this.parentCommentPosterNickname = parentCommentPosterNickname;
    }

    public Integer getHeadCommentId() {
        return headCommentId;
    }

    public void setHeadCommentId(Integer headCommentId) {
        this.headCommentId = headCommentId;
    }

    public int getNumberOfComment() {
        return numberOfComment;
    }

    public void setNumberOfComment(int numberOfComment) {
        this.numberOfComment = numberOfComment;
    }

    public int getNumberOfLiked() {
        return numberOfLiked;
    }

    public void setNumberOfLiked(int numberOfLiked) {
        this.numberOfLiked = numberOfLiked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public MainPostsComments() {

    }

    public MainPostsComments(int mainPostsCommentsId, IdentityEnum posterIdentity, AdminInfo adminInfo, UserInfo userInfo, PlateClassification plateClassification, UnionClassification unionClassification, CommunityClassification communityClassification, MainPosts mainPosts, Integer parentCommentId, String parentCommentPosterNickname, Integer headCommentId, int numberOfComment, int numberOfLiked, String content, Timestamp updateTime) {

        this.mainPostsCommentsId = mainPostsCommentsId;
        this.posterIdentity = posterIdentity;
        this.adminInfo = adminInfo;
        this.userInfo = userInfo;
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.communityClassification = communityClassification;
        this.mainPosts = mainPosts;
        this.parentCommentId = parentCommentId;
        this.parentCommentPosterNickname = parentCommentPosterNickname;
        this.headCommentId = headCommentId;
        this.numberOfComment = numberOfComment;
        this.numberOfLiked = numberOfLiked;
        this.content = content;
        this.updateTime = updateTime;
    }
}
