package com.xiazhuoxian.bbs.controller;


import com.alibaba.fastjson.JSONObject;
import com.xiazhuoxian.bbs.pojo.MatchSchedule;
import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.service.MatchScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import java.sql.Time;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/matchSchedule")
public class MatchScheduleController {
    @Autowired
    MatchScheduleService matchScheduleService;

    @RequestMapping("/insertMatchSchedule")
    @ResponseBody
    public int insertMatchSchedule(@RequestBody Map<String,Object> map){
        log.info("添加赛程");
        String matchTimeString=map.get("matchTime").toString();
        java.util.Date matchTimeUtilDate;
        try {
            matchTimeUtilDate=new SimpleDateFormat("HH:mm").parse(matchTimeString);
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail"));
        }
        java.sql.Time time=new java.sql.Time(matchTimeUtilDate.getTime());
        Object matchScheduleObject= map.get("matchSchedule");
        JSONObject matchScheduleJson = (JSONObject) JSONObject.toJSON(matchScheduleObject);
        MatchSchedule matchSchedule = JSONObject.toJavaObject(matchScheduleJson, MatchSchedule.class);
        matchSchedule.setMatchTime(time);
        return matchScheduleService.insertMatchSchedule(matchSchedule);
    }

    @RequestMapping("/deleteMatchScheduleById")
    @ResponseBody
    public int deleteMatchScheduleById(int id){
        return matchScheduleService.deleteMatchScheduleById(id);
    }

    @RequestMapping("/updateMatchScheduleById")
    @ResponseBody
    public int updateMatchScheduleById(@RequestBody Map<String,Object> map){
        log.info("修改赛程");
        String matchTimeString=map.get("matchTime").toString();
        java.util.Date matchTimeUtilDate;
        try {
            matchTimeUtilDate=new SimpleDateFormat("HH:mm:ss").parse(matchTimeString);
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail"));
        }
        java.sql.Time time=new java.sql.Time(matchTimeUtilDate.getTime());
        Object matchScheduleObject= map.get("matchSchedule");
        JSONObject matchScheduleJson = (JSONObject) JSONObject.toJSON(matchScheduleObject);
        MatchSchedule matchSchedule = JSONObject.toJavaObject(matchScheduleJson, MatchSchedule.class);
        matchSchedule.setMatchTime(time);
        return matchScheduleService.updateMatchScheduleById(matchSchedule);
    }

    @RequestMapping("/selectMatchScheduleById")
    @ResponseBody
    public MatchSchedule selectMatchScheduleById(int id){
        return matchScheduleService.selectMatchScheduleById(id);
    }

    @RequestMapping("/matchSchedulePagingSelect")
    @ResponseBody
    public Paging matchSchedulePagingSelect(@RequestBody Map<String,Object> map){
        log.info("查询赛程");
        Object pagingObject= map.get("paging");
        JSONObject pagingJson = (JSONObject) JSONObject.toJSON(pagingObject);
        Paging paging = JSONObject.toJavaObject(pagingJson, Paging.class);

        Object matchScheduleObject= map.get("matchSchedule");
        JSONObject matchScheduleJson = (JSONObject)JSONObject.toJSON(matchScheduleObject);
        MatchSchedule matchSchedule = JSONObject.toJavaObject(matchScheduleJson, MatchSchedule.class);

        return matchScheduleService.matchSchedulePagingSelect(paging,matchSchedule);
    }

    @RequestMapping("/selectTheLastTenMatchScheduleByTeamId")
    @ResponseBody
    public List<MatchSchedule> selectTheLastTenMatchScheduleByTeamId(int teamId){
        return matchScheduleService.selectTheLastTenMatchScheduleByTeamId(teamId);
    }
}
