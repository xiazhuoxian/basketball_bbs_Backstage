package com.xiazhuoxian.bbs.pojo;

public class HomePageCarousel {
    int id;
    String caption;
    String text;
    String imgSrc;

    public HomePageCarousel() {
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public HomePageCarousel(int id, String caption, String text, String imgSrc) {

        this.id = id;
        this.caption = caption;
        this.text = text;
        this.imgSrc = imgSrc;
    }
}
