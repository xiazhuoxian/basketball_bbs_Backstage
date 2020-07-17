package com.xiazhuoxian.bbs.pojo;

import org.springframework.web.multipart.MultipartFile;

public class MessageParam extends Message{
    int currentPageNumber;//当前页数
    int totalPages;//总页数
    int totalItems;//总项数
    int itemsDisplayedPerPage;//每页显示的项数
    String selectCondition;//查询条件
    int senderId;
    int receiverId;
    MultipartFile imgFile;

    public MultipartFile getImgFile() {
        return imgFile;
    }

    public void setImgFile(MultipartFile imgFile) {
        this.imgFile = imgFile;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
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
}
