package com.lsm.frame.controller.teacher;


import com.lsm.frame.controller.BaseController;
import com.lsm.frame.mapper.SubjectMapper;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.*;

import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.service.intf.CourseService;
import com.lsm.frame.service.intf.SubjectService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.DateUtils;
import com.lsm.frame.utils.ShiroUtils;
import com.lsm.frame.utils.string.StringUtils;
import com.lsm.frame.utils.string.SuffixUntild;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
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

    @Autowired
    SubjectService subjectService;

    @Autowired
    CourseService courseService;



    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/editTitle")
    @ResponseBody
    public  AjaxResult editTitle(Job job) {
        System.out.println("ss"+job);
        job.setUpdateTime(new Date());
        courseJobService.updateByPrimaryKeySelective(job);
        return AjaxResult.success("保存成功");
    }
    /**
     *
     * @return TableDataInfo表格信息
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/getList")
    @ResponseBody
    public TableDataInfo getList(Job job) {
        startPage();
        User user = ShiroUtils.getUser();
        if (StringUtils.isEmpty(job.getCreateBy())){
            job.setCreateBy(user.getUserName());
        }
        List<Job> list = courseJobService.selectJobList(job);
        return getDataTable(list);
    }


    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/list")
    public String list(Model m) {
        return "teacher/homework/list";
    }

    @RequiresRoles("teacher")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(courseJobService.deleteJobByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }
    /**
     * 新增作业
     * @param m
     * @return
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/add")
    public String add(Model m,HttpSession session) {
        User user = ShiroUtils.getUser();
        Job currentJob = new Job();
        currentJob.setTitle(SuffixUntild.jobTitleSuffix());
        currentJob.setCreateTime(new Date());
        currentJob.setCreateBy(user.getUserName());
        courseJobService.insertSelective(currentJob);
        Job job = courseJobService.selectJob(currentJob);
        logger.info("jobtest"+job);
        m.addAttribute("job",job);
        session.setAttribute("jobId",job.getId());
        return "teacher/homework/add";
    }

    /**
     * 新增简答题
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/addSimpleAnswer")
    @ResponseBody
    public  AjaxResult addSimpleAnswer(Subject subject, HttpSession session) {
        int courseId = Integer.parseInt(session.getAttribute("courseId").toString());
        int jobId = Integer.parseInt(session.getAttribute("jobId").toString());
        logger.info("dsfsd"+jobId+"te"+courseId);
        subject.setCourseId(courseId);
        subject.setJobId(jobId);
        subjectService.insertSelective(subject);

        return AjaxResult.success("保存成功");
    }

    /**
     * 新增简答题
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @GetMapping("/issue/{id}")
    public String issue(@PathVariable("id") Integer id,Model m) {
        User user = ShiroUtils.getUser();
        List<Course> courseList =  courseService.selectCourseByCreate(user.getUserName());
        logger.info("sdf"+courseList.size());
        m.addAttribute("courseList",courseList);
        m.addAttribute("job",courseJobService.selectJobByPrimaryKey(id));
        return "teacher/homework/issue";
    }

    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/issue")
    @ResponseBody
    public AjaxResult issueSave(Integer courseId,Integer jobId,Date startTime,Date endTime) {
        CourseJob courseJob = CourseJob.builder().courseId(courseId).jobId(jobId).startTime(startTime).endTime(endTime).build();
        logger.info("st"+courseJob);
        courseJobService.insertSelective(courseJob);
        return AjaxResult.success("发布成功");
    }

}

