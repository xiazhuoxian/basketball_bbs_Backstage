package com.xiazhuoxian.bbs.util;

public class CommunityClassificationUtil {
    public static int getCommunityId(String communityName){
        int communityId=0;
        switch (communityName){
            case "广东":communityId=1;break;
            case "北京":communityId=2;break;
            case "DEFAUlTDEFAUlT":communityId=3;break;
        }
        return communityId;
    }
}
