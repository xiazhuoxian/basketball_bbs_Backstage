package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.*;

import java.util.List;

public interface PlayerService {
    public int insertPlayInfo(PlayerInfoParam playerInfoParam);
    public int deletePlayInfo(int id);
    public int updatePlayInfo(PlayerInfoParam playerInfoParam);
    public PlayerInfo selectPlayInfoById(int id);
    public Paging playerInfoPagingSelect(int currentPageNumber, String selectCondition, int teamId, String unionName);
    public List<PlayerInfo> playerInfoSelect(TeamInfo teamInfo);
    public int insertPlayerSingleMatchData(PlayerSingleMatchDataParam playerSingleMatchDataParam);
    public int deletePlayerSingleMatchData(int id);
    public int updatePlayerSingleMatchData(PlayerSingleMatchDataParam playerSingleMatchDataParam);
    public PlayerSingleMatchData selectPlayerSingleMatchDataById(int id);
    public List<PlayerSingleMatchData> selectPlayerSingleMatchDataByMatchId(int id);
    public int insertPlayerAverageData(PlayerAverageData playerAverageData);
    public int deletePlayerAverageData(int id);
    public int updatePlayerAverageData(PlayerAverageData playerAverageData);
    public PlayerAverageData selectPlayerAverageData(PlayerAverageData playerAverageData);
    public PlayerAverageData selectPlayerAverageDataIfExit(PlayerAverageData playerAverageData);
    public PlayerAverageData selectTheLastPlayerAverageData(int PlayerId);
    public List<PlayerSingleMatchData> selectTheLastTenPlayerSingleMatchDataByPlayerId(int PlayerId);
    public List<PlayerAverageData> selectAllPlayerAverageData(int PlayerId);
}
