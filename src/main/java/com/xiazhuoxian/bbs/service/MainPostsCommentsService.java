package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.MainPostsComments;
import com.xiazhuoxian.bbs.pojo.Paging;

import java.io.IOException;

public interface MainPostsCommentsService {
    public Paging mainPostsCommentsPagingSelect(int currentPageNumber, String selectCondition,Integer mainPostsId,String plateName, String unionName, String communityName, String posterIdentity, Integer posterId,Integer headCommentId);
    public int insertMainPostsComments(String posterIdentity,int posterId,String plateName,String unionName,String communityName,String content,Integer mainPostsId,Integer parentCommentId,String parentCommentPosterNickname,Integer headCommentId)throws IOException;
    public int deleteMainPostsCommentsById(int mainPostsCommentsId);
    public int updateMainPostsComments(int mainPostsCommentsId,String content);
    public MainPostsComments selectMainPostsCommentsById(int mainPostsCommentsId);
    public int addTheNumberOfComment(int mainPostsCommentsId);
}
