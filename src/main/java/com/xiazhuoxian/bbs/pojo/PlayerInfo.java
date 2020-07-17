package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.NationalityEnum;
import com.xiazhuoxian.bbs.enums.PositionEnum;

import java.sql.Date;

public class PlayerInfo {
    int id;//球员id
    String name;//球员名
    String icon;//球员头像
    TeamInfo teamInfo;//所属球队
    int number;//球衣号码
    PositionEnum position;//职位
    Date birth;//出生时间
    int age;//年龄
    float height;//身高
    float armExhibition;//臂展
    float weight;//体重
    float standingReach;//站立摸高
    NationalityEnum nationality;//国籍
    float wages;//工资
    String introduce;//球员介绍

    public PlayerInfo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getArmExhibition() {
        return armExhibition;
    }

    public void setArmExhibition(float armExhibition) {
        this.armExhibition = armExhibition;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getStandingReach() {
        return standingReach;
    }

    public void setStandingReach(float standingReach) {
        this.standingReach = standingReach;
    }

    public NationalityEnum getNationality() {
        return nationality;
    }

    public void setNationality(NationalityEnum nationality) {
        this.nationality = nationality;
    }

    public float getWages() {
        return wages;
    }

    public void setWages(float wages) {
        this.wages = wages;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public PlayerInfo() {

    }

    public PlayerInfo(int id, String name, String icon, TeamInfo teamInfo, int number, PositionEnum position, Date birth, int age, float height, float armExhibition, float weight, float standingReach, NationalityEnum nationality, float wages, String introduce) {

        this.id = id;
        this.name = name;
        this.icon = icon;
        this.teamInfo = teamInfo;
        this.number = number;
        this.position = position;
        this.birth = birth;
        this.age = age;
        this.height = height;
        this.armExhibition = armExhibition;
        this.weight = weight;
        this.standingReach = standingReach;
        this.nationality = nationality;
        this.wages = wages;
        this.introduce = introduce;
    }
}
