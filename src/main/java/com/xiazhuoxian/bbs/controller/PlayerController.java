package com.xiazhuoxian.bbs.controller;

import com.alibaba.fastjson.JSONObject;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.PlayerService;
import com.xiazhuoxian.bbs.util.UnionClassificationUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @Autowired
    UploadController uploadController;

    /*
    @ResponseBody
    @RequestMapping("/insertPlayInfo")
    public int insertPlayInfo(@RequestBody Map<String,Object> map){
        Object playerInfoObject= map.get("playerInfo");
        JSONObject playerInfoJson = (JSONObject) JSONObject.toJSON(playerInfoObject);
        PlayerInfo playerInfo = JSONObject.toJavaObject(playerInfoJson, PlayerInfo.class);
        return playerService.insertPlayInfo(playerInfo);
    }
    */

    @ResponseBody
    @RequestMapping("/insertPlayInfo")
    public int insertPlayInfo(PlayerInfoParam playerInfoParam)throws IOException {
        return playerService.insertPlayInfo(playerInfoParam);
    }

    @ResponseBody
    @RequestMapping("/deletePlayInfo")
    public int deletePlayInfo(int id){
        return playerService.deletePlayInfo(id);
    }

    @ResponseBody
    @RequestMapping("/updatePlayInfo")
    public int updatePlayInfo(PlayerInfoParam playerInfoParam){
        return playerService.updatePlayInfo(playerInfoParam);
    }

    @ResponseBody
    @RequestMapping("/selectPlayInfoById")
    public PlayerInfo selectPlayInfoById(int id){
        return playerService.selectPlayInfoById(id);
    }

    @ResponseBody
    @RequestMapping("/playerInfoPagingSelect")
    public Paging playerInfoPagingSelect(int currentPageNumber, String selectCondition, int teamId, String unionName){
        return playerService.playerInfoPagingSelect(currentPageNumber,selectCondition,teamId,unionName);
    }

    @ResponseBody
    @RequestMapping("/playerInfoSelect")
    public List<PlayerInfo> playerInfoSelect(@RequestParam(value = "teamId",required = false)Integer teamId,
                                             @RequestParam(value = "unionName",required = false)String unionName){
        TeamInfo teamInfo=new TeamInfo();
        if(teamId!=null){
            teamInfo.setTeamId(teamId);
        }
        if(unionName!=null){
            UnionClassification union=new UnionClassification(UnionClassificationUtil.getUnionId(unionName),unionName);
            teamInfo.setUnion(union);
        }
        return playerService.playerInfoSelect(teamInfo);
    }

    @ResponseBody
    @RequestMapping("/insertPlayerSingleMatchData")
    public int insertPlayerSingleMatchData(PlayerSingleMatchDataParam playerSingleMatchDataParam){
        System.out.println(playerSingleMatchDataParam.getPlayerId()+"-"+playerSingleMatchDataParam.getMatchId()+"-"+playerSingleMatchDataParam.getAssists()+"-"+playerSingleMatchDataParam.getBackboard()+"-"+playerSingleMatchDataParam+"-"+playerSingleMatchDataParam.getDefensiveRebounds());
        return playerService.insertPlayerSingleMatchData(playerSingleMatchDataParam);
    }

    @ResponseBody
    @RequestMapping("/deletePlayerSingleMatchData")
    public int deletePlayerSingleMatchData(int id){
        return playerService.deletePlayerSingleMatchData(id);
    }

    @ResponseBody
    @RequestMapping("/updatePlayerSingleMatchData")
    public int updatePlayerSingleMatchData(PlayerSingleMatchDataParam playerSingleMatchDataParam){
        return playerService.updatePlayerSingleMatchData(playerSingleMatchDataParam);
    }

    @ResponseBody
    @RequestMapping("/selectPlayerSingleMatchDataById")
    public PlayerSingleMatchData selectPlayerSingleMatchDataById(int id){
        return playerService.selectPlayerSingleMatchDataById(id);
    }

    @ResponseBody
    @RequestMapping("/selectPlayerSingleMatchDataByMatchId")
    public List<PlayerSingleMatchData> selectPlayerSingleMatchDataByMatchId(int id){
        return playerService.selectPlayerSingleMatchDataByMatchId(id);
    }

    @ResponseBody
    @RequestMapping("/selectTheLastPlayerAverageData")
    public PlayerAverageData selectTheLastPlayerAverageData(int playerId){
        return playerService.selectTheLastPlayerAverageData(playerId);
    }

    @ResponseBody
    @RequestMapping("/selectAllPlayerAverageData")
    public List<PlayerAverageData> selectAllPlayerAverageData(int playerId){
        return playerService.selectAllPlayerAverageData(playerId);
    }

    @ResponseBody
    @RequestMapping("/selectTheLastTenPlayerSingleMatchDataByPlayerId")
    public List<PlayerSingleMatchData> selectTheLastTenPlayerSingleMatchDataByPlayerId(int playerId){
        return playerService.selectTheLastTenPlayerSingleMatchDataByPlayerId(playerId);
    }
}
