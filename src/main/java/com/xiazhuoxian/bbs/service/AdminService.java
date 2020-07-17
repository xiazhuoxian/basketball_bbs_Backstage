package com.xiazhuoxian.bbs.service;

import com.xiazhuoxian.bbs.pojo.*;

import java.util.List;
import java.util.Map;

public interface AdminService {
    public AdminInfo selectAdminByLoginName(String loginName);
    public int updateAdminInfo(AdminInfo adminInfo);
    public int updateIcon(int adminId,String icon);
    public List<HomePageCarousel> selectHomePageCarousel();
    public HomePageCarousel selectHomePageCarouselById(int id);
    public int updateHomePageCarousel(HomePageCarousel homePageCarousel);
}
