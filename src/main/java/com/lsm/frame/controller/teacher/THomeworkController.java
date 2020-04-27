package com.lsm.frame.controller.teacher;


import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.Job;
import com.lsm.frame.model.entity.User;

import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author lsm
 */
@Controller
@RequestMapping("/teacher/homework")
public class THomeworkController extends BaseController{

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseJobService courseJobService;
    /**
     * 我学的课页面
     * @param m
     * @return
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/add")
    public String add(Model m) {

        User user = ShiroUtils.getUser();
        m.addAttribute("user",user);
        return "teacher/homework/add";
    }


    /**
     *
     * @param m
     * @return
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/getList")
    @ResponseBody
    public TableDataInfo getList(Job job) {
        startPage();
        User user = ShiroUtils.getUser();
        job.setCreateBy(user.getUserName());
        List<Job> list = courseJobService.selectJobList(job);
        return getDataTable(list);
    }


    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/list")
    public String list(Model m) {

        return "teacher/homework/list";
    }




}

