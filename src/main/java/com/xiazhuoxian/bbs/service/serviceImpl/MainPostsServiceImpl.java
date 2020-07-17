package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.enums.IdentityEnum;
import com.xiazhuoxian.bbs.enums.StatusEnum;
import com.xiazhuoxian.bbs.mapper.MainPostsMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.MainPostsService;
import com.xiazhuoxian.bbs.util.CommunityClassificationUtil;
import com.xiazhuoxian.bbs.util.PlateClassificationUtil;
import com.xiazhuoxian.bbs.util.UnionClassificationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MainPostsServiceImpl implements MainPostsService {
    @Autowired
    MainPostsMapper mainPostsMapper;

    @Override
    public Paging mainPostsPagingSelect(int currentPageNumber, String selectCondition,String plateName,String unionName,String communityName,String posterIdentity,Integer posterId){
        int itemsDisplayedPerPage=20;
        Paging paging=new Paging(currentPageNumber,itemsDisplayedPerPage,selectCondition);
        MainPosts mainPosts=new MainPosts();
        if(plateName!=null){
            mainPosts.setPlateClassification(new PlateClassification(PlateClassificationUtil.getPlateId(plateName),plateName));
        }
        if(unionName!=null){
            mainPosts.setUnionClassification(new UnionClassification(UnionClassificationUtil.getUnionId(unionName),unionName));
        }
        if(communityName!=null){
            mainPosts.setCommunityClassification(new CommunityClassification(CommunityClassificationUtil.getCommunityId(communityName),communityName));
        }
        if(posterIdentity!=null&&posterId!=null){
            mainPosts.setPosterIdentity(IdentityEnum.valueOf(posterIdentity));
            if(posterIdentity.equals("ADMIN")){
                mainPosts.setAdminInfo(new AdminInfo(posterId));
            }else {
                mainPosts.setUserInfo(new UserInfo(posterId));
            }
        }
        List<MainPosts> result=mainPostsMapper.mainPostsPagingSelect(paging,mainPosts);
        for(MainPosts param : result){
            Timestamp timestamp=param.getUpdateTime();
            param.setUpdateDate(new java.sql.Date(timestamp.getTime()));
            param.setTime(new java.sql.Time(timestamp.getTime()));
        }
        paging.setMainPostsResult(result);
        paging.setTotalItems(paging.getMainPostsResult().size());
        paging.setTotalPages(paging.getTotalItems()%itemsDisplayedPerPage==0?
                paging.getTotalItems()/itemsDisplayedPerPage:
                paging.getTotalItems()/itemsDisplayedPerPage+1);
        return paging;
    }

    @Override
    public int insertMainPosts(String posterIdentity,int posterId,String plateName,String unionName,String communityName,String title,String content){
        StatusEnum status=StatusEnum.NORMAL;
        IdentityEnum identity=IdentityEnum.valueOf(posterIdentity);
        int numberOfCollected=0;
        int numberOfRecommended=0;
        int numberOfRead=0;
        int numberOfCommented=0;
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp createTime=Timestamp.valueOf(nowTime);
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        int plateId=PlateClassificationUtil.getPlateId(plateName);
        int unionId=UnionClassificationUtil.getUnionId(unionName);
        int communityId=CommunityClassificationUtil.getCommunityId(communityName);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        CommunityClassification communityClassification=new CommunityClassification(communityId);
        MainPosts mainPosts=new MainPosts(plateClassification,unionClassification,communityClassification,status,title,content,identity,numberOfCollected,numberOfRecommended,numberOfRead,numberOfRecommended,createTime,updateTime);
        if(posterIdentity.equals("ADMIN")){
            AdminInfo adminInfo=new AdminInfo(posterId);
            mainPosts.setAdminInfo(adminInfo);
        }else if(posterIdentity.equals("USER")){
            UserInfo userInfo=new UserInfo(posterId);
            mainPosts.setUserInfo(userInfo);
        }
        return mainPostsMapper.insertMainPosts(mainPosts);
    }

    @Override
    public int deleteMainPostsById(int mainPostsId){
        return mainPostsMapper.deleteMainPostsById(mainPostsId);
    }

    @Override
    public int updateMainPosts(int mainPostsId,String posterIdentity,int posterId,String plateName,String unionName,String communityName,String title,String content){
        int plateId=PlateClassificationUtil.getPlateId(plateName);
        int unionId=UnionClassificationUtil.getUnionId(unionName);
        int communityId=CommunityClassificationUtil.getCommunityId(communityName);
        PlateClassification plateClassification=new PlateClassification(plateId);
        UnionClassification unionClassification=new UnionClassification(unionId);
        CommunityClassification communityClassification=new CommunityClassification(communityId);
        String nowTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        Timestamp updateTime=Timestamp.valueOf(nowTime);
        MainPosts mainPosts=new MainPosts(mainPostsId,plateClassification,unionClassification,communityClassification,title,content,updateTime);
        return mainPostsMapper.updateMainPosts(mainPosts);
    }

    @Override
    public MainPosts selectMainPostsById(int mainPostsId){
        MainPosts result=mainPostsMapper.selectMainPostsById(mainPostsId);
        Timestamp timestamp=result.getUpdateTime();
        result.setUpdateDate(new java.sql.Date(timestamp.getTime()));
        result.setTime(new java.sql.Time(timestamp.getTime()));
        addTheNumberOfRead(mainPostsId);
        return result;
    }

    @Override
    public int addTheNumberOfComment(int mainPostsId){
        return mainPostsMapper.addTheNumberOfComment(mainPostsId);
    }

    @Override
    public int addTheNumberOfRead(int mainPostsId){
        return mainPostsMapper.addTheNumberOfRead(mainPostsId);
    }

    @Override
    public int addTheNumberOfCollected(int mainPostsId){
        return mainPostsMapper.addTheNumberOfCollected(mainPostsId);
    }

    @Override
    public int addTheNumberOfRecommended(int mainPostsId){
        return mainPostsMapper.addTheNumberOfRecommended(mainPostsId);
    }
}
