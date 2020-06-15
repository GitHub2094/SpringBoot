package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.CourseMapper;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.service.intf.CourseService;
import com.lsm.frame.utils.string.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> selectCourseByCreate(String create) {
        return courseMapper.selectCourseByCreate(create);
    }

    @Override
    public List<Course> selectCourseTable(Course course) {
        return courseMapper.selectCourseTable(course);
    }

    @Override
    public int insertSelective(Course record) {
        return courseMapper.insertSelective(record);
    }

    @Override
    public Course selectByPrimaryKey(Integer id){
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Course record){
        return courseMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteCourseByIds(String ids){
        Integer[] courseIds = Convert.toIntArray(ids);
        return courseMapper.deleteCourseByIds(courseIds);
    }
}
