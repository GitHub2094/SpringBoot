package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.JobSubject;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JobSubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JobSubject record);

    int insertSelective(JobSubject record);

    JobSubject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobSubject record);

    int updateByPrimaryKey(JobSubject record);


}