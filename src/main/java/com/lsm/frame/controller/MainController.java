package com.lsm.frame.controller;

import com.lsm.frame.constant.enums.UserType;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() {
        System.out.println("加载登录页面");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model m,@RequestParam("username") String username,
                        @RequestParam("password") String password,@RequestParam("type") String type) {
        System.out.println("username:"+username);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            // 执行认证登陆
            subject.login(token);
            System.out.println("----登录认证成功----");
            return UserType.valueOf(type).op();
        }
         catch (AuthenticationException e) {
            m.addAttribute("message", "账号密码不正确");
            return "login";
        }
    }
    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/student")
    public String student() {
        System.out.println("加载学生页面");
        return "student";
    }

    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/teacher")
    public String teacher() {
        System.out.println("加载教师页面");
        return "teacher";
    }

    @RequiresRoles("root")
    //@RequiresPermissions("system:student)
    @RequestMapping("/root")
    public String root() {
        System.out.println("加载教师页面");
        return "root";
    }




}
