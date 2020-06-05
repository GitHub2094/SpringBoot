package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.CourseMapper;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.service.intf.CourseService;
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
}
