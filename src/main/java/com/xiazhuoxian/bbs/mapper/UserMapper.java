package com.xiazhuoxian.bbs.mapper;


import com.xiazhuoxian.bbs.pojo.Paging;
import com.xiazhuoxian.bbs.pojo.UserInfo;

import java.util.List;

public interface UserMapper {
    public int insertUser(UserInfo userInfo);
    public int deleteUserById(int userId);
    public int updateUserInfo(UserInfo userInfo);
    public int updateIcon(UserInfo userInfo);
    public UserInfo selectUserById(int userId);
    public UserInfo selectUserByLoginName(String loginName);
    public List<UserInfo> userPagingSelect(Paging paging);
}
