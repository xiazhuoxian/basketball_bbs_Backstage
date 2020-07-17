package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.MainPostsComments;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainPostsCommentsMapper {
    public List<MainPostsComments> mainPostsCommentsPagingSelect(@Param("paging")Paging paging, @Param("mainPostsComments")MainPostsComments mainPostsComments);
    public int insertMainPostsComments(MainPostsComments mainPostsComments);
    public int deleteMainPostsCommentsById(int mainPostsCommentsId);
    public int updateMainPostsComments(MainPostsComments mainPostsComments);
    public MainPostsComments selectMainPostsCommentsById(int mainPostsCommentsId);
    public int addTheNumberOfComment(int mainPostsCommentsId);
}
