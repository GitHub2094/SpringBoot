package com.lsm.frame.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.model.entity.Job;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lsm
 * @date 2020.3.31
 * 测试Controller
 */
@Controller
public class TestController {

    /**
     * 返回json数据
     * 测试地址：
     * @return
     */
    @RequestMapping("/test")
    @LoggerManage(value="请求了testJson方法")
    @ResponseBody
    public User testJson(){
        User user = User.builder().userName("测试").phone("123456").build();
        return user;
    }

    @PostMapping("/category")
    @ResponseBody
    public AjaxResult addCategory(@RequestBody Job[] job) throws Exception {
        System.out.println("浏览器以JSON格式提交的数据："+job[0]);
        System.out.println("浏览器以JSON格式提交的数据："+job[1]);
        return AjaxResult.success("成功");
    }

    @RequestMapping("/course")
    public String course(Model m){
        List<Job> jobList = new ArrayList<Job>();
        m.addAttribute("jobList",jobList);
        return "student/course";
    }

}
