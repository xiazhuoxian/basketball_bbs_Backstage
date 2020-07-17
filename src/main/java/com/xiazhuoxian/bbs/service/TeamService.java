package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.PlayerSingleMatchData;
import com.xiazhuoxian.bbs.pojo.PlayerSingleMatchDataParam;
import com.xiazhuoxian.bbs.pojo.TeamAverageData;
import com.xiazhuoxian.bbs.pojo.TeamInfo;

import java.util.List;

public interface TeamService {
    public int insertTeamInfo(String name,String icon,String unionName,String partitonName,String local,String home,String introduce);
    public int deleteTeamInfoById(int teamId);
    public int updateTeamInfo(int teamId,String name,String icon,String unionName,String partitionName,String local,String home,String introduce);
    public TeamInfo selectTeamInfoById(int teamId);
    public List<TeamInfo> selectTeamInfoByUnion(String unionName);
    public List<TeamInfo> selectTeamList();
    public TeamInfo selectTeamByTeamName(String name);
    public int insertTeamAverageData(TeamAverageData teamAverageData);
    public int deleteTeamAverageData(int id);
    public int updataTeamAverageData(TeamAverageData teamAverageData);
    public TeamAverageData selectTeamAverageDataIfExist(TeamAverageData teamAverageData);
    public TeamAverageData selectTheLastTeamAverageData(int teamId);
}
