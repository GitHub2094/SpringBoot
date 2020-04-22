package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.CourseJob;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseJobMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CourseJob record);

    int insertSelective(CourseJob record);

    CourseJob selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CourseJob record);

    int updateByPrimaryKey(CourseJob record);

    List<CourseJob> selectByCourseId(Integer id);
}