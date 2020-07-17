package com.xiazhuoxian.bbs.pojo;

public class PartitionClassification {
    int partitionId;
    String partitionName;

    public int getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(int partitionId) {
        this.partitionId = partitionId;
    }

    public String getPartitionName() {
        return partitionName;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public PartitionClassification() {
    }

    public PartitionClassification(int partitionId, String partitionName) {

        this.partitionId = partitionId;
        this.partitionName = partitionName;
    }
}
