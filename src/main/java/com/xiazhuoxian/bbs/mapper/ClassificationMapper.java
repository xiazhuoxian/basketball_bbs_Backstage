package com.xiazhuoxian.bbs.mapper;

import com.xiazhuoxian.bbs.pojo.UnionClassification;

public interface ClassificationMapper {
    public UnionClassification selectUnionByUnionName(String unionName);
}
