package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.CourseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseUser record);

    int insertSelective(CourseUser record);

    CourseUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseUser record);

    int updateByPrimaryKey(CourseUser record);

    List<CourseUser>  selectByUserId(Integer id);
}