package com.xiazhuoxian.bbs.mapper;


import com.xiazhuoxian.bbs.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayerMapper {
    public int insertPlayInfo(PlayerInfo playerInfo);
    public int deletePlayInfo(int id);
    public int updatePlayInfo(PlayerInfo playerInfo);
    public PlayerInfo selectPlayInfoById(int id);
    public List<PlayerInfo> playerInfoPagingSelect(@Param("paging")Paging paging, @Param("teamId")int teamId, @Param("union")UnionClassification union);
    public List<PlayerInfo> playerInfoSelect(TeamInfo teamInfo);
    public int insertPlayerSingleMatchData(PlayerSingleMatchData playerSingleMatchData);
    public int deletePlayerSingleMatchData(int id);
    public int updatePlayerSingleMatchData(PlayerSingleMatchData playerSingleMatchData);
    public PlayerSingleMatchData selectPlayerSingleMatchDataById(int id);
    public List<PlayerSingleMatchData> selectPlayerSingleMatchDataByMatchId(int id);
    public int insertPlayerAverageData(PlayerAverageData playerAverageData);
    public int deletePlayerAverageData(int id);
    public int updatePlayerAverageData(PlayerAverageData playerAverageData);
    public PlayerAverageData selectPlayerAverageData(PlayerAverageData playerAverageData);
    public PlayerAverageData selectPlayerAverageDataIfExit(PlayerAverageData playerAverageData);
    public PlayerAverageData selectTheLastPlayerAverageData(PlayerAverageData playerAverageData);
    public List<PlayerSingleMatchData> selectTheLastTenPlayerSingleMatchDataByPlayerId(int PlayerId);
    public List<PlayerAverageData> selectAllPlayerAverageData(PlayerAverageData playerAverageData);
}
