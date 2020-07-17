package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.MatchSchedule;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchScheduleMapper {
    public int insertMatchSchedule(MatchSchedule matchSchedule);
    public int deleteMatchScheduleById(int id);
    public int updateMatchScheduleById(MatchSchedule matchSchedule);
    public MatchSchedule selectMatchScheduleById(int id);
    public List<MatchSchedule> matchSchedulePagingSelect(@Param("paging")Paging paging, @Param("matchSchedule")MatchSchedule matchSchedule);
    public List<MatchSchedule> selectTheLastTenMatchScheduleByTeamId(int teamId);
}
