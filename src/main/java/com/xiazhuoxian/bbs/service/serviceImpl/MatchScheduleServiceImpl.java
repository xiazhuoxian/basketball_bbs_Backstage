package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.enums.SeasonClassificationEnum;
import com.xiazhuoxian.bbs.mapper.MainPostsMapper;
import com.xiazhuoxian.bbs.mapper.MatchScheduleMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.ClassificationService;
import com.xiazhuoxian.bbs.service.MatchScheduleService;
import com.xiazhuoxian.bbs.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class MatchScheduleServiceImpl implements MatchScheduleService {
    @Autowired
    MatchScheduleMapper matchScheduleMapper;
    @Autowired
    TeamService teamService;
    @Autowired
    ClassificationService classificationService;

    @Override
    public int insertMatchSchedule(MatchSchedule matchSchedule){
        System.out.println("A:"+matchSchedule.getSeasonClassification());
        UnionClassification union=classificationService.selectUnionByUnionName(matchSchedule.getUnion().getUnionName());
        TeamInfo homeTeam=teamService.selectTeamByTeamName(matchSchedule.getHomeTeam().getName());
        TeamInfo awayTeam=teamService.selectTeamByTeamName(matchSchedule.getAwayTeam().getName());
        matchSchedule.setUnion(union);
        matchSchedule.setHomeTeam(homeTeam);
        matchSchedule.setAwayTeam(awayTeam);
        int result = matchScheduleMapper.insertMatchSchedule(matchSchedule);
        if (result!=0){
            insertMatchScheduleAndUpdateTeamAverageData(matchSchedule);
        }
        return result;
    }

    @Override
    public int deleteMatchScheduleById(int id){
        MatchSchedule matchSchedule=matchScheduleMapper.selectMatchScheduleById(id);
        int result=matchScheduleMapper.deleteMatchScheduleById(id);
        if(result!=0){
            deleteMatchScheduleAndUpdateTeamAverageData(matchSchedule);
        }
        return result;
    }

    @Override
    public int updateMatchScheduleById(MatchSchedule after){
        //after 修改后的数据。before 修改前的数据
        MatchSchedule before=matchScheduleMapper.selectMatchScheduleById(after.getId());
        int result=matchScheduleMapper.updateMatchScheduleById(after);
        if(result!=0){
            updateMatchScheduleAndUpdateTeamAverageData(before,after);
        }
        return result;
    }

    @Override
    public MatchSchedule selectMatchScheduleById(int id){
        return matchScheduleMapper.selectMatchScheduleById(id);
    }

    @Override
    public Paging matchSchedulePagingSelect(Paging paging, MatchSchedule matchSchedule){
        int itemsDisplayedPerPage=20;
        paging.setItemsDisplayedPerPage(itemsDisplayedPerPage);

        paging.setMatchSchedulesResult(matchScheduleMapper.matchSchedulePagingSelect(paging,matchSchedule));
        paging.setTotalItems(paging.getMatchSchedulesResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;

    }

    @Override
    public List<MatchSchedule> selectTheLastTenMatchScheduleByTeamId(int teamId){
        List<MatchSchedule> selectResult=matchScheduleMapper.selectTheLastTenMatchScheduleByTeamId(teamId);
        List<MatchSchedule> returnResult=new ArrayList<MatchSchedule>();
        for(int i=selectResult.size();i>=1;i--){
            returnResult.add(selectResult.get(i-1));
        }
        return returnResult;
    }

    public int insertMatchScheduleAndUpdateTeamAverageData(MatchSchedule matchSchedule){
        //homeTeam
        int homeTeamId=matchSchedule.getHomeTeam().getTeamId();
        int homeSeasonNumber=matchSchedule.getSeasonNumber();
        SeasonClassificationEnum homeSeasonClassification=matchSchedule.getSeasonClassification();
        TeamInfo homeTeamInfo=new TeamInfo(homeTeamId);
        TeamAverageData homeTeamAverageData = new TeamAverageData(homeTeamInfo,homeSeasonNumber,homeSeasonClassification);
        TeamAverageData homeResult=teamService.selectTeamAverageDataIfExist(homeTeamAverageData);
        if(homeResult==null){
            //homeTeamAverageData.setNumberOfMatch(1);
            if(matchSchedule.getHomeTeamScore()>matchSchedule.getAwayTeamScore()){
                homeTeamAverageData.setNumberHomeWin(1);
            }else {
                homeTeamAverageData.setNumberHomeFail(1);
            }
            homeTeamAverageData.setScore(matchSchedule.getHomeTeamScore());
            homeTeamAverageData.setLosePoints(matchSchedule.getAwayTeamScore());
            homeTeamAverageData.setBackboard(matchSchedule.getHomeBackboard());
            homeTeamAverageData.setAssists(matchSchedule.getHomeAssists());
            homeTeamAverageData.setError(matchSchedule.getHomeError());
            homeTeamAverageData.setSteals(matchSchedule.getHomeSteals());
            homeTeamAverageData.setBlockShot(matchSchedule.getHomeBlockShot());
            homeTeamAverageData.setFoul(matchSchedule.getHomeFoul());
            homeTeamAverageData.setShoot(matchSchedule.getHomeShoot());
            homeTeamAverageData.setHit(matchSchedule.getHomeHit());
            homeTeamAverageData.setShootingPercentage(matchSchedule.getHomeShootingPercentage());
            homeTeamAverageData.setThreePointShot(matchSchedule.getHomeThreePointShoot());
            homeTeamAverageData.setThreePointHit(matchSchedule.getHomeThreePointHit());
            homeTeamAverageData.setThreePointPercentage(matchSchedule.getHomeThreePointPercentage());
            homeTeamAverageData.setFreeThrowShot(matchSchedule.getHomeFreeThrowShoot());
            homeTeamAverageData.setFreeThrowHit(matchSchedule.getHomeFreeThrowHit());
            homeTeamAverageData.setFreeThrowPercentage(matchSchedule.getHomeFreeThrowPercentage());
            homeTeamAverageData.setPaintScore(matchSchedule.getHomePaintScore());
            homeTeamAverageData.setFastBreakScore(matchSchedule.getHomeFastBreakScore());
            homeTeamAverageData.setSecondAttackScore(matchSchedule.getHomeSecondAttackScore());
            homeTeamAverageData.setUseErrorScore(matchSchedule.getHomeUseErrorScore());
            homeTeamAverageData.setSubstituteScore(0);
            homeTeamAverageData.setRounds(1);
            teamService.insertTeamAverageData(homeTeamAverageData);
        }else {
            homeTeamAverageData=homeResult;
            int rounds=homeTeamAverageData.getRounds();
            //homeTeamAverageData.setNumberOfMatch(homeTeamAverageData.getNumberOfMatch()+1);
            if(matchSchedule.getHomeTeamScore()>matchSchedule.getAwayTeamScore()){
                homeTeamAverageData.setNumberHomeWin(homeTeamAverageData.getNumberHomeWin()+1);
            }else {
                homeTeamAverageData.setNumberHomeFail(homeTeamAverageData.getNumberHomeFail()+1);
            }
            homeTeamAverageData.setScore(insertCalculation(matchSchedule.getHomeTeamScore(),homeTeamAverageData.getScore(),rounds));
            homeTeamAverageData.setLosePoints(insertCalculation(matchSchedule.getAwayTeamScore(),homeTeamAverageData.getLosePoints(),rounds));
            homeTeamAverageData.setBackboard(insertCalculation(matchSchedule.getHomeBackboard(),homeTeamAverageData.getBackboard(),rounds));
            homeTeamAverageData.setAssists(insertCalculation(matchSchedule.getHomeAssists(),homeTeamAverageData.getAssists(),rounds));
            homeTeamAverageData.setError(insertCalculation(matchSchedule.getHomeError(),homeTeamAverageData.getError(),rounds));
            homeTeamAverageData.setSteals(insertCalculation(matchSchedule.getHomeSteals(),homeTeamAverageData.getSteals(),rounds));
            homeTeamAverageData.setBlockShot(insertCalculation(matchSchedule.getHomeBlockShot(),homeTeamAverageData.getBlockShot(),rounds));
            homeTeamAverageData.setFoul(insertCalculation(matchSchedule.getHomeFoul(),homeTeamAverageData.getFoul(),rounds));
            homeTeamAverageData.setShoot(insertCalculation(matchSchedule.getHomeShoot(),homeTeamAverageData.getShoot(),rounds));
            homeTeamAverageData.setHit(insertCalculation(matchSchedule.getHomeHit(),homeTeamAverageData.getHit(),rounds));
            homeTeamAverageData.setShootingPercentage(homeTeamAverageData.getHit()/homeTeamAverageData.getShoot());
            homeTeamAverageData.setThreePointShot(insertCalculation(matchSchedule.getHomeThreePointShoot(),homeTeamAverageData.getThreePointShot(),rounds));
            homeTeamAverageData.setThreePointHit(insertCalculation(matchSchedule.getHomeThreePointHit(),homeTeamAverageData.getThreePointHit(),rounds));
            homeTeamAverageData.setThreePointPercentage(homeTeamAverageData.getThreePointHit()/homeTeamAverageData.getThreePointShot());
            homeTeamAverageData.setFreeThrowShot(insertCalculation(matchSchedule.getHomeFreeThrowShoot(),homeTeamAverageData.getFreeThrowShot(),rounds));
            homeTeamAverageData.setFreeThrowHit(insertCalculation(matchSchedule.getHomeFreeThrowHit(),homeTeamAverageData.getFreeThrowHit(),rounds));
            homeTeamAverageData.setFreeThrowPercentage(homeTeamAverageData.getFreeThrowHit()/homeTeamAverageData.getFreeThrowShot());
            homeTeamAverageData.setPaintScore(insertCalculation(matchSchedule.getHomePaintScore(),homeTeamAverageData.getPaintScore(),rounds));
            homeTeamAverageData.setFastBreakScore(insertCalculation(matchSchedule.getHomeFastBreakScore(),homeTeamAverageData.getFastBreakScore(),rounds));
            homeTeamAverageData.setSecondAttackScore(insertCalculation(matchSchedule.getHomeSecondAttackScore(),homeTeamAverageData.getSecondAttackScore(),rounds));
            homeTeamAverageData.setUseErrorScore(insertCalculation(matchSchedule.getHomeUseErrorScore(),homeTeamAverageData.getUseErrorScore(),rounds));
            homeTeamAverageData.setSubstituteScore(0);
            homeTeamAverageData.setRounds(homeTeamAverageData.getRounds()+1);
            teamService.updataTeamAverageData(homeTeamAverageData);
        }
        //awayTeam
        int awayTeamId=matchSchedule.getAwayTeam().getTeamId();
        int awaySeasonNumber=matchSchedule.getSeasonNumber();
        SeasonClassificationEnum awaySeasonClassification=matchSchedule.getSeasonClassification();
        TeamInfo awayTeamInfo=new TeamInfo(awayTeamId);
        TeamAverageData awayTeamAverageData = new TeamAverageData(awayTeamInfo,awaySeasonNumber,awaySeasonClassification);
        TeamAverageData awayResult=teamService.selectTeamAverageDataIfExist(awayTeamAverageData);
        if(awayResult==null){
            //awayTeamAverageData.setNumberOfMatch(1);
            if(matchSchedule.getHomeTeamScore()>matchSchedule.getAwayTeamScore()){
                awayTeamAverageData.setNumberAwayFail(1);
            }else {
                awayTeamAverageData.setNumberAwayWin(1);
            }
            awayTeamAverageData.setScore(matchSchedule.getAwayTeamScore());
            awayTeamAverageData.setLosePoints(matchSchedule.getHomeTeamScore());
            awayTeamAverageData.setBackboard(matchSchedule.getAwayBackboard());
            awayTeamAverageData.setAssists(matchSchedule.getAwayAssists());
            awayTeamAverageData.setError(matchSchedule.getAwayError());
            awayTeamAverageData.setSteals(matchSchedule.getAwaySteals());
            awayTeamAverageData.setBlockShot(matchSchedule.getAwayBlockShot());
            awayTeamAverageData.setFoul(matchSchedule.getAwayFoul());
            awayTeamAverageData.setShoot(matchSchedule.getAwayShoot());
            awayTeamAverageData.setHit(matchSchedule.getAwayHit());
            awayTeamAverageData.setShootingPercentage(matchSchedule.getAwayShootingPercentage());
            awayTeamAverageData.setThreePointShot(matchSchedule.getAwayThreePointShoot());
            awayTeamAverageData.setThreePointHit(matchSchedule.getAwayThreePointHit());
            awayTeamAverageData.setThreePointPercentage(matchSchedule.getAwayThreePointPercentage());
            awayTeamAverageData.setFreeThrowShot(matchSchedule.getAwayFreeThrowShoot());
            awayTeamAverageData.setFreeThrowHit(matchSchedule.getAwayFreeThrowHit());
            awayTeamAverageData.setFreeThrowPercentage(matchSchedule.getAwayFreeThrowPercentage());
            awayTeamAverageData.setPaintScore(matchSchedule.getAwayPaintScore());
            awayTeamAverageData.setFastBreakScore(matchSchedule.getAwayFastBreakScore());
            awayTeamAverageData.setSecondAttackScore(matchSchedule.getAwaySecondAttackScore());
            awayTeamAverageData.setUseErrorScore(matchSchedule.getAwayUseErrorScore());
            awayTeamAverageData.setSubstituteScore(0);
            awayTeamAverageData.setRounds(1);
            teamService.insertTeamAverageData(awayTeamAverageData);
        }else {
            awayTeamAverageData=awayResult;
            int rounds=awayTeamAverageData.getRounds();
            //awayTeamAverageData.setNumberOfMatch(awayTeamAverageData.getNumberOfMatch()+1);
            if(matchSchedule.getAwayTeamScore()>matchSchedule.getAwayTeamScore()){
                awayTeamAverageData.setNumberAwayFail(awayTeamAverageData.getNumberAwayFail()+1);
            }else {
                awayTeamAverageData.setNumberAwayWin(awayTeamAverageData.getNumberAwayWin()+1);
            }
            awayTeamAverageData.setScore(insertCalculation(matchSchedule.getAwayTeamScore(),awayTeamAverageData.getScore(),rounds));
            awayTeamAverageData.setLosePoints(insertCalculation(matchSchedule.getHomeTeamScore(),awayTeamAverageData.getLosePoints(),rounds));
            awayTeamAverageData.setBackboard(insertCalculation(matchSchedule.getAwayBackboard(),awayTeamAverageData.getBackboard(),rounds));
            awayTeamAverageData.setAssists(insertCalculation(matchSchedule.getAwayAssists(),awayTeamAverageData.getAssists(),rounds));
            awayTeamAverageData.setError(insertCalculation(matchSchedule.getAwayError(),awayTeamAverageData.getError(),rounds));
            awayTeamAverageData.setSteals(insertCalculation(matchSchedule.getAwaySteals(),awayTeamAverageData.getSteals(),rounds));
            awayTeamAverageData.setBlockShot(insertCalculation(matchSchedule.getAwayBlockShot(),awayTeamAverageData.getBlockShot(),rounds));
            awayTeamAverageData.setFoul(insertCalculation(matchSchedule.getAwayFoul(),awayTeamAverageData.getFoul(),rounds));
            awayTeamAverageData.setShoot(insertCalculation(matchSchedule.getAwayShoot(),awayTeamAverageData.getShoot(),rounds));
            awayTeamAverageData.setHit(insertCalculation(matchSchedule.getAwayHit(),awayTeamAverageData.getHit(),rounds));
            awayTeamAverageData.setShootingPercentage(awayTeamAverageData.getHit()/awayTeamAverageData.getShoot());
            awayTeamAverageData.setThreePointShot(insertCalculation(matchSchedule.getAwayThreePointShoot(),awayTeamAverageData.getThreePointShot(),rounds));
            awayTeamAverageData.setThreePointHit(insertCalculation(matchSchedule.getAwayThreePointHit(),awayTeamAverageData.getThreePointHit(),rounds));
            awayTeamAverageData.setThreePointPercentage(awayTeamAverageData.getThreePointHit()/awayTeamAverageData.getThreePointShot());
            awayTeamAverageData.setFreeThrowShot(insertCalculation(matchSchedule.getAwayFreeThrowShoot(),awayTeamAverageData.getFreeThrowShot(),rounds));
            awayTeamAverageData.setFreeThrowHit(insertCalculation(matchSchedule.getAwayFreeThrowHit(),awayTeamAverageData.getFreeThrowHit(),rounds));
            awayTeamAverageData.setFreeThrowPercentage(awayTeamAverageData.getFreeThrowHit()/awayTeamAverageData.getFreeThrowShot());
            awayTeamAverageData.setPaintScore(insertCalculation(matchSchedule.getAwayPaintScore(),awayTeamAverageData.getPaintScore(),rounds));
            awayTeamAverageData.setFastBreakScore(insertCalculation(matchSchedule.getAwayFastBreakScore(),awayTeamAverageData.getFastBreakScore(),rounds));
            awayTeamAverageData.setSecondAttackScore(insertCalculation(matchSchedule.getAwaySecondAttackScore(),awayTeamAverageData.getSecondAttackScore(),rounds));
            awayTeamAverageData.setUseErrorScore(insertCalculation(matchSchedule.getAwayUseErrorScore(),awayTeamAverageData.getUseErrorScore(),rounds));
            awayTeamAverageData.setSubstituteScore(0);
            awayTeamAverageData.setRounds(awayTeamAverageData.getRounds()+1);
            teamService.updataTeamAverageData(awayTeamAverageData);
        }
        return 1;
    }

    public int deleteMatchScheduleAndUpdateTeamAverageData(MatchSchedule matchSchedule){
        //homeTeam
        int homeTeamId=matchSchedule.getHomeTeam().getTeamId();
        int homeSeasonNumber=matchSchedule.getSeasonNumber();
        SeasonClassificationEnum homeSeasonClassification=matchSchedule.getSeasonClassification();
        TeamInfo homeTeamInfo=new TeamInfo(homeTeamId);
        TeamAverageData homeTeamAverageData = new TeamAverageData(homeTeamInfo,homeSeasonNumber,homeSeasonClassification);
        TeamAverageData homeResult=teamService.selectTeamAverageDataIfExist(homeTeamAverageData);
        if(homeResult!=null){
            if(homeResult.getRounds()==1){
                teamService.deleteTeamAverageData(homeResult.getId());
            }else {
                homeTeamAverageData=homeResult;
                int homeTeamRounds=homeTeamAverageData.getRounds();
                //homeTeamAverageData.setNumberOfMatch(homeTeamAverageData.getNumberOfMatch()+1);
                if(matchSchedule.getHomeTeamScore()>matchSchedule.getAwayTeamScore()){
                    homeTeamAverageData.setNumberHomeWin(homeTeamAverageData.getNumberHomeWin()-1);
                }else {
                    homeTeamAverageData.setNumberHomeFail(homeTeamAverageData.getNumberHomeFail()-1);
                }
                homeTeamAverageData.setScore(deleteCalculation(matchSchedule.getHomeTeamScore(),homeTeamAverageData.getScore(),homeTeamRounds));
                homeTeamAverageData.setLosePoints(deleteCalculation(matchSchedule.getAwayTeamScore(),homeTeamAverageData.getLosePoints(),homeTeamRounds));
                homeTeamAverageData.setBackboard(deleteCalculation(matchSchedule.getHomeBackboard(),homeTeamAverageData.getBackboard(),homeTeamRounds));
                homeTeamAverageData.setAssists(deleteCalculation(matchSchedule.getHomeAssists(),homeTeamAverageData.getAssists(),homeTeamRounds));
                homeTeamAverageData.setError(deleteCalculation(matchSchedule.getHomeError(),homeTeamAverageData.getError(),homeTeamRounds));
                homeTeamAverageData.setSteals(deleteCalculation(matchSchedule.getHomeSteals(),homeTeamAverageData.getSteals(),homeTeamRounds));
                homeTeamAverageData.setBlockShot(deleteCalculation(matchSchedule.getHomeBlockShot(),homeTeamAverageData.getBlockShot(),homeTeamRounds));
                homeTeamAverageData.setFoul(deleteCalculation(matchSchedule.getHomeFoul(),homeTeamAverageData.getFoul(),homeTeamRounds));
                homeTeamAverageData.setShoot(deleteCalculation(matchSchedule.getHomeShoot(),homeTeamAverageData.getShoot(),homeTeamRounds));
                homeTeamAverageData.setHit(deleteCalculation(matchSchedule.getHomeHit(),homeTeamAverageData.getHit(),homeTeamRounds));
                homeTeamAverageData.setShootingPercentage(homeTeamAverageData.getHit()/homeTeamAverageData.getShoot());
                homeTeamAverageData.setThreePointShot(deleteCalculation(matchSchedule.getHomeThreePointShoot(),homeTeamAverageData.getThreePointShot(),homeTeamRounds));
                homeTeamAverageData.setThreePointHit(deleteCalculation(matchSchedule.getHomeThreePointHit(),homeTeamAverageData.getThreePointHit(),homeTeamRounds));
                homeTeamAverageData.setThreePointPercentage(homeTeamAverageData.getThreePointHit()/homeTeamAverageData.getThreePointShot());
                homeTeamAverageData.setFreeThrowShot(deleteCalculation(matchSchedule.getHomeFreeThrowShoot(),homeTeamAverageData.getFreeThrowShot(),homeTeamRounds));
                homeTeamAverageData.setFreeThrowHit(deleteCalculation(matchSchedule.getHomeFreeThrowHit(),homeTeamAverageData.getFreeThrowHit(),homeTeamRounds));
                homeTeamAverageData.setFreeThrowPercentage(homeTeamAverageData.getFreeThrowHit()/homeTeamAverageData.getFreeThrowShot());
                homeTeamAverageData.setPaintScore(deleteCalculation(matchSchedule.getHomePaintScore(),homeTeamAverageData.getPaintScore(),homeTeamRounds));
                homeTeamAverageData.setFastBreakScore(deleteCalculation(matchSchedule.getHomeFastBreakScore(),homeTeamAverageData.getFastBreakScore(),homeTeamRounds));
                homeTeamAverageData.setSecondAttackScore(deleteCalculation(matchSchedule.getHomeSecondAttackScore(),homeTeamAverageData.getSecondAttackScore(),homeTeamRounds));
                homeTeamAverageData.setUseErrorScore(deleteCalculation(matchSchedule.getHomeUseErrorScore(),homeTeamAverageData.getUseErrorScore(),homeTeamRounds));
                homeTeamAverageData.setSubstituteScore(0);
                homeTeamAverageData.setRounds(homeTeamAverageData.getRounds()-1);
                teamService.updataTeamAverageData(homeTeamAverageData);
            }
        }


        //awayTeam
        int awayTeamId=matchSchedule.getAwayTeam().getTeamId();
        int awaySeasonNumber=matchSchedule.getSeasonNumber();
        SeasonClassificationEnum awaySeasonClassification=matchSchedule.getSeasonClassification();
        TeamInfo awayTeamInfo=new TeamInfo(awayTeamId);
        TeamAverageData awayTeamAverageData = new TeamAverageData(awayTeamInfo,awaySeasonNumber,awaySeasonClassification);
        TeamAverageData awayResult=teamService.selectTeamAverageDataIfExist(awayTeamAverageData);
        if(awayResult!=null){
            if(awayResult.getRounds()==1){
                teamService.deleteTeamAverageData(awayResult.getId());
            }else {
                awayTeamAverageData=awayResult;
                int awayTeamRounds=awayTeamAverageData.getRounds();
                //awayTeamAverageData.setNumberOfMatch(awayTeamAverageData.getNumberOfMatch()+1);
                if(matchSchedule.getAwayTeamScore()>matchSchedule.getAwayTeamScore()){
                    awayTeamAverageData.setNumberAwayFail(awayTeamAverageData.getNumberAwayFail()-1);
                }else {
                    awayTeamAverageData.setNumberAwayWin(awayTeamAverageData.getNumberAwayWin()-1);
                }
                awayTeamAverageData.setScore(deleteCalculation(matchSchedule.getAwayTeamScore(),awayTeamAverageData.getScore(),awayTeamRounds));
                awayTeamAverageData.setLosePoints(deleteCalculation(matchSchedule.getHomeTeamScore(),awayTeamAverageData.getLosePoints(),awayTeamRounds));
                awayTeamAverageData.setBackboard(deleteCalculation(matchSchedule.getAwayBackboard(),awayTeamAverageData.getBackboard(),awayTeamRounds));
                awayTeamAverageData.setAssists(deleteCalculation(matchSchedule.getAwayAssists(),awayTeamAverageData.getAssists(),awayTeamRounds));
                awayTeamAverageData.setError(deleteCalculation(matchSchedule.getAwayError(),awayTeamAverageData.getError(),awayTeamRounds));
                awayTeamAverageData.setSteals(deleteCalculation(matchSchedule.getAwaySteals(),awayTeamAverageData.getSteals(),awayTeamRounds));
                awayTeamAverageData.setBlockShot(deleteCalculation(matchSchedule.getAwayBlockShot(),awayTeamAverageData.getBlockShot(),awayTeamRounds));
                awayTeamAverageData.setFoul(deleteCalculation(matchSchedule.getAwayFoul(),awayTeamAverageData.getFoul(),awayTeamRounds));
                awayTeamAverageData.setShoot(deleteCalculation(matchSchedule.getAwayShoot(),awayTeamAverageData.getShoot(),awayTeamRounds));
                awayTeamAverageData.setHit(deleteCalculation(matchSchedule.getAwayHit(),awayTeamAverageData.getHit(),awayTeamRounds));
                awayTeamAverageData.setShootingPercentage(awayTeamAverageData.getHit()/awayTeamAverageData.getShoot());
                awayTeamAverageData.setThreePointShot(deleteCalculation(matchSchedule.getAwayThreePointShoot(),awayTeamAverageData.getThreePointShot(),awayTeamRounds));
                awayTeamAverageData.setThreePointHit(deleteCalculation(matchSchedule.getAwayThreePointHit(),awayTeamAverageData.getThreePointHit(),awayTeamRounds));
                awayTeamAverageData.setThreePointPercentage(awayTeamAverageData.getThreePointHit()/awayTeamAverageData.getThreePointShot());
                awayTeamAverageData.setFreeThrowShot(deleteCalculation(matchSchedule.getAwayFreeThrowShoot(),awayTeamAverageData.getFreeThrowShot(),awayTeamRounds));
                awayTeamAverageData.setFreeThrowHit(deleteCalculation(matchSchedule.getAwayFreeThrowHit(),awayTeamAverageData.getFreeThrowHit(),awayTeamRounds));
                awayTeamAverageData.setFreeThrowPercentage(awayTeamAverageData.getFreeThrowHit()/awayTeamAverageData.getFreeThrowShot());
                awayTeamAverageData.setPaintScore(deleteCalculation(matchSchedule.getAwayPaintScore(),awayTeamAverageData.getPaintScore(),awayTeamRounds));
                awayTeamAverageData.setFastBreakScore(deleteCalculation(matchSchedule.getAwayFastBreakScore(),awayTeamAverageData.getFastBreakScore(),awayTeamRounds));
                awayTeamAverageData.setSecondAttackScore(deleteCalculation(matchSchedule.getAwaySecondAttackScore(),awayTeamAverageData.getSecondAttackScore(),awayTeamRounds));
                awayTeamAverageData.setUseErrorScore(deleteCalculation(matchSchedule.getAwayUseErrorScore(),awayTeamAverageData.getUseErrorScore(),awayTeamRounds));
                awayTeamAverageData.setSubstituteScore(0);
                awayTeamAverageData.setRounds(awayTeamAverageData.getRounds()-1);
                teamService.updataTeamAverageData(awayTeamAverageData);
            }
        }
        return 1;
    }

    public int updateMatchScheduleAndUpdateTeamAverageData(MatchSchedule before,MatchSchedule after){
        //after 修改后的数据。before 修改前的数据
        deleteMatchScheduleAndUpdateTeamAverageData(before);
        insertMatchScheduleAndUpdateTeamAverageData(after);
        return 1;
    }

    //mData：matchSchedule中的数据
    //aData：teamAverageData中的数据
    //round：当前已录入的比赛轮数
    public float insertCalculation(float mData,float aData,int round){
        float result=(aData*round+mData)/(round+1);
        return result;
    }

    public float deleteCalculation(float mData,float aData,int round){
        float result=(aData*round-mData)/(round-1);
        return result;
    }
}
