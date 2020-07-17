package com.xiazhuoxian.bbs.util;

public class PartitionClassificationUtil {
    public static int getPartitionId(String partitionName){
        int partitionId=0;
        switch (partitionName){
            case "南":partitionId=1;break;
            case "北":partitionId=2;break;
            case "东部":partitionId=3;break;
            case "西部":partitionId=4;break;
            case "DEFAUlTDEFAUlT":partitionId=5;break;
        }
        return partitionId;
    }
}
