package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.Job;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}