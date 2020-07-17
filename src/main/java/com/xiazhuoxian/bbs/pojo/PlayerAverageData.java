package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.SeasonClassificationEnum;

public class PlayerAverageData {
    int id;
    PlayerInfo playerInfo;
    TeamInfo teamInfo;
    int seasonNumber;
    SeasonClassificationEnum seasonClassification;
    float playingTime;
    float score;
    float frontCourtRebounds;
    float defensiveRebounds;
    float backboard;
    float assists;
    float error;
    float steals;
    float blockShot;
    float shoot;
    float hit;
    float shootingPercentage;
    float threePointShoot;
    float threePointHit;
    float threePointPercentage;
    float freeThrowShoot;
    float freeThrowHit;
    float freeThrowPercentage;
    float fastBreakScore;
    float seasonHighestScore;
    float foul;
    int numberOfMatches;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    public TeamInfo getTeamInfo() {
        return teamInfo;
    }

    public void setTeamInfo(TeamInfo teamInfo) {
        this.teamInfo = teamInfo;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(int seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public SeasonClassificationEnum getSeasonClassification() {
        return seasonClassification;
    }

    public void setSeasonClassification(SeasonClassificationEnum seasonClassification) {
        this.seasonClassification = seasonClassification;
    }

    public float getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(float playingTime) {
        this.playingTime = playingTime;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getFrontCourtRebounds() {
        return frontCourtRebounds;
    }

    public void setFrontCourtRebounds(float frontCourtRebounds) {
        this.frontCourtRebounds = frontCourtRebounds;
    }

    public float getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(float defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public float getBackboard() {
        return backboard;
    }

    public void setBackboard(float backboard) {
        this.backboard = backboard;
    }

    public float getAssists() {
        return assists;
    }

    public void setAssists(float assists) {
        this.assists = assists;
    }

    public float getError() {
        return error;
    }

    public void setError(float error) {
        this.error = error;
    }

    public float getSteals() {
        return steals;
    }

    public void setSteals(float steals) {
        this.steals = steals;
    }

    public float getBlockShot() {
        return blockShot;
    }

    public void setBlockShot(float blockShot) {
        this.blockShot = blockShot;
    }

    public float getShoot() {
        return shoot;
    }

    public void setShoot(float shoot) {
        this.shoot = shoot;
    }

    public float getHit() {
        return hit;
    }

    public void setHit(float hit) {
        this.hit = hit;
    }

    public float getShootingPercentage() {
        return shootingPercentage;
    }

    public void setShootingPercentage(float shootingPercentage) {
        this.shootingPercentage = shootingPercentage;
    }

    public float getThreePointShoot() {
        return threePointShoot;
    }

    public void setThreePointShoot(float threePointShoot) {
        this.threePointShoot = threePointShoot;
    }

    public float getThreePointHit() {
        return threePointHit;
    }

    public void setThreePointHit(float threePointHit) {
        this.threePointHit = threePointHit;
    }

    public float getThreePointPercentage() {
        return threePointPercentage;
    }

    public void setThreePointPercentage(float threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }

    public float getFreeThrowShoot() {
        return freeThrowShoot;
    }

    public void setFreeThrowShoot(float freeThrowShoot) {
        this.freeThrowShoot = freeThrowShoot;
    }

    public float getFreeThrowHit() {
        return freeThrowHit;
    }

    public void setFreeThrowHit(float freeThrowHit) {
        this.freeThrowHit = freeThrowHit;
    }

    public float getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(float freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public float getFastBreakScore() {
        return fastBreakScore;
    }

    public void setFastBreakScore(float fastBreakScore) {
        this.fastBreakScore = fastBreakScore;
    }

    public float getSeasonHighestScore() {
        return seasonHighestScore;
    }

    public void setSeasonHighestScore(float seasonHighestScore) {
        this.seasonHighestScore = seasonHighestScore;
    }

    public float getFoul() {
        return foul;
    }

    public void setFoul(float foul) {
        this.foul = foul;
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public void setNumberOfMatches(int numberOfMatches) {
        this.numberOfMatches = numberOfMatches;
    }

    public PlayerAverageData() {

    }

    public PlayerAverageData(int id, PlayerInfo playerInfo, TeamInfo teamInfo, int seasonNumber, SeasonClassificationEnum seasonClassification, float playingTime, float score, float frontCourtRebounds, float defensiveRebounds, float backboard, float assists, float error, float steals, float blockShot, float shoot, float hit, float shootingPercentage, float threePointShoot, float threePointHit, float threePointPercentage, float freeThrowShoot, float freeThrowHit, float freeThrowPercentage, float fastBreakScore, float seasonHighestScore, float foul, int numberOfMatches) {

        this.id = id;
        this.playerInfo = playerInfo;
        this.teamInfo = teamInfo;
        this.seasonNumber = seasonNumber;
        this.seasonClassification = seasonClassification;
        this.playingTime = playingTime;
        this.score = score;
        this.frontCourtRebounds = frontCourtRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.backboard = backboard;
        this.assists = assists;
        this.error = error;
        this.steals = steals;
        this.blockShot = blockShot;
        this.shoot = shoot;
        this.hit = hit;
        this.shootingPercentage = shootingPercentage;
        this.threePointShoot = threePointShoot;
        this.threePointHit = threePointHit;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowShoot = freeThrowShoot;
        this.freeThrowHit = freeThrowHit;
        this.freeThrowPercentage = freeThrowPercentage;
        this.fastBreakScore = fastBreakScore;
        this.seasonHighestScore = seasonHighestScore;
        this.foul = foul;
        this.numberOfMatches = numberOfMatches;
    }
}
