package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.enums.StatusEnum;
import com.xiazhuoxian.bbs.pojo.MainPosts;
import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.service.MainPostsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/mainPosts")
public class MainPostsController {
    @Autowired
    MainPostsService mainPostsService;

    @RequestMapping("/mainPostsPagingSelect")
    @ResponseBody
    public Paging mainPostsPagingSelect(@RequestParam("currentPageNumber") int currentPageNumber,
                                        @RequestParam(value = "selectCondition",required = false) String selectCondition,
                                        @RequestParam(value = "plateClassification",required = false) String plateClassification,
                                        @RequestParam(value = "unionClassification",required = false) String unionClassification,
                                        @RequestParam(value = "communityClassification",required = false) String communityClassification,
                                        @RequestParam(value = "posterIdentity",required = false) String posterIdentity,
                                        @RequestParam(value = "posterId",required = false) Integer posterId){
        System.out.println("分页查询：社区");
        return mainPostsService.mainPostsPagingSelect(currentPageNumber,selectCondition,plateClassification,unionClassification,communityClassification,posterIdentity,posterId);
    }

    @RequestMapping("/insertMainPosts")
    @ResponseBody
    public int insertMainPosts(String posterIdentity,int posterId,String plateName,String unionName,String communityName,String title,String content){
        return mainPostsService.insertMainPosts(posterIdentity,posterId,plateName,unionName,communityName,title,content);
    }

    @RequestMapping("/deleteMainPostsById")
    @ResponseBody
    public int deleteMainPostsById(int mainPostsId){
        return mainPostsService.deleteMainPostsById(mainPostsId);
    }

    @RequestMapping("/updateMainPosts")
    @ResponseBody
    public int updateMainPosts(int mainPostsId,String posterIdentity,int posterId,String plateName,String unionName,String communityName,String title,String content){
        return mainPostsService.updateMainPosts(mainPostsId,posterIdentity,posterId,plateName,unionName,communityName,title,content);
    }

    @RequestMapping("/selectMainPostsById")
    @ResponseBody
    public MainPosts selectMainPostsById(int mainPostsId){
        return mainPostsService.selectMainPostsById(mainPostsId);
    }
}
