package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.College;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.CourseUser;

import java.util.List;

public interface CourseUserService {
    /**
     * 通过UserId找到CoureId
     * @param id
     * @return
     */
    List<CourseUser> selectByUserId(Integer id);

    /**
     * 通过
     * @param id
     * @return
     */
    Course selectCourseByPrimaryKey(Integer id);

    /**
     * ss
     * @param id
     * @return
     */
    College selectCollegeByPrimaryKey(Integer id);

    List<Course> selectCourseByUserId(Integer id);
}
