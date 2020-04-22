package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.College;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(College record);

    int insertSelective(College record);

    College selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}