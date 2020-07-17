package com.xiazhuoxian.bbs.service.serviceImpl;

import com.xiazhuoxian.bbs.mapper.ClassificationMapper;
import com.xiazhuoxian.bbs.pojo.UnionClassification;
import com.xiazhuoxian.bbs.service.ClassificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClassificationServiceImpl implements ClassificationService {
    @Autowired
    ClassificationMapper classificationMapper;

    @Override
    public UnionClassification selectUnionByUnionName(String unionName){
        return classificationMapper.selectUnionByUnionName(unionName);
    }
}
