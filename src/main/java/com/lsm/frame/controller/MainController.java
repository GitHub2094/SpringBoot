package com.lsm.frame.controller;

import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.constant.enums.UserType;
import com.lsm.frame.model.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    /**
     * 页面跳转
     * @return
     */
    @RequestMapping("/")
    public String defaultWeb(){
        return "login";
    }

    @RequestMapping("/index")
    public String returnIndex(){
        return "index";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() {
        logger.info("加载登录界面");
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
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        //不勾选为空，赋值
        if (rememberMe == null) {
            rememberMe = false;
        }
        logger.info("记住我:"+rememberMe);
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password,rememberMe);

        try {
            // 执行认证登陆
            subject.login(token);
            logger.info("身份认证通过");
           //页面类型选择
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
        logger.info("进入学生界面");
        return "student";
    }

    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/teacher")
    public String teacher() {
        logger.info("进入教师界面");
        return "teacher";
    }

    @RequiresRoles("root")
    //@RequiresPermissions("system:student)
    @RequestMapping("/root")
    public String root(Model model) {
        logger.info("进入管理员界面");
        User user = User.builder().userName("测试").avatar("ssss").email("qqq@cj").build();
        model.addAttribute("user",user);
        return "root";
    }


}
