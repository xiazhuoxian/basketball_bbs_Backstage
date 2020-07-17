package com.xiazhuoxian.bbs.controller;

import com.xiazhuoxian.bbs.pojo.MainPostsComments;
import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.service.MainPostsCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/mainPostsComments")
public class MainPostsCommentsController {
    @Autowired
    MainPostsCommentsService mainPostsCommentsService;

    @RequestMapping("/mainPostsCommentsPagingSelect")
    @ResponseBody
    public Paging mainPostsCommentsPagingSelect(@RequestParam("currentPageNumber") int currentPageNumber,
                                        @RequestParam(value = "selectCondition",required = false) String selectCondition,
                                        @RequestParam(value = "mainPostsId",required = false) Integer mainPostsId,
                                        @RequestParam(value = "plateClassification",required = false) String plateClassification,
                                        @RequestParam(value = "unionClassification",required = false) String unionClassification,
                                        @RequestParam(value = "communityClassification",required = false) String communityClassification,
                                        @RequestParam(value = "posterIdentity",required = false) String posterIdentity,
                                        @RequestParam(value = "posterId",required = false) Integer posterId,
                                        @RequestParam(value = "headCommentId",required = false) Integer headCommentId){
        System.out.println("分页查询：跟帖");
        System.out.println(currentPageNumber+","+selectCondition+","+mainPostsId+","+plateClassification+","+unionClassification+","+communityClassification+","+posterIdentity+","+posterId+","+headCommentId);

        Paging paging=mainPostsCommentsService.mainPostsCommentsPagingSelect(currentPageNumber,selectCondition,mainPostsId,plateClassification,unionClassification,communityClassification,posterIdentity,posterId,headCommentId);
        System.out.println(paging.getMainPostsCommentsResult().size());
        for(MainPostsComments mainPostsComments:paging.getMainPostsCommentsResult()){
            System.out.println(mainPostsComments.getMainPostsCommentsId());
        }


        return mainPostsCommentsService.mainPostsCommentsPagingSelect(currentPageNumber,selectCondition,mainPostsId,plateClassification,unionClassification,communityClassification,posterIdentity,posterId,headCommentId);
    }

    @RequestMapping("/insertMainPostsComments")
    @ResponseBody
    public int insertMainPostsComments(String posterIdentity,int posterId,String plateName,String unionName,String communityName,String content,Integer mainPostsId,Integer parentCommentId,String parentCommentPosterNickname,Integer headCommentId)throws IOException {
        System.out.println("添加跟帖");
        return mainPostsCommentsService.insertMainPostsComments(posterIdentity,posterId,plateName,unionName,communityName,content,mainPostsId,parentCommentId,parentCommentPosterNickname,headCommentId);
    }

    @RequestMapping("/deleteMainPostsCommentsById")
    @ResponseBody
    public int deleteMainPostsCommentsById(int mainPostsCommentsId){
        return mainPostsCommentsService.deleteMainPostsCommentsById(mainPostsCommentsId);
    }

    @RequestMapping("/updateMainPostsComments")
    @ResponseBody
    public int updateMainPostsComments(int mainPostsCommentsId,String content){
        return mainPostsCommentsService.updateMainPostsComments(mainPostsCommentsId,content);
    }

    @RequestMapping("/selectMainPostsCommentsById")
    @ResponseBody
    public MainPostsComments selectMainPostsCommentsById(int mainPostsCommentsId){
        return mainPostsCommentsService.selectMainPostsCommentsById(mainPostsCommentsId);
    }
}
