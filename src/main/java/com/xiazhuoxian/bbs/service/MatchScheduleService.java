package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.MatchSchedule;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchScheduleService {
    public int insertMatchSchedule(MatchSchedule matchSchedule);
    public int deleteMatchScheduleById(int id);
    public int updateMatchScheduleById(MatchSchedule matchSchedule);
    public MatchSchedule selectMatchScheduleById(int id);
    public Paging matchSchedulePagingSelect(Paging paging,MatchSchedule matchSchedule);
    public List<MatchSchedule> selectTheLastTenMatchScheduleByTeamId(int teamId);
}
