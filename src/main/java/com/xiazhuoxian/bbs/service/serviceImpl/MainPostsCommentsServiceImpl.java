package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.enums.ContentTypeEnum;
import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.MessageTypeEnum;
import com.xiazhuoxian.bbs.mapper.MainPostsCommentsMapper;
import com.xiazhuoxian.bbs.mapper.MainPostsMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.MainPostsCommentsService;
import com.xiazhuoxian.bbs.service.MessageService;
import com.xiazhuoxian.bbs.util.CommunityClassificationUtil;
import com.xiazhuoxian.bbs.util.PlateClassificationUtil;
import com.xiazhuoxian.bbs.util.UnionClassificationUtil;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class MainPostsCommentsServiceImpl implements MainPostsCommentsService {
    @Autowired
    MainPostsCommentsMapper mainPostsCommentsMapper;
    @Autowired
    MainPostsMapper mainPostsMapper;
    @Autowired
    MessageService messageService;

    @Override
    public Paging mainPostsCommentsPagingSelect(int currentPageNumber, String selectCondition, Integer mainPostsId,String plateName, String unionName, String communityName, String posterIdentity, Integer posterId, Integer headCommentId){
        int itemsDisplayedPerPage=10;
        Paging paging=new Paging(currentPageNumber,itemsDisplayedPerPage,selectCondition);
        MainPostsComments mainPostsComments=new MainPostsComments();
        if(mainPostsId!=null){
            mainPostsComments.setMainPosts(new MainPosts(mainPostsId));
        }
        if(headCommentId!=null){
            mainPostsComments.setHeadCommentId(headCommentId);
        }
        if(plateName!=null){
            mainPostsComments.setPlateClassification(new PlateClassification(PlateClassificationUtil.getPlateId(plateName),plateName));
        }
        if(unionName!=null){
            mainPostsComments.setUnionClassification(new UnionClassification(UnionClassificationUtil.getUnionId(unionName),unionName));
        }
        if(communityName!=null){
            mainPostsComments.setCommunityClassification(new CommunityClassification(CommunityClassificationUtil.getCommunityId(communityName),communityName));
        }
        if(posterIdentity!=null&&posterId!=null){
            mainPostsComments.setPosterIdentity(IdentityEnum.valueOf(posterIdentity));
            if(posterIdentity.equals("ADMIN")){
                mainPostsComments.setAdminInfo(new AdminInfo(posterId));
            }else {
                mainPostsComments.setUserInfo(new UserInfo(posterId));
            }
        }

        System.out.println("service:"+paging.getCurrentPageNumber()+":"+paging.getItemsDisplayedPerPage());

        List<MainPostsComments> result=mainPostsCommentsMapper.mainPostsCommentsPagingSelect(paging,mainPostsComments);
        for(MainPostsComments param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setUpdateDate(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }

        paging.setMainPostsCommentsResult(result);
        paging.setTotalItems(paging.getMainPostsCommentsResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }

    @Override
    public int insertMainPostsComments(String posterIdentity,int posterId,String plateName,String unionName,String communityName,String content,Integer mainPostsId,Integer parentCommentId,String parentCommentPosterNickname,Integer headCommentId)throws IOException {
        IdentityEnum identity=IdentityEnum.valueOf(posterIdentity);
        int numberOfComment=0;
        int numberOfLiked=0;
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        int plateId=PlateClassificationUtil.getPlateId(plateName);
        int unionId=UnionClassificationUtil.getUnionId(unionName);
        int communityId=CommunityClassificationUtil.getCommunityId(communityName);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        CommunityClassification communityClassification=new CommunityClassification(communityId);
        MainPosts mainPosts=new MainPosts(mainPostsId);
        MainPostsComments mainPostsComments=new MainPostsComments(identity,plateClassification,unionClassification,communityClassification,mainPosts,parentCommentId,parentCommentPosterNickname,headCommentId,numberOfComment,numberOfLiked,content,updateTime);
        if(posterIdentity.equals("ADMIN")){
            AdminInfo adminInfo=new AdminInfo(posterId);
            mainPostsComments.setAdminInfo(adminInfo);
        }else if(posterIdentity.equals("USER")){
            UserInfo userInfo=new UserInfo(posterId);
            mainPostsComments.setUserInfo(userInfo);
        }
        int result=mainPostsCommentsMapper.insertMainPostsComments(mainPostsComments);
        if(headCommentId==0){
            mainPostsMapper.addTheNumberOfComment(mainPostsId);
        }else {
            mainPostsCommentsMapper.addTheNumberOfComment(headCommentId);
        }

        MainPosts param=mainPostsMapper.selectMainPostsById(mainPostsId);
        MessageParam message=new MessageParam();
        message.setSenderIdentity(identity);
        message.setSenderId(posterId);
        //if(identity.equals("ADMIN")){
        //    message.setAdminSender(new AdminInfo(posterId));
        //}else {
        //    message.setUserSender(new UserInfo(posterId));
        //}
        message.setReceiverIdentity(param.getPosterIdentity());
        if(param.getPosterIdentity().toString().equals("ADMIN")){
           message.setReceiverId(param.getAdminInfo().getAdminId());
        }else {
            message.setReceiverId(param.getUserInfo().getUserId());
        }
        message.setMessageType(MessageTypeEnum.REPLY);
        if(headCommentId==0){
            message.setContentType(ContentTypeEnum.HTML);
        }else {
            message.setContentType(ContentTypeEnum.TEXT);
        }
        message.setComments(mainPostsComments);
        //message.setUpdateTime(updateTime);
        //message.setReadingState(false);
        //message.setSenderRecord(true);
        //message.setReceiverRecord(true);



        messageService.insertMessage(message);

        return result;
    }

    @Override
    public int deleteMainPostsCommentsById(int mainPostsCommentsId){
        return mainPostsCommentsMapper.deleteMainPostsCommentsById(mainPostsCommentsId);
    }

    @Override
    public int updateMainPostsComments(int mainPostsCommentsId,String content){
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        MainPostsComments mainPostsComments=new MainPostsComments(mainPostsCommentsId,content,updateTime);
        return mainPostsCommentsMapper.updateMainPostsComments(mainPostsComments);
    }

    @Override
    public MainPostsComments selectMainPostsCommentsById(int mainPostsCommentsId){
        return mainPostsCommentsMapper.selectMainPostsCommentsById(mainPostsCommentsId);
    }

    @Override
    public int addTheNumberOfComment(int mainPostsCommentsId){
        return mainPostsCommentsMapper.addTheNumberOfComment(mainPostsCommentsId);
    }
}
