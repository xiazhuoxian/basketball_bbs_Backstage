package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.mapper.AdminMapper;
import com.xiazhuoxian.bbs.pojo.*;
import com.xiazhuoxian.bbs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public AdminInfo selectAdminByLoginName(String loginName){
        return adminMapper.selectAdminByLoginName(loginName);
    };

    @Override
    public int updateAdminInfo(AdminInfo adminInfo){
        return adminMapper.updateAdminInfo(adminInfo);
    };

    @Override
    public int updateIcon(int adminId,String icon){
        AdminInfo adminInfo=new AdminInfo(adminId,icon);
        return adminMapper.updateIcon(adminInfo);
    };

    @Override
    public List<HomePageCarousel> selectHomePageCarousel(){
        return adminMapper.selectHomePageCarousel();
    }

    @Override
    public HomePageCarousel selectHomePageCarouselById(int id){
        return adminMapper.selectHomePageCarouselById(id);
    }

    @Override
    public int updateHomePageCarousel(HomePageCarousel homePageCarousel){
        return adminMapper.updateHomePageCarousel(homePageCarousel);
    }
}
