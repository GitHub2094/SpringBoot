package com.lsm.frame.controller.system;

import com.lsm.frame.annotation.LoggerManage;
import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/system/userManage")
public class UserManageController extends BaseController {


    @Autowired
    UserService userService;


    @RequiresRoles("root")
    @GetMapping("/test")
    public String test()
    {
        return "system/test";
    }

    @RequiresRoles("root")
    @GetMapping("/user")
    public String userManage()
    {
        return "system/userManage/user";
    }

    /**
     *
     * @return TableDataInfo表格信息
     */
    @RequiresRoles("root")
    //@RequiresPermissions("system:student)
    @RequestMapping("/getList")
    @ResponseBody
    public TableDataInfo getList(User user, HttpSession session) {
        startPage();
        List<User> list = userService.selectUserTable(user);
        return getDataTable(list);
    }

    /**
     * 修改用户
     */
    @RequiresRoles("root")
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Integer userId, Model m)
    {
        User user = userService.selectByPrimaryKey(userId);
        logger.info("将要编辑的用户："+user);
        m.addAttribute("user",user);
        return "system/userManage/edit";
    }

    /**
     * 修改b用户保存
     */
    @RequiresRoles("root")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editUpdate(@Validated User user, Model m)
    {
        User root = ShiroUtils.getUser();

        user.setUpdateTime(new Date());
        user.setUpdateBy(root.getUserName());

        logger.info("将要更新的用户："+user);

        userService.updateByPrimaryKeySelective(user);
        return AjaxResult.success("保存成功");
    }

    /**
     * 添加用户
     */
    @RequiresRoles("root")
    @GetMapping("/add")
    public String add(Model m)
    {
        return "system/userManage/add";
    }

    /**
     *  添加用户保存
     */
    @RequiresRoles("root")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addUpdate(@Validated User user, Model m)
    {
        User root = ShiroUtils.getUser();

        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(userService.encryptPassword(user.getPassword(),user.getSalt()));
        user.setCreateTime(new Date());
        user.setCreateBy(root.getUserName());

        logger.info("新增用户："+user);

        userService.insertSelective(user);

        return AjaxResult.success("保存成功");
    }

    /**
     * 批量删除用户
     * @param ids
     * @return
     */
    @RequiresRoles("root")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(userService.deleteUserByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     *
     * @param userId
     * @param mmap
     * @return
     */

    @GetMapping("/resetPwd/{userId}")
    public String resetPwd(@PathVariable("userId") Integer userId, Model m)
    {
        User user = userService.selectByPrimaryKey(userId);
        m.addAttribute("user",user);
        return "system/userManage/resetPwd";
    }
    /**
     *修改密码
     */
    @RequiresRoles("root")
    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwdSave(User user)
    {
        logger.info("被修改密码的用户"+user);
        user.setSalt(ShiroUtils.randomSalt());
        user.setPassword(userService.encryptPassword( user.getPassword(), user.getSalt()));
        userService.updateByPrimaryKeySelective(user);
        return AjaxResult.success("修改成功");
    }
}
