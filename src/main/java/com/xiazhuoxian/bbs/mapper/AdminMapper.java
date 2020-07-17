package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.*;

import java.util.List;

public interface AdminMapper {
    public AdminInfo selectAdminByLoginName(String loginName);
    public int updateAdminInfo(AdminInfo adminInfo);
    public int updateIcon(AdminInfo adminInfo);
    public List<HomePageCarousel> selectHomePageCarousel();
    public HomePageCarousel selectHomePageCarouselById(int id);
    public int updateHomePageCarousel(HomePageCarousel homePageCarousel);
}
