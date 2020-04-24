package com.lsm.frame.controller;

import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.model.entity.Job;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public AjaxResult addCategory(Job job) throws Exception {
        System.out.println("浏览器以JSON格式提交的数据："+job);
        return AjaxResult.success("成功");
    }

    @RequestMapping("/course")
    public String course(Model m){
        Job job = Job.builder().id(1).title("测试").createBy("放桂皮").build();
        m.addAttribute("job",job);
        return "student/course";
    }

}
