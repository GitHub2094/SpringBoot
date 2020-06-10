package com.lsm.frame.controller.student;

import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.model.entity.UserReply;
import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.service.intf.UserReplyService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
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
import java.util.Date;
import java.util.List;

/**
 * @author lsm
 */
@Controller
@RequestMapping("/student/homework")
public class HomeworkController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserReplyService userReplyService;




    /**
     * 编辑作业页面
     * @param m
     * @return
     */
    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/edit")
    public String edit(Model m,Long id,HttpSession session) {
        List<UserReply> userReplyList = userReplyService.selectByCjuId(id);
        String courseName = "";
        for (UserReply userReply: userReplyList){
            logger.info("sdfs"+userReply);
            courseName = userReply.getSubjectModel().getCourseName();
        }
        User user = ShiroUtils.getUser();
        m.addAttribute("userReplyList",userReplyList);
        m.addAttribute("user",user);
        m.addAttribute("courseName",courseName);
        session.setAttribute("cjuId",id);
        return "student/homework/edit";
    }

    /**
     *
     * @param m
     * @return
     */
    @RequiresRoles("student")
    //@RequiresPermissions("system:student)
    @RequestMapping("/editUpdate")
    @ResponseBody
    public AjaxResult editUpdate(Model m,@RequestBody UserReply[] userReplies,HttpSession session) {
        for(UserReply userReply : userReplies){
            logger.info("编辑作业"+userReply);
            userReplyService.updateByPrimaryKeySelective(userReply);
        }
        Long id = Long.parseLong(session.getAttribute("cjuId").toString());
        CourseJobUser courseJobUser = userReplyService.selectCJU(id);
        courseJobUser.setState("2");
        courseJobUser.setSubmitTime(new Date());
        userReplyService.updateCourseJobUser(courseJobUser);
        return AjaxResult.success("提交作业成功");
    }


}
