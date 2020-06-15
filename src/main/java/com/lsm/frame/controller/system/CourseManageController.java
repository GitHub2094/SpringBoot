package com.lsm.frame.controller.system;

import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.CourseService;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("system/courseManage")
@Controller
public class CourseManageController extends BaseController {


    @Autowired
    CourseService courseService;

    @Autowired
    UserService userService;


    @RequestMapping("/course")
    public String course(){
        return "system/courseManage/course";
    }
    /**
     *
     * @return TableDataInfo表格信息
     */
    @RequiresRoles("root")
    //@RequiresPermissions("system:student)
    @RequestMapping("/getList")
    @ResponseBody
    public TableDataInfo getList(Course course, HttpSession session) {
        startPage();
        List<Course> list = courseService.selectCourseTable(course);
        return getDataTable(list);
    }

    /**
     * 添加课程
     */
    @RequiresRoles("root")
    @GetMapping("/add")
    public String add(Model m)
    {
        List<User> teacherList = userService.selectUserTeacher();
        m.addAttribute("teacherList",teacherList);
        return "system/courseManage/add";
    }

    /**
     *  添加课程保存
     */
    @RequiresRoles("root")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addUpdate(@Validated Course course)
    {
        User user = ShiroUtils.getUser();
        logger.info("新增课程："+course);
        courseService.insertSelective(course);
        return AjaxResult.success("保存成功");
    }


    /**
     * 添加课程
     */
    @RequiresRoles("root")
    @GetMapping("/edit")
    public String edit(Model m)
    {

        return "system/courseManage/edit";
    }

    /**
     * 修改用户
     */
    @RequiresRoles("root")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model m)
    {
        Course course = courseService.selectByPrimaryKey(id);
        List<User> teacherList = userService.selectUserTeacher();
        m.addAttribute("teacherList",teacherList);
        m.addAttribute("course",course);
        return "system/courseManage/edit";
    }

    /**
     * 修改课程保存
     */
    @RequiresRoles("root")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editUpdate(@Validated Course course, Model m)
    {
        logger.info("将要修改的课程"+course);
        courseService.updateByPrimaryKeySelective(course);
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
        logger.info("删除的ids"+ids);
        try
        {
            return toAjax(courseService.deleteCourseByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
}
