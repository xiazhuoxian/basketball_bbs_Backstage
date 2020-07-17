package com.xiazhuoxian.bbs.service;


import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.UserInfo;

import java.util.List;

public interface UserService {
    public int insertUser(String loginName,String loginPassword,String nickname,String address,String phone,String sex,String icon,String secretProtectionQuestion,String secretProtectionAnswer);
    public int deleteUserById(int userId);
    public int updateUserInfo(int userId,String loginPassword,String nickname,String address,String phone,String sex,String icon,String secretProtectionQuestion,String secretProtectionAnswer);
    public int updateIcon(int userId,String icon);
    public UserInfo selectUserById(int userId);
    public UserInfo selectUserByLoginName(String loginName);
    public Paging userPagingSelect(int currentPageNumber,String selectCondition);
}
