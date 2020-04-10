package com.lsm.frame.controller;

import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /**
     * 个人中心页面
     */
    @RequestMapping("/profile")
    public String profile(Model m){
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "user/profile";
    }


    /**
     *
     * 修改密码页面
     */
    @GetMapping("/resetPwd")
    public String resetPwd(Model m)
    {
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "user/resetPwd";
    }
    /**
     * 修改头像页面
     */
    @GetMapping("/avatar")
    public String avatar(Model m){
        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "user/avatar";
    }

    /**
     * 修改个人信息
     */
    @LoggerManage(value = "修改个人信息")
    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(User user)
    {
        User currentUser = ShiroUtils.getUser();
        currentUser.setUserName(user.getUserName());
        currentUser.setPhone(user.getPhone());
        currentUser.setEmail(user.getEmail());
        currentUser.setSex(user.getSex());
        if (userService.updateByPrimaryKeySelective(currentUser) > 0)
        {
            ShiroUtils.setUser(userService.selectByPrimaryKey(currentUser.getUserId()));
            return AjaxResult.success();
        }
        return AjaxResult.error();
    }

    /**
     *
     *修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @LoggerManage(value = "修改密码")
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(String oldPassword, String newPassword)
    {
        User currentUser = ShiroUtils.getUser();
        if (oldPassword != null && userService.matches(currentUser,oldPassword))
        {
            currentUser.setSalt(ShiroUtils.randomSalt());
            currentUser.setPassword(userService.encryptPassword(newPassword,currentUser.getSalt()));
            if (userService.updateByPrimaryKeySelective(currentUser) > 0)
            {
                ShiroUtils.setUser(userService.selectByPrimaryKey(currentUser.getUserId()));
                return AjaxResult.success();
            }
            return AjaxResult.error();
        }
        else
        {
            return AjaxResult.error("修改密码失败，旧密码错误");
        }
    }

    /**
     * 保存头像
     */
    @LoggerManage(value = "保存头像")
    @PostMapping("/updateAvatar")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file)
    {
        User currentUser = ShiroUtils.getUser();
        try
        {
            if (!file.isEmpty())
            {
                String avatar = file.getOriginalFilename();
                currentUser.setAvatar(avatar);
                if (userService.updateByPrimaryKeySelective(currentUser) > 0)
                {
                    ShiroUtils.setUser(userService.selectByPrimaryKey(currentUser.getUserId()));
                    return AjaxResult.success();
                }
            }
            return AjaxResult.error();
        }
        catch (Exception e)
        {
            logger.error("修改头像失败！", e);
            return AjaxResult.error(e.getMessage());
        }
    }
}
