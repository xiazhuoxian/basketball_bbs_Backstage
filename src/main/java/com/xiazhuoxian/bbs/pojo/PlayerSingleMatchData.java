package com.xiazhuoxian.bbs.pojo;

public class  PlayerSingleMatchData {
    int id;
    PlayerInfo playerInfo;
    MatchSchedule matchSchedule;
    float palyingTime;
    int score;
    int shot;
    int hit;
    float shootingPercentage;
    int threePointShot;
    int threePointHit;
    float threePointPercentage;
    int freeThrowShot;
    int freeThrowHit;
    float freeThrowPercentage;
    int paintScore;
    int frontCourtRebounds;
    int defensiveRebounds;
    int backboard;
    int assists;
    int error;
    int steals;
    int blockShot;
    int fastBreakScore;
    int foul;

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

    public MatchSchedule getMatchSchedule() {
        return matchSchedule;
    }

    public void setMatchSchedule(MatchSchedule matchSchedule) {
        this.matchSchedule = matchSchedule;
    }

    public float getPalyingTime() {
        return palyingTime;
    }

    public void setPalyingTime(float palyingTime) {
        this.palyingTime = palyingTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public float getShootingPercentage() {
        return shootingPercentage;
    }

    public void setShootingPercentage(float shootingPercentage) {
        this.shootingPercentage = shootingPercentage;
    }

    public int getThreePointShot() {
        return threePointShot;
    }

    public void setThreePointShot(int threePointShot) {
        this.threePointShot = threePointShot;
    }

    public int getThreePointHit() {
        return threePointHit;
    }

    public void setThreePointHit(int threePointHit) {
        this.threePointHit = threePointHit;
    }

    public float getThreePointPercentage() {
        return threePointPercentage;
    }

    public void setThreePointPercentage(float threePointPercentage) {
        this.threePointPercentage = threePointPercentage;
    }

    public int getFreeThrowShot() {
        return freeThrowShot;
    }

    public void setFreeThrowShot(int freeThrowShot) {
        this.freeThrowShot = freeThrowShot;
    }

    public int getFreeThrowHit() {
        return freeThrowHit;
    }

    public void setFreeThrowHit(int freeThrowHit) {
        this.freeThrowHit = freeThrowHit;
    }

    public float getFreeThrowPercentage() {
        return freeThrowPercentage;
    }

    public void setFreeThrowPercentage(float freeThrowPercentage) {
        this.freeThrowPercentage = freeThrowPercentage;
    }

    public int getPaintScore() {
        return paintScore;
    }

    public void setPaintScore(int paintScore) {
        this.paintScore = paintScore;
    }

    public int getFrontCourtRebounds() {
        return frontCourtRebounds;
    }

    public void setFrontCourtRebounds(int frontCourtRebounds) {
        this.frontCourtRebounds = frontCourtRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public void setDefensiveRebounds(int defensiveRebounds) {
        this.defensiveRebounds = defensiveRebounds;
    }

    public int getBackboard() {
        return backboard;
    }

    public void setBackboard(int backboard) {
        this.backboard = backboard;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getBlockShot() {
        return blockShot;
    }

    public void setBlockShot(int blockShot) {
        this.blockShot = blockShot;
    }

    public int getFastBreakScore() {
        return fastBreakScore;
    }

    public void setFastBreakScore(int fastBreakScore) {
        this.fastBreakScore = fastBreakScore;
    }

    public int getFoul() {
        return foul;
    }

    public void setFoul(int foul) {
        this.foul = foul;
    }

    public PlayerSingleMatchData() {

    }

    public PlayerSingleMatchData(int id, PlayerInfo playerInfo, MatchSchedule matchSchedule, float palyingTime, int score, int shot, int hit, float shootingPercentage, int threePointShot, int threePointHit, float threePointPercentage, int freeThrowShot, int freeThrowHit, float freeThrowPercentage, int paintScore, int frontCourtRebounds, int defensiveRebounds, int backboard, int assists, int error, int steals, int blockShot, int fastBreakScore, int foul) {

        this.id = id;
        this.playerInfo = playerInfo;
        this.matchSchedule = matchSchedule;
        this.palyingTime = palyingTime;
        this.score = score;
        this.shot = shot;
        this.hit = hit;
        this.shootingPercentage = shootingPercentage;
        this.threePointShot = threePointShot;
        this.threePointHit = threePointHit;
        this.threePointPercentage = threePointPercentage;
        this.freeThrowShot = freeThrowShot;
        this.freeThrowHit = freeThrowHit;
        this.freeThrowPercentage = freeThrowPercentage;
        this.paintScore = paintScore;
        this.frontCourtRebounds = frontCourtRebounds;
        this.defensiveRebounds = defensiveRebounds;
        this.backboard = backboard;
        this.assists = assists;
        this.error = error;
        this.steals = steals;
        this.blockShot = blockShot;
        this.fastBreakScore = fastBreakScore;
        this.foul = foul;
    }
}
