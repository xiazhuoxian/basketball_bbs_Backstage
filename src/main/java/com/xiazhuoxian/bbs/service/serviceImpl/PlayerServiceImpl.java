package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.controller.UploadController;
import com.xiazhuoxian.bbs.enums.SeasonClassificationEnum;
import com.xiazhuoxian.bbs.mapper.MatchScheduleMapper;
import com.xiazhuoxian.bbs.mapper.PlayerMapper;
import com.xiazhuoxian.bbs.mapper.TeamMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.PlayerService;
import com.xiazhuoxian.bbs.util.UnionClassificationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.IIOException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PlayerServiceImpl implements PlayerService {
    @Autowired
    PlayerMapper playerMapper;
    @Autowired
    UploadController uploadController;
    @Autowired
    TeamMapper teamMapper;
    @Autowired
    MatchScheduleMapper matchScheduleMapper;

    @Override
    public int insertPlayInfo(PlayerInfoParam playerInfoParam){
        try{
            String iconAddress=uploadController.uploadIcon(playerInfoParam.getIconFile());
            playerInfoParam.setIcon(iconAddress);
        }catch (IOException e){
            log.info(e.toString());
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date birthUtil=simpleDateFormat.parse(playerInfoParam.getBirthString());
            java.sql.Date birth=new java.sql.Date(birthUtil.getTime());
            playerInfoParam.setBirth(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TeamInfo teamInfo=teamMapper.selectTeamByTeamName(playerInfoParam.getTeamName());
        playerInfoParam.setTeamInfo(teamInfo);
        return playerMapper.insertPlayInfo(playerInfoParam);
    }

    @Override
    public int deletePlayInfo(int id){
        return playerMapper.deletePlayInfo(id);
    }

    @Override
    public int updatePlayInfo(PlayerInfoParam playerInfoParam){
        if(playerInfoParam.getIconFile()!=null){
            try{
                String iconAddress=uploadController.uploadIcon(playerInfoParam.getIconFile());
                playerInfoParam.setIcon(iconAddress);
            }catch (IOException e){
                log.info(e.toString());
            }
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date birthUtil=simpleDateFormat.parse(playerInfoParam.getBirthString());
            java.sql.Date birth=new java.sql.Date(birthUtil.getTime());
            playerInfoParam.setBirth(birth);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TeamInfo teamInfo=teamMapper.selectTeamByTeamName(playerInfoParam.getTeamName());
        playerInfoParam.setTeamInfo(teamInfo);
        return playerMapper.updatePlayInfo(playerInfoParam);
    }

    @Override
    public PlayerInfo selectPlayInfoById(int id){
        return playerMapper.selectPlayInfoById(id);
    }

    @Override
    public Paging playerInfoPagingSelect(int currentPageNumber, String selectCondition, int teamId, String unionName){
        int itemsDisplayedPerPage=10;
        Paging paging=new Paging(currentPageNumber,itemsDisplayedPerPage,selectCondition);
        UnionClassification union=new UnionClassification(UnionClassificationUtil.getUnionId(unionName),unionName);
        paging.setPlayerInfosResult(playerMapper.playerInfoPagingSelect(paging,teamId,union));
        paging.setTotalItems(paging.getPlayerInfosResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }

    @Override
    public List<PlayerInfo> playerInfoSelect(TeamInfo teamInfo){
        return playerMapper.playerInfoSelect(teamInfo);
    }

    @Override
    public int insertPlayerSingleMatchData(PlayerSingleMatchDataParam playerSingleMatchDataParam){
        PlayerInfo playerInfo=new PlayerInfo(playerSingleMatchDataParam.getPlayerId());
        playerInfo.setTeamInfo(new TeamInfo(playerSingleMatchDataParam.getTeamId()));
        playerSingleMatchDataParam.setPlayerInfo(playerInfo);
        playerSingleMatchDataParam.setMatchSchedule(matchScheduleMapper.selectMatchScheduleById(playerSingleMatchDataParam.getMatchId()));
        int result=playerMapper.insertPlayerSingleMatchData(playerSingleMatchDataParam);
        if(result!=0){
            insertPlayerSingleMatchDataAndUpdatePlayerAverageData(playerSingleMatchDataParam);
        }
        return result;
    }

    @Override
    public int deletePlayerSingleMatchData(int id){
        PlayerSingleMatchData playerSingleMatchData=playerMapper.selectPlayerSingleMatchDataById(id);
        int result=playerMapper.deletePlayerSingleMatchData(id);
        if(result!=0){
            deletePlayerSingleMatchDataAndUpdatePlayerAverageData(playerSingleMatchData);
        }
        return result;
    }

    @Override
    public int updatePlayerSingleMatchData(PlayerSingleMatchDataParam after){
        PlayerSingleMatchData befor=playerMapper.selectPlayerSingleMatchDataById(after.getId());
        after.setPlayerInfo(new PlayerInfo(after.getPlayerId()));
        after.setMatchSchedule(matchScheduleMapper.selectMatchScheduleById(after.getMatchId()));
        int result=playerMapper.updatePlayerSingleMatchData(after);
        if(result!=0){
            updatePlayerSingleMatchDataAndUpdatePlayerAverageData(befor,after);
        }
        return result;
    }

    @Override
    public PlayerSingleMatchData selectPlayerSingleMatchDataById(int id){
        return playerMapper.selectPlayerSingleMatchDataById(id);
    }

    @Override
    public List<PlayerSingleMatchData> selectPlayerSingleMatchDataByMatchId(int id){
        return playerMapper.selectPlayerSingleMatchDataByMatchId(id);
    }

    @Override
    public int insertPlayerAverageData(PlayerAverageData playerAverageData){
        return playerMapper.insertPlayerAverageData(playerAverageData);
    }

    @Override
    public int deletePlayerAverageData(int id){
        return playerMapper.deletePlayerAverageData(id);
    }

    @Override
    public int updatePlayerAverageData(PlayerAverageData playerAverageData){
        return playerMapper.updatePlayerAverageData(playerAverageData);
    }

    @Override
    public PlayerAverageData selectPlayerAverageData(PlayerAverageData playerAverageData){
        return playerMapper.selectPlayerAverageData(playerAverageData);
    }

    @Override
    public PlayerAverageData selectPlayerAverageDataIfExit(PlayerAverageData playerAverageData){
        return playerMapper.selectPlayerAverageDataIfExit(playerAverageData);
    }

    @Override
    public PlayerAverageData selectTheLastPlayerAverageData(int PlayerId){
        PlayerAverageData playerAverageData=new PlayerAverageData();
        playerAverageData.setPlayerInfo(new PlayerInfo(PlayerId));
        playerAverageData.setSeasonClassification(SeasonClassificationEnum.REGULAR_SEASON);
        return playerMapper.selectTheLastPlayerAverageData(playerAverageData);
    }

    @Override
    public List<PlayerAverageData> selectAllPlayerAverageData(int PlayerId){
        PlayerAverageData playerAverageData=new PlayerAverageData();
        playerAverageData.setPlayerInfo(new PlayerInfo(PlayerId));
        playerAverageData.setSeasonClassification(SeasonClassificationEnum.REGULAR_SEASON);
        return playerMapper.selectAllPlayerAverageData(playerAverageData);
    }

    @Override
    public List<PlayerSingleMatchData> selectTheLastTenPlayerSingleMatchDataByPlayerId(int PlayerId){
        List<PlayerSingleMatchData> selectResult=playerMapper.selectTheLastTenPlayerSingleMatchDataByPlayerId(PlayerId);
        List<PlayerSingleMatchData> returnResult=new ArrayList<PlayerSingleMatchData>();
        for(int i=selectResult.size();i>=1;i--){
            returnResult.add(selectResult.get(i-1));
        }
        return returnResult;
    }

    public int insertPlayerSingleMatchDataAndUpdatePlayerAverageData(PlayerSingleMatchData playerSingleMatchData){
        PlayerAverageData param=new PlayerAverageData();
        param.setPlayerInfo(new PlayerInfo(playerSingleMatchData.getPlayerInfo().getId()));
        param.setSeasonNumber(playerSingleMatchData.getMatchSchedule().getSeasonNumber());
        param.setSeasonClassification(playerSingleMatchData.getMatchSchedule().getSeasonClassification());
        PlayerAverageData result=selectPlayerAverageDataIfExit(param);
        if(result==null){
            param.setTeamInfo(playerSingleMatchData.getPlayerInfo().getTeamInfo());
            param.setPlayingTime(playerSingleMatchData.getPalyingTime());
            param.setScore(playerSingleMatchData.getScore());
            param.setFrontCourtRebounds(playerSingleMatchData.getFrontCourtRebounds());
            param.setDefensiveRebounds(playerSingleMatchData.getDefensiveRebounds());
            param.setBackboard(playerSingleMatchData.getBackboard());
            param.setAssists(playerSingleMatchData.getAssists());
            param.setError(playerSingleMatchData.getError());
            param.setSteals(playerSingleMatchData.getSteals());
            param.setBlockShot(playerSingleMatchData.getBlockShot());
            param.setShoot(playerSingleMatchData.getShot());
            param.setHit(playerSingleMatchData.getHit());
            param.setShootingPercentage(playerSingleMatchData.getShootingPercentage());
            param.setThreePointShoot(playerSingleMatchData.getThreePointShot());
            param.setThreePointHit(playerSingleMatchData.getThreePointHit());
            param.setThreePointPercentage(playerSingleMatchData.getThreePointPercentage());
            param.setFreeThrowShoot(playerSingleMatchData.getFreeThrowShot());
            param.setFreeThrowHit(playerSingleMatchData.getFreeThrowHit());
            param.setFreeThrowPercentage(playerSingleMatchData.getFreeThrowPercentage());
            param.setFastBreakScore(playerSingleMatchData.getFastBreakScore());
            param.setSeasonHighestScore(playerSingleMatchData.getScore());
            param.setFoul(playerSingleMatchData.getFoul());
            param.setNumberOfMatches(1);
            insertPlayerAverageData(param);
        }else{
            int number=result.getNumberOfMatches();
            param.setId(result.getId());
            param.setTeamInfo(result.getTeamInfo());
            param.setPlayingTime(insertCalculation(playerSingleMatchData.getPalyingTime(),result.getPlayingTime(),number));
            param.setScore(insertCalculation(playerSingleMatchData.getScore(),result.getScore(),number));
            param.setFrontCourtRebounds(insertCalculation(playerSingleMatchData.getFrontCourtRebounds(),result.getFrontCourtRebounds(),number));
            param.setDefensiveRebounds(insertCalculation(playerSingleMatchData.getDefensiveRebounds(),result.getDefensiveRebounds(),number));
            param.setBackboard(insertCalculation(playerSingleMatchData.getBackboard(),result.getBackboard(),number));
            param.setAssists(insertCalculation(playerSingleMatchData.getAssists(),result.getAssists(),number));
            param.setError(insertCalculation(playerSingleMatchData.getError(),result.getError(),number));
            param.setSteals(insertCalculation(playerSingleMatchData.getSteals(),result.getSteals(),number));
            param.setBlockShot(insertCalculation(playerSingleMatchData.getBlockShot(),result.getBlockShot(),number));
            param.setShoot(insertCalculation(playerSingleMatchData.getShot(),result.getShoot(),number));
            param.setHit(insertCalculation(playerSingleMatchData.getHit(),result.getHit(),number));
            param.setShootingPercentage(param.getHit()/param.getShoot());
            param.setThreePointShoot(insertCalculation(playerSingleMatchData.getThreePointShot(),result.getThreePointShoot(),number));
            param.setThreePointHit(insertCalculation(playerSingleMatchData.getThreePointHit(),result.getThreePointHit(),number));
            param.setThreePointPercentage(param.getThreePointHit()/param.getThreePointShoot());
            param.setFreeThrowShoot(insertCalculation(playerSingleMatchData.getFreeThrowShot(),result.getFreeThrowShoot(),number));
            param.setFreeThrowHit(insertCalculation(playerSingleMatchData.getFreeThrowHit(),result.getFreeThrowHit(),number));
            param.setFreeThrowPercentage(param.getFreeThrowHit()/param.getFreeThrowShoot());
            param.setFastBreakScore(insertCalculation(playerSingleMatchData.getFastBreakScore(),result.getFastBreakScore(),number));
            if(playerSingleMatchData.getScore()>result.getSeasonHighestScore()){
                param.setSeasonHighestScore(playerSingleMatchData.getScore());
            }else {
                param.setSeasonHighestScore(result.getSeasonHighestScore());
            }
            param.setFoul(insertCalculation(playerSingleMatchData.getFoul(),result.getFoul(),number));
            param.setNumberOfMatches(result.getNumberOfMatches()+1);
            updatePlayerAverageData(param);
        }
        return 1;
    }

    public int deletePlayerSingleMatchDataAndUpdatePlayerAverageData(PlayerSingleMatchData playerSingleMatchData){
        PlayerAverageData param=new PlayerAverageData();
        param.setPlayerInfo(new PlayerInfo(playerSingleMatchData.getPlayerInfo().getId()));
        param.setSeasonNumber(playerSingleMatchData.getMatchSchedule().getSeasonNumber());
        param.setSeasonClassification(playerSingleMatchData.getMatchSchedule().getSeasonClassification());
        PlayerAverageData result=selectPlayerAverageDataIfExit(param);
        if(result!=null){
            if(result.getNumberOfMatches()==1){
                deletePlayerAverageData(result.getId());
            }else {
                int number=result.getNumberOfMatches();
                param.setId(result.getId());
                param.setTeamInfo(result.getTeamInfo());
                param.setPlayingTime(deleteCalculation(playerSingleMatchData.getPalyingTime(),result.getPlayingTime(),number));
                param.setScore(deleteCalculation(playerSingleMatchData.getScore(),result.getScore(),number));
                param.setFrontCourtRebounds(deleteCalculation(playerSingleMatchData.getFrontCourtRebounds(),result.getFrontCourtRebounds(),number));
                param.setDefensiveRebounds(deleteCalculation(playerSingleMatchData.getDefensiveRebounds(),result.getDefensiveRebounds(),number));
                param.setBackboard(deleteCalculation(playerSingleMatchData.getBackboard(),result.getBackboard(),number));
                param.setAssists(deleteCalculation(playerSingleMatchData.getAssists(),result.getAssists(),number));
                param.setError(deleteCalculation(playerSingleMatchData.getError(),result.getError(),number));
                param.setSteals(deleteCalculation(playerSingleMatchData.getSteals(),result.getSteals(),number));
                param.setBlockShot(deleteCalculation(playerSingleMatchData.getBlockShot(),result.getBlockShot(),number));
                param.setShoot(deleteCalculation(playerSingleMatchData.getShot(),result.getShoot(),number));
                param.setHit(deleteCalculation(playerSingleMatchData.getHit(),result.getHit(),number));
                param.setShootingPercentage(param.getHit()/param.getShoot());
                param.setThreePointShoot(deleteCalculation(playerSingleMatchData.getThreePointShot(),result.getThreePointShoot(),number));
                param.setThreePointHit(deleteCalculation(playerSingleMatchData.getThreePointHit(),result.getThreePointHit(),number));
                param.setThreePointPercentage(param.getThreePointHit()/param.getThreePointShoot());
                param.setFreeThrowShoot(deleteCalculation(playerSingleMatchData.getFreeThrowShot(),result.getFreeThrowShoot(),number));
                param.setFreeThrowHit(deleteCalculation(playerSingleMatchData.getFreeThrowHit(),result.getFreeThrowHit(),number));
                param.setFreeThrowPercentage(param.getFreeThrowHit()/param.getFreeThrowShoot());
                param.setFastBreakScore(deleteCalculation(playerSingleMatchData.getFastBreakScore(),result.getFastBreakScore(),number));
                if(playerSingleMatchData.getScore()<result.getSeasonHighestScore()){
                    param.setSeasonHighestScore(result.getSeasonHighestScore());
                }else {
                    param.setSeasonHighestScore(0);
                }
                param.setFoul(deleteCalculation(playerSingleMatchData.getFoul(),result.getFoul(),number));
                param.setNumberOfMatches(result.getNumberOfMatches()-1);
                updatePlayerAverageData(param);
            }
        }
        return 1;
    }

    public int updatePlayerSingleMatchDataAndUpdatePlayerAverageData(PlayerSingleMatchData before,PlayerSingleMatchData after){
        //after 修改后的数据。before 修改前的数据
        deletePlayerSingleMatchDataAndUpdatePlayerAverageData(before);
        insertPlayerSingleMatchDataAndUpdatePlayerAverageData(after);
        return 1;
    }

    //single：playerSingleMatchData中的数据
    //average：PlayerAverageData中的数据
    //number：球员当前已比赛场数
    public float insertCalculation(float single,float average,int number){
        float result=(average*number+single)/(number+1);
        return result;
    }

    public float deleteCalculation(float single,float average,int number){
        float result=(average*number-single)/(number-1);
        return result;
    }
}
