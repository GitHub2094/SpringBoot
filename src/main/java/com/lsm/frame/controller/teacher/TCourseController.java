package com.lsm.frame.controller.teacher;


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
@RequestMapping("/teacher/course")
public class TCourseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

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
        m.addAttribute("user",user);
        return "teacher/myCourse";
    }


    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/courseManagement")
    public String courseManagement(Model m) {
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "teacher/courseManagement";
    }


}

