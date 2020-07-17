package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.TeamAverageData;
import com.xiazhuoxian.bbs.pojo.TeamInfo;
import com.xiazhuoxian.bbs.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamService teamService;
    @Autowired
    UploadController uploadController;

    @RequestMapping("/insertTeamInfo")
    @ResponseBody
    public int insertTeamInfo(String name, @RequestParam("icon")MultipartFile icon, String unionName, String partitionName, String local, String home, String introduce)throws IOException {
        log.info("添加球队");
        String iconAddress=uploadController.uploadIcon(icon);
        return teamService.insertTeamInfo(name,iconAddress,unionName,partitionName,local,home,introduce);
    }

    @RequestMapping("/deleteTeamInfoById")
    @ResponseBody
    public int deleteTeamInfoById(int teamId){
        return teamService.deleteTeamInfoById(teamId);
    }

    @RequestMapping("/updateTeamInfo")
    @ResponseBody
    public int updateTeamInfo(int teamId,String name,@RequestParam(value="icon", required=false)MultipartFile icon,String unionName,String partitionName,String local,String home,String introduce)throws IOException{
        log.info("更新球队信息");
        String iconAddress=null;
        if(icon!=null){
            iconAddress=uploadController.uploadIcon(icon);
        }
        return teamService.updateTeamInfo(teamId,name,iconAddress,unionName,partitionName,local,home,introduce);
    }

    @RequestMapping("/selectTeamInfoById")
    @ResponseBody
    public TeamInfo selectTeamInfoById(int teamId){
        return teamService.selectTeamInfoById(teamId);
    }

    @RequestMapping("/selectTeamInfoByUnion")
    @ResponseBody
    public List<TeamInfo> selectTeamInfoByUnion(String unionName){
        log.info("查询球队信息："+unionName);
        return teamService.selectTeamInfoByUnion(unionName);
    }

    @RequestMapping("/selectTeamList")
    @ResponseBody
    public List<TeamInfo> selectTeamList(){
        return teamService.selectTeamList();
    }

    @RequestMapping("/selectTheLastTeamAverageData")
    @ResponseBody
    public TeamAverageData selectTheLastTeamAverageData(int teamId){
        return teamService.selectTheLastTeamAverageData(teamId);
    }
}
