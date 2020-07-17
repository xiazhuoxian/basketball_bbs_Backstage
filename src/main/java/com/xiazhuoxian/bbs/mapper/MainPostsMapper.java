package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.MainPosts;
import com.xiazhuoxian.bbs.pojo.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainPostsMapper {
    public List<MainPosts> mainPostsPagingSelect(@Param("paging")Paging paging,@Param("mainPosts")MainPosts mainPosts);
    public int insertMainPosts(MainPosts mainPosts);
    public int deleteMainPostsById(int mainPostsId);
    public int updateMainPosts(MainPosts mainPosts);
    public MainPosts selectMainPostsById(int mainPostsId);
    public int addTheNumberOfComment(int mainPostsId);
    public int addTheNumberOfRead(int mainPostsId);
    public int addTheNumberOfCollected(int mainPostsId);
    public int addTheNumberOfRecommended(int mainPostsId);
}
