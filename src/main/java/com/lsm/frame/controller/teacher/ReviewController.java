package com.lsm.frame.controller.teacher;


import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.entity.Job;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.model.vo.StudentJob;
import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.ShiroUtils;
import com.lsm.frame.utils.string.StringUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher/review")
public class ReviewController extends BaseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseJobService courseJobService;

    @Autowired
    UserService userService;
    /**
     *
     * @return TableDataInfo表格信息
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/reviewList")
    @ResponseBody
    public TableDataInfo getList(CourseJobUser courseJobUser) {
        startPage();
        courseJobUser.setCourseJobId(1);
        List<CourseJobUser> list = courseJobService.getList(courseJobUser);
        for (CourseJobUser cju : list){
            User user = userService.selectByPrimaryKey(cju.getUserId());
            cju.setStudentName(user.getUserName());
            cju.setLoginName(user.getLoginName());
            logger.info("tt"+cju);
        }
        return getDataTable(list);
    }

    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/getlist")
    public String list(Model m) {
        return "teacher/homework/studentJobList";
    }
}
