package com.lsm.frame.controller.teacher;


import com.lsm.frame.controller.BaseController;
import com.lsm.frame.model.dto.TableDataInfo;
import com.lsm.frame.model.entity.*;
import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.service.intf.UserReplyService;
import com.lsm.frame.service.intf.UserService;
import com.lsm.frame.utils.AjaxResult;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher/review")
public class ReviewController extends BaseController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    CourseJobService courseJobService;

    @Autowired
    UserReplyService userReplyService;

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
    public TableDataInfo getList(CourseJobUser courseJobUser,HttpSession session) {
        startPage();
        CourseJob courseJob = (CourseJob)session.getAttribute("courseJob");
        courseJobUser.setCourseJobId(courseJob.getId());
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
    public String list(Model m, String id, HttpSession session) {
        int courseId = (Integer) session.getAttribute("courseId");
        logger.info("courseId"+courseId);
        CourseJob courseJob = courseJobService.selectCourseJobByCourseIdAndJobId(courseId,Integer.parseInt(id));
        logger.info("courseJob"+courseJob);
        session.setAttribute("courseJob",courseJob);
        return "teacher/homework/studentJobList";
    }

    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/review")
    public String review(Model m,String id,HttpSession session) {
        List<UserReply> userReplyList = userReplyService.selectByCjuId(Integer.parseInt(id));
        for (UserReply userReply : userReplyList) {
            logger.info("test"+userReply);
        }
        CourseJobUser courseJobUser = userReplyService.selectCJU(Integer.parseInt(id));
        session.setAttribute("courseJobUser",courseJobUser);
        String userName = userService.selectByPrimaryKey(courseJobUser.getUserId()).getUserName();
        logger.info("test"+courseJobUser+userName);
        m.addAttribute("userReplyList",userReplyList);
        m.addAttribute("userName",userName);
        return "teacher/homework/review";
    }


    /**
     *
     * @param m
     * @return
     */
    @RequiresRoles("teacher")
    //@RequiresPermissions("system:student)
    @RequestMapping("/reviewUpdate")
    @ResponseBody
    public AjaxResult reviewUpdate(Model m, @RequestBody UserReply[] userReplies,HttpSession session) {
        logger.info("提交成绩"+userReplies[0]);
        int score = 0;
        for(UserReply userReply : userReplies){
            userReplyService.updateByPrimaryKeySelective(userReply);
            score = score + userReply.getScore();
        }
        CourseJobUser courseJobUser = (CourseJobUser)session.getAttribute("courseJobUser");
        courseJobUser.setScore(score);
        logger.info("test"+courseJobUser);
        courseJobService.updateByPrimaryKeySelective(courseJobUser);
        return AjaxResult.success("提交成功");
    }
}
