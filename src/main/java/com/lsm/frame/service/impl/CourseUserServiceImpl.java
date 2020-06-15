package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.CollegeMapper;
import com.lsm.frame.mapper.CourseMapper;
import com.lsm.frame.mapper.CourseUserMapper;
import com.lsm.frame.model.entity.College;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.CourseUser;
import com.lsm.frame.service.intf.CourseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CourseUserServiceImpl implements CourseUserService {

    @Autowired
    CourseUserMapper courseUserMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CollegeMapper collegeMapper;

    @Override
    public List<CourseUser> selectByUserId(Integer id) {
        return courseUserMapper.selectByUserId(id);
    }

    @Override
    public Course selectCourseByPrimaryKey(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public College selectCollegeByPrimaryKey(Integer id) {
        return collegeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Course> selectCourseByUserId(Integer id) {

        List<CourseUser> courseUserList = courseUserMapper.selectByUserId(id);
        List<Course> courseList = new ArrayList<Course>();
        for (CourseUser cu : courseUserList){
            Course course = (courseMapper.selectByPrimaryKey(cu.getCourseId()));
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public int insertSelective(CourseUser record) {
        for(Integer id : record.getStudentIds()){
            CourseUser courseUser = new CourseUser();
            courseUser.setCourseId(record.getCourseId());
            courseUser.setUserId(id);
            courseUserMapper.insertSelective(courseUser);
        }
        return 1;
    }


}
