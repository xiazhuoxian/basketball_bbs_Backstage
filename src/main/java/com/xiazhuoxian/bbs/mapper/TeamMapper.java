package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.TeamAverageData;
import com.xiazhuoxian.bbs.pojo.TeamInfo;

import java.util.List;

public interface TeamMapper {
    public int insertTeamInfo(TeamInfo teamInfo);
    public int deleteTeamInfoById(int teamId);
    public int updateTeamInfo(TeamInfo teamInfo);
    public TeamInfo selectTeamInfoById(int teamId);
    public List<TeamInfo> selectTeamInfoByUnion(int unionId);
    public List<TeamInfo> selectTeamList();
    public TeamInfo selectTeamByTeamName(String name);
    public int insertTeamAverageData(TeamAverageData teamAverageData);
    public int deleteTeamAverageData(int id);
    public int updataTeamAverageData(TeamAverageData teamAverageData);
    public TeamAverageData selectTeamAverageDataIfExist(TeamAverageData teamAverageData);
    public TeamAverageData selectTheLastTeamAverageData(TeamAverageData teamAverageData);
}
