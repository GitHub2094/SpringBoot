package com.lsm.frame.controller;

import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /**
     * 个人中心
     */
    @RequestMapping("/profile")
    public String profile(Model m){
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "user/profile";
    }
    /**
     * 修改个人信息
     */
    @LoggerManage(value = "修改个人信息")
    @PostMapping("/update")
    @ResponseBody
    public String update(User user)
    {
        User currentUser = ShiroUtils.getUser();
        currentUser.setUserName(user.getUserName());
        currentUser.setPhone(user.getPhone());
        currentUser.setEmail(user.getEmail());
        currentUser.setSex(user.getSex());
        if (userService.updateByPrimaryKeySelective(currentUser) > 0)
        {
            ShiroUtils.setUser(userService.selectByPrimaryKey(currentUser.getUserId()));
            return "操作成功";
        }
        return "操作失败";
    }



}
