package com.xiazhuoxian.bbs.pojo;

import org.springframework.web.multipart.MultipartFile;

public class NewsParam extends News {
    MultipartFile coverFile;

    public MultipartFile getCoverFile() {
        return coverFile;
    }

    public void setCoverFile(MultipartFile coverFile) {
        this.coverFile = coverFile;
    }
}
