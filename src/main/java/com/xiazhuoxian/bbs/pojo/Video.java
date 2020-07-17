package com.xiazhuoxian.bbs.pojo;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Video {
    int videoId;
    PlateClassification plateClassification;
    UnionClassification unionClassification;
    String cover;
    String title;
    String videoAddress;
    String content;
    AdminInfo poster;
    int numberOfCollected;
    int numberOfRecommended;
    int numberOfRead;
    int numberOfCommented;
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

    public Video(PlateClassification plateClassification, UnionClassification unionClassification, String cover, String title, String videoAddress, String content, AdminInfo poster, int numberOfCollected, int numberOfRecommended, int numberOfRead, int numberOfCommented, Timestamp updateTime) {
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.cover = cover;
        this.title = title;
        this.videoAddress = videoAddress;
        this.content = content;
        this.poster = poster;
        this.numberOfCollected = numberOfCollected;
        this.numberOfRecommended = numberOfRecommended;
        this.numberOfRead = numberOfRead;
        this.numberOfCommented = numberOfCommented;
        this.updateTime = updateTime;
    }

    public Video(int videoId, PlateClassification plateClassification, UnionClassification unionClassification, String cover, String title, String videoAddress, String content, AdminInfo poster, int numberOfCollected, int numberOfRecommended, int numberOfRead, int numberOfCommented, Timestamp updateTime) {

        this.videoId = videoId;
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.cover = cover;
        this.title = title;
        this.videoAddress = videoAddress;
        this.content = content;
        this.poster = poster;
        this.numberOfCollected = numberOfCollected;
        this.numberOfRecommended = numberOfRecommended;
        this.numberOfRead = numberOfRead;
        this.numberOfCommented = numberOfCommented;
        this.updateTime = updateTime;
    }

    public Video(PlateClassification plateClassification, UnionClassification unionClassification, String title, String videoAddress, String content, AdminInfo poster, int numberOfCollected, int numberOfRecommended, int numberOfRead, int numberOfCommented, Timestamp updateTime) {
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.title = title;
        this.videoAddress = videoAddress;
        this.content = content;
        this.poster = poster;
        this.numberOfCollected = numberOfCollected;
        this.numberOfRecommended = numberOfRecommended;
        this.numberOfRead = numberOfRead;
        this.numberOfCommented = numberOfCommented;
        this.updateTime = updateTime;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoAddress() {
        return videoAddress;
    }

    public void setVideoAddress(String videoAddress) {
        this.videoAddress = videoAddress;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AdminInfo getPoster() {
        return poster;
    }

    public void setPoster(AdminInfo poster) {
        this.poster = poster;
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

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Video() {

    }

    public Video(int videoId, PlateClassification plateClassification, UnionClassification unionClassification, String title, String videoAddress, String content, AdminInfo poster, int numberOfCollected, int numberOfRecommended, int numberOfRead, int numberOfCommented, Timestamp updateTime) {

        this.videoId = videoId;
        this.plateClassification = plateClassification;
        this.unionClassification = unionClassification;
        this.title = title;
        this.videoAddress = videoAddress;
        this.content = content;
        this.poster = poster;
        this.numberOfCollected = numberOfCollected;
        this.numberOfRecommended = numberOfRecommended;
        this.numberOfRead = numberOfRead;
        this.numberOfCommented = numberOfCommented;
        this.updateTime = updateTime;
    }
}
