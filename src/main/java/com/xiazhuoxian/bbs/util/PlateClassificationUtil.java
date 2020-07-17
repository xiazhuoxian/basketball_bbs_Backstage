package com.xiazhuoxian.bbs.util;

public class PlateClassificationUtil {
    public static int getPlateId(String plateName){
        int plateId=0;
        switch (plateName){
            case "NEWS":plateId=1;break;
            case "新闻":plateId=1;break;
            case "COMMUNITY":plateId=2;break;
            case "社区":plateId=2;break;
            case "VIDEO":plateId=3;break;
            case "视频":plateId=3;break;
            case "DEFAUlTDEFAUlT":plateId=4;break;
        }
        return plateId;
    }
}
