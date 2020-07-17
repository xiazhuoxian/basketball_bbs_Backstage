package com.xiazhuoxian.bbs.pojo;

public class TeamInfo {
    int teamId;
    String name;
    String icon;
    UnionClassification union;
    PartitionClassification partition;//所属分区
    String local;//所属地址
    String home;//所属主场
    String introduce;//球队简介

    public TeamInfo(int teamId) {
        this.teamId = teamId;
    }

    public TeamInfo(String name, String icon, UnionClassification union, PartitionClassification partition, String local, String home, String introduce) {
        this.name = name;
        this.icon = icon;
        this.union = union;
        this.partition = partition;
        this.local = local;
        this.home = home;
        this.introduce = introduce;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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

    public UnionClassification getUnion() {
        return union;
    }

    public void setUnion(UnionClassification union) {
        this.union = union;
    }

    public PartitionClassification getPartition() {
        return partition;
    }

    public void setPartition(PartitionClassification partition) {
        this.partition = partition;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public TeamInfo() {

    }

    public TeamInfo(int teamId, String name, String icon, UnionClassification union, PartitionClassification partition, String local, String home, String introduce) {

        this.teamId = teamId;
        this.name = name;
        this.icon = icon;
        this.union = union;
        this.partition = partition;
        this.local = local;
        this.home = home;
        this.introduce = introduce;
    }
}
