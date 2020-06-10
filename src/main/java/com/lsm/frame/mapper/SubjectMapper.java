package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    List<Subject> selectByJobId(Integer id);
}