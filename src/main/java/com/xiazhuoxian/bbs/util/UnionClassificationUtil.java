package com.xiazhuoxian.bbs.util;

public class UnionClassificationUtil {
    public static int getUnionId(String unionName){
        int unionId=0;
        switch (unionName){
            case "CBA":unionId=1;break;
            case "NBA":unionId=2;break;
            case "DEFAUlTDEFAUlT":unionId=3;break;
        }
        return unionId;
    }
}
