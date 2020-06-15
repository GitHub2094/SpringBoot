package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectCourseByCreate(String create);

    List<Course> selectCourseTable(Course course);

    int deleteCourseByIds(Integer[] ids);
}