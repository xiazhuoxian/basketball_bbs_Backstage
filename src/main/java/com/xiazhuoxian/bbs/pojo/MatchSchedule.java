package com.xiazhuoxian.bbs.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.xiazhuoxian.bbs.enums.SeasonClassificationEnum;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class MatchSchedule {
    int id;
    UnionClassification union;//所属联盟
    int seasonNumber;//第几赛季
    SeasonClassificationEnum seasonClassification;//赛季分类
    Date matchDate;//比赛日期
    Time matchTime;//比赛时间
    int matchRound;//比赛轮数
    TeamInfo homeTeam;//主场球队
    int homeSection1Score;//主队第一节得分
    int homeSection2Score;//主队第二节得分
    int homeSection3Score;//主队第三节得分
    int homeSection4Score;//主队第四节得分
    int homeTeamScore;//主场球队得分
    int homeShoot;//主场球队投射数
    int homeHit;//主场球队投射命中数
    float homeShootingPercentage;//主场球队投篮命中率
    int homeThreePointShoot;//主场球队三分投射数
    int homeThreePointHit;//主场球队三分命中数
    float homeThreePointPercentage;//主场球队三分命中率
    int homeFreeThrowShoot;//主场球队罚球数
    int homeFreeThrowHit;//主场球队罚球命中数
    float homeFreeThrowPercentage;//主场球队罚球命中率
    int homeFrontCourtRebounds;//主场球队前场篮板
    int homeDefensiveRebounds;//主场球队后场篮板
    int homeBackboard;//主场球队篮板
    int homeAssists;//主场球队助攻
    int homeError;//主场球队失误
    int homeSteals;//主场球队抢断
    int homeBlockShot;//主场球队盖帽
    int homeFoul;//主场球队犯规次数
    int homeUseErrorScore;//主场球队利用失误得分
    int homePaintScore;//主场球队内线得分
    float homePaintHitPercentage;//主场球队内线命中率
    int homeSecondAttackScore;//主场球队二次进攻得分
    int homeFastBreakScore;//主场球队快攻得分
    TeamInfo awayTeam;//客场球队
    int awaySection1Score;//客场队第一节得分
    int awaySection2Score;//客场队第二节得分
    int awaySection3Score;//客场队第三节得分
    int awaySection4Score;//客场队第四节得分
    int awayTeamScore;//客场球队得分
    int awayShoot;//客场球队投射数
    int awayHit;//客场球队投射命中数
    float awayShootingPercentage;//客场球队投篮命中率
    int awayThreePointShoot;//客场球队三分投射数
    int awayThreePointHit;//客场球队三分命中数
    float awayThreePointPercentage;//客场球队三分命中率
    int awayFreeThrowShoot;//客场球队罚球数
    int awayFreeThrowHit;//客场球队罚球命中数
    float awayFreeThrowPercentage;//客场球队罚球命中率
    int awayFrontCourtRebounds;//客场球队前场篮板
    int awayDefensiveRebounds;//客场球队后场篮板
    int awayBackboard;//客场球队篮板
    int awayAssists;//客场球队助攻
    int awayError;//客场球队失误
    int awaySteals;//客场球队抢断
    int awayBlockShot;//客场球队盖帽
    int awayFoul;//客场球队犯规次数
    int awayUseErrorScore;//客场球队利用失误得分
    int awayPaintScore;//客场球队内线得分
    float awayPaintHitPercentage;//客场球队内线命中率
    int awaySecondAttackScore;//客场球队二次进攻得分
    int awayFastBreakScore;//客场球队快攻得分
    String report;

    public MatchSchedule(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UnionClassification getUnion() {
        return union;
    }

    public void setUnion(UnionClassification union) {
        this.union = union;
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

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Time getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Time matchTime) {
        this.matchTime = matchTime;
    }

    public int getMatchRound() {
        return matchRound;
    }

    public void setMatchRound(int matchRound) {
        this.matchRound = matchRound;
    }

    public TeamInfo getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(TeamInfo homeTeam) {
        this.homeTeam = homeTeam;
    }

    public int getHomeSection1Score() {
        return homeSection1Score;
    }

    public void setHomeSection1Score(int homeSection1Score) {
        this.homeSection1Score = homeSection1Score;
    }

    public int getHomeSection2Score() {
        return homeSection2Score;
    }

    public void setHomeSection2Score(int homeSection2Score) {
        this.homeSection2Score = homeSection2Score;
    }

    public int getHomeSection3Score() {
        return homeSection3Score;
    }

    public void setHomeSection3Score(int homeSection3Score) {
        this.homeSection3Score = homeSection3Score;
    }

    public int getHomeSection4Score() {
        return homeSection4Score;
    }

    public void setHomeSection4Score(int homeSection4Score) {
        this.homeSection4Score = homeSection4Score;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getHomeShoot() {
        return homeShoot;
    }

    public void setHomeShoot(int homeShoot) {
        this.homeShoot = homeShoot;
    }

    public int getHomeHit() {
        return homeHit;
    }

    public void setHomeHit(int homeHit) {
        this.homeHit = homeHit;
    }

    public float getHomeShootingPercentage() {
        return homeShootingPercentage;
    }

    public void setHomeShootingPercentage(float homeShootingPercentage) {
        this.homeShootingPercentage = homeShootingPercentage;
    }

    public int getHomeThreePointShoot() {
        return homeThreePointShoot;
    }

    public void setHomeThreePointShoot(int homeThreePointShoot) {
        this.homeThreePointShoot = homeThreePointShoot;
    }

    public int getHomeThreePointHit() {
        return homeThreePointHit;
    }

    public void setHomeThreePointHit(int homeThreePointHit) {
        this.homeThreePointHit = homeThreePointHit;
    }

    public float getHomeThreePointPercentage() {
        return homeThreePointPercentage;
    }

    public void setHomeThreePointPercentage(float homeThreePointPercentage) {
        this.homeThreePointPercentage = homeThreePointPercentage;
    }

    public int getHomeFreeThrowShoot() {
        return homeFreeThrowShoot;
    }

    public void setHomeFreeThrowShoot(int homeFreeThrowShoot) {
        this.homeFreeThrowShoot = homeFreeThrowShoot;
    }

    public int getHomeFreeThrowHit() {
        return homeFreeThrowHit;
    }

    public void setHomeFreeThrowHit(int homeFreeThrowHit) {
        this.homeFreeThrowHit = homeFreeThrowHit;
    }

    public float getHomeFreeThrowPercentage() {
        return homeFreeThrowPercentage;
    }

    public void setHomeFreeThrowPercentage(float homeFreeThrowPercentage) {
        this.homeFreeThrowPercentage = homeFreeThrowPercentage;
    }

    public int getHomeFrontCourtRebounds() {
        return homeFrontCourtRebounds;
    }

    public void setHomeFrontCourtRebounds(int homeFrontCourtRebounds) {
        this.homeFrontCourtRebounds = homeFrontCourtRebounds;
    }

    public int getHomeDefensiveRebounds() {
        return homeDefensiveRebounds;
    }

    public void setHomeDefensiveRebounds(int homeDefensiveRebounds) {
        this.homeDefensiveRebounds = homeDefensiveRebounds;
    }

    public int getHomeBackboard() {
        return homeBackboard;
    }

    public void setHomeBackboard(int homeBackboard) {
        this.homeBackboard = homeBackboard;
    }

    public int getHomeAssists() {
        return homeAssists;
    }

    public void setHomeAssists(int homeAssists) {
        this.homeAssists = homeAssists;
    }

    public int getHomeError() {
        return homeError;
    }

    public void setHomeError(int homeError) {
        this.homeError = homeError;
    }

    public int getHomeSteals() {
        return homeSteals;
    }

    public void setHomeSteals(int homeSteals) {
        this.homeSteals = homeSteals;
    }

    public int getHomeBlockShot() {
        return homeBlockShot;
    }

    public void setHomeBlockShot(int homeBlockShot) {
        this.homeBlockShot = homeBlockShot;
    }

    public int getHomeFoul() {
        return homeFoul;
    }

    public void setHomeFoul(int homeFoul) {
        this.homeFoul = homeFoul;
    }

    public int getHomeUseErrorScore() {
        return homeUseErrorScore;
    }

    public void setHomeUseErrorScore(int homeUseErrorScore) {
        this.homeUseErrorScore = homeUseErrorScore;
    }

    public int getHomePaintScore() {
        return homePaintScore;
    }

    public void setHomePaintScore(int homePaintScore) {
        this.homePaintScore = homePaintScore;
    }

    public float getHomePaintHitPercentage() {
        return homePaintHitPercentage;
    }

    public void setHomePaintHitPercentage(float homePaintHitPercentage) {
        this.homePaintHitPercentage = homePaintHitPercentage;
    }

    public int getHomeSecondAttackScore() {
        return homeSecondAttackScore;
    }

    public void setHomeSecondAttackScore(int homeSecondAttackScore) {
        this.homeSecondAttackScore = homeSecondAttackScore;
    }

    public int getHomeFastBreakScore() {
        return homeFastBreakScore;
    }

    public void setHomeFastBreakScore(int homeFastBreakScore) {
        this.homeFastBreakScore = homeFastBreakScore;
    }

    public TeamInfo getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(TeamInfo awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getAwaySection1Score() {
        return awaySection1Score;
    }

    public void setAwaySection1Score(int awaySection1Score) {
        this.awaySection1Score = awaySection1Score;
    }

    public int getAwaySection2Score() {
        return awaySection2Score;
    }

    public void setAwaySection2Score(int awaySection2Score) {
        this.awaySection2Score = awaySection2Score;
    }

    public int getAwaySection3Score() {
        return awaySection3Score;
    }

    public void setAwaySection3Score(int awaySection3Score) {
        this.awaySection3Score = awaySection3Score;
    }

    public int getAwaySection4Score() {
        return awaySection4Score;
    }

    public void setAwaySection4Score(int awaySection4Score) {
        this.awaySection4Score = awaySection4Score;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public int getAwayShoot() {
        return awayShoot;
    }

    public void setAwayShoot(int awayShoot) {
        this.awayShoot = awayShoot;
    }

    public int getAwayHit() {
        return awayHit;
    }

    public void setAwayHit(int awayHit) {
        this.awayHit = awayHit;
    }

    public float getAwayShootingPercentage() {
        return awayShootingPercentage;
    }

    public void setAwayShootingPercentage(float awayShootingPercentage) {
        this.awayShootingPercentage = awayShootingPercentage;
    }

    public int getAwayThreePointShoot() {
        return awayThreePointShoot;
    }

    public void setAwayThreePointShoot(int awayThreePointShoot) {
        this.awayThreePointShoot = awayThreePointShoot;
    }

    public int getAwayThreePointHit() {
        return awayThreePointHit;
    }

    public void setAwayThreePointHit(int awayThreePointHit) {
        this.awayThreePointHit = awayThreePointHit;
    }

    public float getAwayThreePointPercentage() {
        return awayThreePointPercentage;
    }

    public void setAwayThreePointPercentage(float awayThreePointPercentage) {
        this.awayThreePointPercentage = awayThreePointPercentage;
    }

    public int getAwayFreeThrowShoot() {
        return awayFreeThrowShoot;
    }

    public void setAwayFreeThrowShoot(int awayFreeThrowShoot) {
        this.awayFreeThrowShoot = awayFreeThrowShoot;
    }

    public int getAwayFreeThrowHit() {
        return awayFreeThrowHit;
    }

    public void setAwayFreeThrowHit(int awayFreeThrowHit) {
        this.awayFreeThrowHit = awayFreeThrowHit;
    }

    public float getAwayFreeThrowPercentage() {
        return awayFreeThrowPercentage;
    }

    public void setAwayFreeThrowPercentage(float awayFreeThrowPercentage) {
        this.awayFreeThrowPercentage = awayFreeThrowPercentage;
    }

    public int getAwayFrontCourtRebounds() {
        return awayFrontCourtRebounds;
    }

    public void setAwayFrontCourtRebounds(int awayFrontCourtRebounds) {
        this.awayFrontCourtRebounds = awayFrontCourtRebounds;
    }

    public int getAwayDefensiveRebounds() {
        return awayDefensiveRebounds;
    }

    public void setAwayDefensiveRebounds(int awayDefensiveRebounds) {
        this.awayDefensiveRebounds = awayDefensiveRebounds;
    }

    public int getAwayBackboard() {
        return awayBackboard;
    }

    public void setAwayBackboard(int awayBackboard) {
        this.awayBackboard = awayBackboard;
    }

    public int getAwayAssists() {
        return awayAssists;
    }

    public void setAwayAssists(int awayAssists) {
        this.awayAssists = awayAssists;
    }

    public int getAwayError() {
        return awayError;
    }

    public void setAwayError(int awayError) {
        this.awayError = awayError;
    }

    public int getAwaySteals() {
        return awaySteals;
    }

    public void setAwaySteals(int awaySteals) {
        this.awaySteals = awaySteals;
    }

    public int getAwayBlockShot() {
        return awayBlockShot;
    }

    public void setAwayBlockShot(int awayBlockShot) {
        this.awayBlockShot = awayBlockShot;
    }

    public int getAwayFoul() {
        return awayFoul;
    }

    public void setAwayFoul(int awayFoul) {
        this.awayFoul = awayFoul;
    }

    public int getAwayUseErrorScore() {
        return awayUseErrorScore;
    }

    public void setAwayUseErrorScore(int awayUseErrorScore) {
        this.awayUseErrorScore = awayUseErrorScore;
    }

    public int getAwayPaintScore() {
        return awayPaintScore;
    }

    public void setAwayPaintScore(int awayPaintScore) {
        this.awayPaintScore = awayPaintScore;
    }

    public float getAwayPaintHitPercentage() {
        return awayPaintHitPercentage;
    }

    public void setAwayPaintHitPercentage(float awayPaintHitPercentage) {
        this.awayPaintHitPercentage = awayPaintHitPercentage;
    }

    public int getAwaySecondAttackScore() {
        return awaySecondAttackScore;
    }

    public void setAwaySecondAttackScore(int awaySecondAttackScore) {
        this.awaySecondAttackScore = awaySecondAttackScore;
    }

    public int getAwayFastBreakScore() {
        return awayFastBreakScore;
    }

    public void setAwayFastBreakScore(int awayFastBreakScore) {
        this.awayFastBreakScore = awayFastBreakScore;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public MatchSchedule() {

    }

    public MatchSchedule(int id, UnionClassification union, int seasonNumber, SeasonClassificationEnum seasonClassification, Date matchDate, Time matchTime, int matchRound, TeamInfo homeTeam, int homeSection1Score, int homeSection2Score, int homeSection3Score, int homeSection4Score, int homeTeamScore, int homeShoot, int homeHit, float homeShootingPercentage, int homeThreePointShoot, int homeThreePointHit, float homeThreePointPercentage, int homeFreeThrowShoot, int homeFreeThrowHit, float homeFreeThrowPercentage, int homeFrontCourtRebounds, int homeDefensiveRebounds, int homeBackboard, int homeAssists, int homeError, int homeSteals, int homeBlockShot, int homeFoul, int homeUseErrorScore, int homePaintScore, float homePaintHitPercentage, int homeSecondAttackScore, int homeFastBreakScore, TeamInfo awayTeam, int awaySection1Score, int awaySection2Score, int awaySection3Score, int awaySection4Score, int awayTeamScore, int awayShoot, int awayHit, float awayShootingPercentage, int awayThreePointShoot, int awayThreePointHit, float awayThreePointPercentage, int awayFreeThrowShoot, int awayFreeThrowHit, float awayFreeThrowPercentage, int awayFrontCourtRebounds, int awayDefensiveRebounds, int awayBackboard, int awayAssists, int awayError, int awaySteals, int awayBlockShot, int awayFoul, int awayUseErrorScore, int awayPaintScore, float awayPaintHitPercentage, int awaySecondAttackScore, int awayFastBreakScore, String report) {

        this.id = id;
        this.union = union;
        this.seasonNumber = seasonNumber;
        this.seasonClassification = seasonClassification;
        this.matchDate = matchDate;
        this.matchTime = matchTime;
        this.matchRound = matchRound;
        this.homeTeam = homeTeam;
        this.homeSection1Score = homeSection1Score;
        this.homeSection2Score = homeSection2Score;
        this.homeSection3Score = homeSection3Score;
        this.homeSection4Score = homeSection4Score;
        this.homeTeamScore = homeTeamScore;
        this.homeShoot = homeShoot;
        this.homeHit = homeHit;
        this.homeShootingPercentage = homeShootingPercentage;
        this.homeThreePointShoot = homeThreePointShoot;
        this.homeThreePointHit = homeThreePointHit;
        this.homeThreePointPercentage = homeThreePointPercentage;
        this.homeFreeThrowShoot = homeFreeThrowShoot;
        this.homeFreeThrowHit = homeFreeThrowHit;
        this.homeFreeThrowPercentage = homeFreeThrowPercentage;
        this.homeFrontCourtRebounds = homeFrontCourtRebounds;
        this.homeDefensiveRebounds = homeDefensiveRebounds;
        this.homeBackboard = homeBackboard;
        this.homeAssists = homeAssists;
        this.homeError = homeError;
        this.homeSteals = homeSteals;
        this.homeBlockShot = homeBlockShot;
        this.homeFoul = homeFoul;
        this.homeUseErrorScore = homeUseErrorScore;
        this.homePaintScore = homePaintScore;
        this.homePaintHitPercentage = homePaintHitPercentage;
        this.homeSecondAttackScore = homeSecondAttackScore;
        this.homeFastBreakScore = homeFastBreakScore;
        this.awayTeam = awayTeam;
        this.awaySection1Score = awaySection1Score;
        this.awaySection2Score = awaySection2Score;
        this.awaySection3Score = awaySection3Score;
        this.awaySection4Score = awaySection4Score;
        this.awayTeamScore = awayTeamScore;
        this.awayShoot = awayShoot;
        this.awayHit = awayHit;
        this.awayShootingPercentage = awayShootingPercentage;
        this.awayThreePointShoot = awayThreePointShoot;
        this.awayThreePointHit = awayThreePointHit;
        this.awayThreePointPercentage = awayThreePointPercentage;
        this.awayFreeThrowShoot = awayFreeThrowShoot;
        this.awayFreeThrowHit = awayFreeThrowHit;
        this.awayFreeThrowPercentage = awayFreeThrowPercentage;
        this.awayFrontCourtRebounds = awayFrontCourtRebounds;
        this.awayDefensiveRebounds = awayDefensiveRebounds;
        this.awayBackboard = awayBackboard;
        this.awayAssists = awayAssists;
        this.awayError = awayError;
        this.awaySteals = awaySteals;
        this.awayBlockShot = awayBlockShot;
        this.awayFoul = awayFoul;
        this.awayUseErrorScore = awayUseErrorScore;
        this.awayPaintScore = awayPaintScore;
        this.awayPaintHitPercentage = awayPaintHitPercentage;
        this.awaySecondAttackScore = awaySecondAttackScore;
        this.awayFastBreakScore = awayFastBreakScore;
        this.report = report;
    }
}
