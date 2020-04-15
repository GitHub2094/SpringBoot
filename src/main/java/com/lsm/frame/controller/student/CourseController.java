package com.lsm.frame.controller.student;


import com.lsm.frame.model.entity.User;

import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * @author lsm
 */
@Controller
@RequestMapping("/student/course")
public class CourseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

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
        m.addAttribute("user",user);
        return "student/course/myCourse";
    }


    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/courseManagement")
    public String courseManagement(Model m,String id) {
        logger.info("gg"+id);
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
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
    public String task(Model m) {
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "student/course/task";
    }



}

