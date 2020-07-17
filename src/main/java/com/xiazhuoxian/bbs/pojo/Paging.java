package com.xiazhuoxian.bbs.pojo;

import java.util.List;

public class Paging {
    int currentPageNumber;//当前页数
    int totalPages;//总页数
    int totalItems;//总项数
    int itemsDisplayedPerPage;//每页显示的项数
    String selectCondition;//查询条件
    List<UserInfo> userResult;//用户查询结果
    List<News> newsResult;//新闻查询结果
    List<Video> videoResult;//视频查询结果
    List<MainPosts> mainPostsResult;//主贴查询结果
    List<MainPostsComments> mainPostsCommentsResult;//主贴评论查询结果
    List<MatchSchedule> matchSchedulesResult;//赛程表查询结果
    List<PlayerInfo> playerInfosResult;//球员信息查询结果
    List<Message> messagesResult;//消息查询结果

    public List<Message> getMessagesResult() {
        return messagesResult;
    }

    public void setMessagesResult(List<Message> messagesResult) {
        this.messagesResult = messagesResult;
    }

    public Paging(int currentPageNumber, int itemsDisplayedPerPage) {
        this.currentPageNumber = currentPageNumber;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
    }

    public List<PlayerInfo> getPlayerInfosResult() {
        return playerInfosResult;
    }

    public void setPlayerInfosResult(List<PlayerInfo> playerInfosResult) {
        this.playerInfosResult = playerInfosResult;
    }

    public List<MatchSchedule> getMatchSchedulesResult() {
        return matchSchedulesResult;
    }

    public void setMatchSchedulesResult(List<MatchSchedule> matchSchedulesResult) {
        this.matchSchedulesResult = matchSchedulesResult;
    }

    public List<MainPostsComments> getMainPostsCommentsResult() {
        return mainPostsCommentsResult;
    }

    public void setMainPostsCommentsResult(List<MainPostsComments> mainPostsCommentsResult) {
        this.mainPostsCommentsResult = mainPostsCommentsResult;
    }

    public Paging(int currentPageNumber, int totalPages, int totalItems, int itemsDisplayedPerPage, String selectCondition, List<UserInfo> userResult, List<News> newsResult, List<Video> videoResult, List<MainPosts> mainPostsResult, List<MainPostsComments> mainPostsCommentsResult) {

        this.currentPageNumber = currentPageNumber;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
        this.selectCondition = selectCondition;
        this.userResult = userResult;
        this.newsResult = newsResult;
        this.videoResult = videoResult;
        this.mainPostsResult = mainPostsResult;
        this.mainPostsCommentsResult = mainPostsCommentsResult;
    }

    public List<MainPosts> getMainPostsResult() {
        return mainPostsResult;
    }

    public void setMainPostsResult(List<MainPosts> mainPostsResult) {
        this.mainPostsResult = mainPostsResult;
    }

    public Paging(int currentPageNumber, int totalPages, int totalItems, int itemsDisplayedPerPage, String selectCondition, List<UserInfo> userResult, List<News> newsResult, List<Video> videoResult, List<MainPosts> mainPostsResult) {
        this.currentPageNumber = currentPageNumber;

        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
        this.selectCondition = selectCondition;
        this.userResult = userResult;
        this.newsResult = newsResult;
        this.videoResult = videoResult;
        this.mainPostsResult = mainPostsResult;
    }

    public Paging(int currentPageNumber, int totalPages, int totalItems, int itemsDisplayedPerPage, String selectCondition, List<UserInfo> userResult, List<News> newsResult, List<Video> videoResult) {
        this.currentPageNumber = currentPageNumber;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
        this.selectCondition = selectCondition;
        this.userResult = userResult;
        this.newsResult = newsResult;
        this.videoResult = videoResult;
    }

    public List<UserInfo> getUserResult() {

        return userResult;
    }

    public void setUserResult(List<UserInfo> userResult) {
        this.userResult = userResult;
    }

    public List<Video> getVideoResult() {
        return videoResult;
    }

    public void setVideoResult(List<Video> videoResult) {
        this.videoResult = videoResult;
    }

    public Paging(int currentPageNumber, int totalPages, int totalItems, int itemsDisplayedPerPage, String selectCondition, List<News> newsResult, List<Video> videoResult) {

        this.currentPageNumber = currentPageNumber;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
        this.selectCondition = selectCondition;
        this.newsResult = newsResult;
        this.videoResult = videoResult;
    }

    public Paging(int currentPageNumber, int itemsDisplayedPerPage, String selectCondition) {
        this.currentPageNumber = currentPageNumber;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
        this.selectCondition = selectCondition;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        this.currentPageNumber = currentPageNumber;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getItemsDisplayedPerPage() {
        return itemsDisplayedPerPage;
    }

    public void setItemsDisplayedPerPage(int itemsDisplayedPerPage) {
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
    }

    public String getSelectCondition() {
        return selectCondition;
    }

    public void setSelectCondition(String selectCondition) {
        this.selectCondition = selectCondition;
    }

    public List<News> getNewsResult() {
        return newsResult;
    }

    public void setNewsResult(List<News> newsResult) {
        this.newsResult = newsResult;
    }

    public Paging() {

    }

    public Paging(int currentPageNumber, int totalPages, int totalItems, int itemsDisplayedPerPage, String selectCondition, List<News> newsResult) {

        this.currentPageNumber = currentPageNumber;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.itemsDisplayedPerPage = itemsDisplayedPerPage;
        this.selectCondition = selectCondition;
        this.newsResult = newsResult;
    }
}
