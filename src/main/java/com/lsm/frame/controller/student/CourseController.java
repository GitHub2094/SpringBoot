package com.lsm.frame.controller.student;


import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.CourseUser;
import com.lsm.frame.model.entity.User;

import com.lsm.frame.model.vo.Jobs;
import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.service.intf.CourseUserService;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * @author lsm
 */
@Controller
@RequestMapping("/student/course")
public class CourseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseUserService courseUserService;

    @Autowired
    CourseJobService courseJobService;
 /**
     * 我学的课页面
     * @param m
     * @return
     */
    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/myCourse")
    public String myCourse(Model m) {

        User user = ShiroUtils.getUser();
        List<Course> courseList = courseUserService.selectCourseByUserId(user.getUserId());
        for (Course c : courseList){
            logger.info("我的课程"+c);
        }
        m.addAttribute("courseList",courseList);
        m.addAttribute("user",user);
        return "student/course/myCourse";
    }


    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/courseManagement")
    public String courseManagement(Model m, Integer id) {

        User user = ShiroUtils.getUser();
        List<Jobs> jobsList = courseJobService.listJobsByCourseIdAndUserId(id,user.getUserId());
        for (Jobs j : jobsList){
            logger.info("jobs:"+j);
        }
        String courseName = courseJobService.selectCourseByCourseId(id).getCourseName();
        m.addAttribute("jobsList",jobsList);
        m.addAttribute("courseName",courseName);
        m.addAttribute("courseId",id);
        return "student/course/courseManagement";
    }

    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/toDoHomework")
    public String toDoHomeworkt(Model m) {
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "student/course/toDoHomework";
    }

    /**
     * 加入课程
     * @param m
     * @return
     */
    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/addCourse")
    public String addCourse(Model m) {

        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "student/course/addCourse";
    }


    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/task")
    public String task(Model m,int id) {
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        m.addAttribute("courseId",id);
        return "student/course/task";
    }



}

