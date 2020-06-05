package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.vo.StudentJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseJobUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseJobUser record);

    int insertSelective(CourseJobUser record);

    CourseJobUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseJobUser record);

    int updateByPrimaryKey(CourseJobUser record);

    CourseJobUser selectCjuBycju(Integer cjId,Integer userId);

    List<CourseJobUser> getList(CourseJobUser courseJobUser);
}