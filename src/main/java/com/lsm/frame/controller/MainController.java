package com.lsm.frame.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {




    @RequestMapping("/index")
    public String index(Model m) {

        System.out.println(",,,");
        m.addAttribute("category","tttttt");
        return "index";
    }
    @RequestMapping("/notRole")
    public String notRole(Model m) {
        return "notRole";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String defaultLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("username:"+username);
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        System.out.println("subject:"+subject);
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        try {
            subject.login(token);
            System.out.println("------------------------");
            System.out.println("subject:"+subject);
            return "index";
        }
         catch (AuthenticationException ae) {
            return "用户名或密码不正确";
        }
    }





}
