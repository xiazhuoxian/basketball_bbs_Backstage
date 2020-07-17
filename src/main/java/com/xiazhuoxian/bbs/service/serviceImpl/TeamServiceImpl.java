package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.enums.SeasonClassificationEnum;
import com.xiazhuoxian.bbs.mapper.TeamMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.TeamService;
import com.xiazhuoxian.bbs.util.PartitionClassificationUtil;
import com.xiazhuoxian.bbs.util.UnionClassificationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    TeamMapper teamMapper;

    @Override
    public int insertTeamInfo(String name,String icon,String unionName,String partitionName,String local,String home,String introduce){
        UnionClassification union=new UnionClassification(UnionClassificationUtil.getUnionId(unionName),unionName);
        PartitionClassification partition=new PartitionClassification(PartitionClassificationUtil.getPartitionId(partitionName),partitionName);
        TeamInfo teamInfo=new TeamInfo(name,icon,union,partition,local,home,introduce);
        return teamMapper.insertTeamInfo(teamInfo);
    }

    @Override
    public int deleteTeamInfoById(int teamId){
        return teamMapper.deleteTeamInfoById(teamId);
    }

    @Override
    public int updateTeamInfo(int teamId,String name,String icon,String unionName,String partitionName,String local,String home,String introduce){
        UnionClassification union=new UnionClassification(UnionClassificationUtil.getUnionId(unionName),unionName);
        PartitionClassification partition=new PartitionClassification(PartitionClassificationUtil.getPartitionId(partitionName),partitionName);
        TeamInfo teamInfo=new TeamInfo(teamId,name,icon,union,partition,local,home,introduce);
        return teamMapper.updateTeamInfo(teamInfo);
    }

    @Override
    public TeamInfo selectTeamInfoById(int teamId){
        return teamMapper.selectTeamInfoById(teamId);
    }

    @Override
    public List<TeamInfo> selectTeamInfoByUnion(String unionName){
        int unionId=UnionClassificationUtil.getUnionId(unionName);
        return teamMapper.selectTeamInfoByUnion(unionId);
    }

    @Override
    public List<TeamInfo> selectTeamList(){
        return teamMapper.selectTeamList();
    }

    @Override
    public TeamInfo selectTeamByTeamName(String name){
        return teamMapper.selectTeamByTeamName(name);
    }

    @Override
    public int insertTeamAverageData(TeamAverageData teamAverageData){
        return teamMapper.insertTeamAverageData(teamAverageData);
    }

    @Override
    public int deleteTeamAverageData(int id){
        return teamMapper.deleteTeamAverageData(id);
    }

    @Override
    public int updataTeamAverageData(TeamAverageData teamAverageData){
        return teamMapper.updataTeamAverageData(teamAverageData);
    }

    @Override
    public TeamAverageData selectTeamAverageDataIfExist(TeamAverageData teamAverageData){
        return teamMapper.selectTeamAverageDataIfExist(teamAverageData);
    }

    @Override
    public TeamAverageData selectTheLastTeamAverageData(int teamId){
        TeamAverageData teamAverageData=new TeamAverageData();
        teamAverageData.setTeam(new TeamInfo(teamId));
        teamAverageData.setSeasonClassification(SeasonClassificationEnum.REGULAR_SEASON);
        return teamMapper.selectTheLastTeamAverageData(teamAverageData);
    }
}
