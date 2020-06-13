package com.lsm.frame.controller.system;

import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/system/userManage")
public class UserManageController extends BaseController {


    @Autowired
    UserService userService;


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
}
