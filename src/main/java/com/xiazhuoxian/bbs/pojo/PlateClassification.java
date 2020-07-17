package com.xiazhuoxian.bbs.pojo;

public class PlateClassification {
    int plateId;
    String plateName;

    public PlateClassification(int plateId) {
        this.plateId = plateId;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public PlateClassification() {

    }

    public PlateClassification(int plateId, String plateName) {

        this.plateId = plateId;
        this.plateName = plateName;
    }
}
