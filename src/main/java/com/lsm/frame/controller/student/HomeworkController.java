package com.lsm.frame.controller.student;

import com.lsm.frame.model.entity.User;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lsm
 */
@Controller
@RequestMapping("/student/homework")
public class HomeworkController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    /**
     * 编辑作业页面
     * @param m
     * @return
     */
    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/edit")
    public String edit(Model m) {

        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "student/homework/edit";
    }

}
