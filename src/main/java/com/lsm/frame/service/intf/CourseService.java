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

    /**
     * 课程管理
     */
    List<Course> selectCourseTable(Course course);

    /**
     * 插入课程
     */
    int insertSelective(Course record);

    /**
     *
     */
    Course selectByPrimaryKey(Integer id);

    /**
     * 更新课程信息
     */
    int updateByPrimaryKeySelective(Course record);

    /**
     * 批量删除
     */
    int deleteCourseByIds(String ids);
}
