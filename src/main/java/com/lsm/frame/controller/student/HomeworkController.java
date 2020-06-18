package com.lsm.frame.controller.student;

import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.entity.FileUpload;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.model.entity.UserReply;
import com.lsm.frame.service.intf.FileService;
import com.lsm.frame.service.intf.UserReplyService;
import com.lsm.frame.utils.AjaxResult;
import com.lsm.frame.utils.ShiroUtils;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;

/**
 * @author lsm
 */
@Controller
@RequestMapping("/student/homework")
public class HomeworkController {

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserReplyService userReplyService;

    @Autowired
    FileService fileService;



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
    @GetMapping("/file")
    public String file(Integer id,HttpSession session){
        logger.info("job"+id);
        session.setAttribute("FileJobId",id);
        return "teacher/homework/file";
    }

    // uploadFile
    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> uploadFile(MultipartFile myfile,HttpSession session)
            throws IllegalStateException, IOException {
        // 原始名称
        String oldFileName = myfile.getOriginalFilename(); // 获取上传文件的原名
//      System.out.println(oldFileName);
        // 存储地址
        String saveFilePath = "E://frame//file";
        // 上传文件
        if (myfile != null && oldFileName != null && oldFileName.length() > 0) {
            // 新的文件名称
            String newFileName = UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
            // 新文件
            File newFile = new File(saveFilePath + "\\" + newFileName);
            // 将内存中的数据写入磁盘
            myfile.transferTo(newFile);
            FileUpload fileUpload = new FileUpload();
            fileUpload.setFilepath(newFileName);
            Integer jobId = (Integer) session.getAttribute("FileJobId");
            fileUpload.setJobId(jobId);
            fileService.insertSelective(fileUpload);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", "成功啦");
            map.put("url", newFileName);
            return map;
        } else {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "图片不合法");
            return map;
        }
    }

    @RequestMapping("/download")
    public AjaxResult  download(HttpServletResponse response , Model model,Integer id) {

        FileUpload fileUpload = fileService.selectByJobId(id);
        //待下载文件名
        String fileName = fileUpload.getFilepath();

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        byte[] buff = new byte[1024];
        //创建缓冲输入流
        BufferedInputStream bis = null;
        OutputStream outputStream = null;

        try {
            outputStream = response.getOutputStream();

            //这个路径为待下载文件的路径
            bis = new BufferedInputStream(new FileInputStream(new File("E:/frame/file/" + fileName )));
            int read = bis.read(buff);

            //通过while循环写入到指定了的文件夹中
            while (read != -1) {
                outputStream.write(buff, 0, buff.length);
                outputStream.flush();
                read = bis.read(buff);
            }
        } catch ( IOException e ) {
            e.printStackTrace();
            //出现异常返回给页面失败的信息
            return AjaxResult.error();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //成功后返回成功信息
        return AjaxResult.success("下载成功");
    }

}
