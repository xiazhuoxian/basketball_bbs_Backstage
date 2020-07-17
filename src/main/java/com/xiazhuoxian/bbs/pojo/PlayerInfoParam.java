package com.xiazhuoxian.bbs.pojo;

import org.springframework.web.multipart.MultipartFile;

public class PlayerInfoParam extends PlayerInfo{
    MultipartFile iconFile;
    String birthString;
    String teamName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public MultipartFile getIconFile() {
        return iconFile;
    }

    public void setIconFile(MultipartFile iconFile) {
        this.iconFile = iconFile;
    }

    public String getBirthString() {
        return birthString;
    }

    public void setBirthString(String birthString) {
        this.birthString = birthString;
    }
}
