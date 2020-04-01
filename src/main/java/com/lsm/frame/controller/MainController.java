package com.lsm.frame.controller;

import com.lsm.frame.constant.enums.UserType;
import com.lsm.frame.model.entity.User;
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

    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/")
    public String defaultWeb(){
        return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() {
        System.out.println("加载登录页面");
        return "login";
    }

    /**
     * 登录验证
     * @param m Model
     * @param username 登录账号
     * @param password 登录密码
     * @param type  想进入的界面类型
     * @return redirect:到相应的
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model m,@RequestParam("username") String username,
                        @RequestParam("password") String password,@RequestParam("type") String type,
                        Boolean rememberMe) {
        System.out.println("username:"+username);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        System.out.println("是否记住密码"+rememberMe);
        // 在认证提交前准备 token（令牌）
        if (rememberMe == null) {
            rememberMe = false;
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);

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
    public String root(Model model) {
        System.out.println("加载管理员页面");
        User user = User.builder().userName("测试").avatar("ssss").email("qqq@cj").build();
        model.addAttribute("user",user);
        return "root";
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        System.out.println("登出账户");
        return "login";
    }





}
