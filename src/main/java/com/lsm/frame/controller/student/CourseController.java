package com.lsm.frame.controller.student;

import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author lsm
 */
@Controller
@RequestMapping("/student/course")
public class CourseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/myCourse")
    public String myCourse(Model m) {

        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "student/course/myCourse";
    }

}

