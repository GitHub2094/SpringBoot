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
@RequestMapping("/teacher/homework")
public class THomeworkController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    /**
     * 我学的课页面
     * @param m
     * @return
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/add")
    public String add(Model m) {

        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "teacher/homework/add";
    }


}

