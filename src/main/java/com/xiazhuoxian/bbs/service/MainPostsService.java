package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.MainPosts;
import com.xiazhuoxian.bbs.pojo.Paging;

public interface MainPostsService {
    public Paging mainPostsPagingSelect(int currentPageNumber, String selectCondition,String plateName,String unionName,String communityName,String posterIdentity,Integer posterId);
    public int insertMainPosts(String posterIdentity,int posterId,String plateName,String unionName,String communityName,String title,String content);
    public int deleteMainPostsById(int mainPostsId);
    public int updateMainPosts(int mainPostsId,String posterIdentity,int posterId,String plateName,String unionName,String communityName,String title,String content);
    public MainPosts selectMainPostsById(int mainPostsId);
    public int addTheNumberOfComment(int mainPostsId);
    public int addTheNumberOfRead(int mainPostsId);
    public int addTheNumberOfCollected(int mainPostsId);
    public int addTheNumberOfRecommended(int mainPostsId);
}
