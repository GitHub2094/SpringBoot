package com.lsm.frame.controller;

import com.lsm.frame.model.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lsm
 * @date 2020.3.31
 * 测试Controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 返回json数据
     * 测试地址：
     * @return
     */
    @RequestMapping("testJson")
    public User testJson(){
        User user = User.builder().userName("测试").phone("123456").build();
        return user;
    }
}
