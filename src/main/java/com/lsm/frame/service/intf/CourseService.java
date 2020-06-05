package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.Course;

import java.util.List;

public interface CourseService  {
    /**
     * 老师查找课程
     * @param create
     * @return
     */
    List<Course> selectCourseByCreate(String create);

}
