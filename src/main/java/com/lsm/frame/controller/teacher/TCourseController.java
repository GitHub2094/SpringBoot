package com.lsm.frame.controller.teacher;


import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.User;

import com.lsm.frame.model.vo.Jobs;
import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.service.intf.CourseService;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author lsm
 */
@Controller
@RequestMapping("/teacher/course")
public class TCourseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseService courseService;
    @Autowired
    CourseJobService courseJobService;
    /**
     * 我学的课页面
     * @param m
     * @return
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/myCourse")
    public String myCourse(Model m) {

        User user = ShiroUtils.getUser();
        Course currentCourse = Course.builder().createBy(user.getUserName()).build();
        logger.info("sd"+currentCourse);
        List<Course> courseList =  courseService.selectCourseByCreate(currentCourse.getCreateBy());
        logger.info("sdf"+courseList.size());
        m.addAttribute("courseList",courseList);
        return "teacher/myCourse";
    }


    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/courseManagement")
    public String courseManagement(Model m, Integer id,HttpSession session) {

        User user = ShiroUtils.getUser();
        List<Jobs> jobList = courseJobService.listJobsByCourseIdAndTeacherId(id,user.getUserId());
        for (Jobs j : jobList){
            logger.info("jobs:"+j);
        }
        String courseName = courseJobService.selectCourseByCourseId(id).getCourseName();
        m.addAttribute("jobList",jobList);
        m.addAttribute("courseName",courseName);
        session.setAttribute("courseId",id);
        return "teacher/courseManagement";
    }


}

