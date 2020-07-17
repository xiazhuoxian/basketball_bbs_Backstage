package com.xiazhuoxian.bbs.pojo;

import com.xiazhuoxian.bbs.enums.SeasonClassificationEnum;

import java.sql.Timestamp;

public class TeamAverageData {
    int Id;//球队数据表id
    TeamInfo team;//球队id
    int seasonNumber;//第几赛季
    SeasonClassificationEnum seasonClassification;//赛季分类 季前赛，常规赛，季后赛
    int numberOfMatch;//比赛场数
    int numberHomeWin;//主场胜利次数
    int numberHomeFail;//主场失败次数
    int numberAwayWin;//客场胜利次数
    int numberAwayFail;//客场失败次数
    float score;//得分
    float losePoints;//失分
    float backboard;//篮板
    float assists;//助攻
    float error;//失误
    float steals;//抢断
    float blockShot;//;盖帽
    float foul;//犯规
    float shoot;//投射数
    float hit;//命中数
    float shootingPercentage;//投篮命中率
    float threePointShot;//三分出手
    float threePointHit;//三分命中
    float threePointPercentage;//三分命中率
    float freeThrowShot;//罚球出手
    float freeThrowHit;//罚球命中
    float freeThrowPercentage;//罚球命中率
    float paintScore;//内线得分
    float fastBreakScore;//快攻得分
    float secondAttackScore;//二次进攻得分
    float useErrorScore;//利用失误得分
    float substituteScore;//替补得分
    int rounds;//比赛轮数

    public TeamAverageData(TeamInfo team, int seasonNumber, SeasonClassificationEnum seasonClassification) {
        this.team = team;
        this.seasonNumber = seasonNumber;
        this.seasonClassification = seasonClassification;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public TeamInfo getTeam() {
        return team;
    }

    public void setTeam(TeamInfo team) {
        this.team = team;
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

    public int getNumberOfMatch() {
        return numberOfMatch;
    }

    public void setNumberOfMatch(int numberOfMatch) {
        this.numberOfMatch = numberOfMatch;
    }

    public int getNumberHomeWin() {
        return numberHomeWin;
    }

    public void setNumberHomeWin(int numberHomeWin) {
        this.numberHomeWin = numberHomeWin;
    }

    public int getNumberHomeFail() {
        return numberHomeFail;
    }

    public void setNumberHomeFail(int numberHomeFail) {
        this.numberHomeFail = numberHomeFail;
    }

    public int getNumberAwayWin() {
        return numberAwayWin;
    }

    public void setNumberAwayWin(int numberAwayWin) {
        this.numberAwayWin = numberAwayWin;
    }

    public int getNumberAwayFail() {
        return numberAwayFail;
    }

    public void setNumberAwayFail(int numberAwayFail) {
        this.numberAwayFail = numberAwayFail;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public float getLosePoints() {
        return losePoints;
    }

    public void setLosePoints(float losePoints) {
        this.losePoints = losePoints;
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

    public float getFoul() {
        return foul;
    }

    public void setFoul(float foul) {
        this.foul = foul;
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

    public float getThreePointShot() {
        return threePointShot;
    }

    public void setThreePointShot(float threePointShot) {
        this.threePointShot = threePointShot;
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

    public float getFreeThrowShot() {
        return freeThrowShot;
    }

    public void setFreeThrowShot(float freeThrowShot) {
        this.freeThrowShot = freeThrowShot;
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

    public float getPaintScore() {
        return paintScore;
    }

    public void setPaintScore(float paintScore) {
        this.paintScore = paintScore;
    }

    public float getFastBreakScore() {
        return fastBreakScore;
    }

    public void setFastBreakScore(float fastBreakScore) {
        this.fastBreakScore = fastBreakScore;
    }

    public float getSecondAttackScore() {
        return secondAttackScore;
    }

    public void setSecondAttackScore(float secondAttackScore) {
        this.secondAttackScore = secondAttackScore;
    }

    public float getUseErrorScore() {
        return useErrorScore;
    }

    public void setUseErrorScore(float useErrorScore) {
        this.useErrorScore = useErrorScore;
    }

    public float getSubstituteScore() {
        return substituteScore;
    }

    public void setSubstituteScore(float substituteScore) {
        this.substituteScore = substituteScore;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public TeamAverageData() {

    }

    public TeamAverageData(int id, TeamInfo team, int seasonNumber, SeasonClassificationEnum seasonClassification, int numberOfMatch, int numberHomeWin, int numberHomeFail, int numberAwayWin, int numberAwayFail, float score, float losePoints, float backboard, float assists, float error, float steals, float blockShot, float foul, float shoot, float hit, float shootingPercentage, float threePointShot, float threePointHit, float threePointPercentage, float freeThrowShot, float freeThrowHit, float freeThrowPercentage, float paintScore, float fastBreakScore, float secondAttackScore, float useErrorScore, float substituteScore, int rounds) {

        Id = id;
        this.team = team;
        this.seasonNumber = seasonNumber;
        this.seasonClassification = seasonClassification;
        this.numberOfMatch = numberOfMatch;
        this.numberHomeWin = numberHomeWin;
        this.numberHomeFail = numberHomeFail;
        this.numberAwayWin = numberAwayWin;
        this.numberAwayFail = numberAwayFail;
        this.score = score;
        this.losePoints = losePoints;
        this.backboard = backboard;
        this.assists = assists;
        this.error = error;
        this.steals = steals;
        this.blockShot = blockShot;
        this.foul = foul;
        this.shoot = shoot;
        this.hit = hit;
        this.shootingPercentage = shootingPercentage;
        this.threePointShot = threePointShot;
        this.threePointHit = threePointHit;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowShot = freeThrowShot;
        this.freeThrowHit = freeThrowHit;
        this.freeThrowPercentage = freeThrowPercentage;
        this.paintScore = paintScore;
        this.fastBreakScore = fastBreakScore;
        this.secondAttackScore = secondAttackScore;
        this.useErrorScore = useErrorScore;
        this.substituteScore = substituteScore;
        this.rounds = rounds;
    }
}
