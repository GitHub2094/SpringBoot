package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.*;
import com.lsm.frame.model.entity.*;
import com.lsm.frame.service.intf.UserReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserReplyServiceImpl implements UserReplyService {

    @Autowired
    UserReplyMapper userReplyMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    OptionMapper optionMapper;

    @Autowired
    CourseJobUserMapper courseJobUserMapper;

    @Autowired
    CourseJobMapper courseJobMapper;


    @Override
    public List<UserReply> selectByCjuId(Long id) {
        List<UserReply> userReplyList = new ArrayList<>();
        userReplyList = userReplyMapper.selectByCjuId(id);
        CourseJobUser courseJobUser = courseJobUserMapper.selectByPrimaryKey(id);
        CourseJob courseJob = courseJobMapper.selectByPrimaryKey(courseJobUser.getCourseJobId());
        List<Subject> subjects = subjectMapper.selectByJobId(courseJob.getJobId());
        if (userReplyList.size() < subjects.size()) {
            int i =0;
            int j = userReplyList.size();
            for (Subject subject : subjects){
                if (i>=j) {
                    UserReply userReply = new UserReply();
                    userReply.setSubject(subject.getId());
                    userReply.setCjuId(id);
                    userReply.setScore(0);
                    userReplyMapper.insertSelective(userReply);
                }else{
                    i++;
                }
            }
            userReplyList = userReplyMapper.selectByCjuId(id);
        }

        for (UserReply userReply : userReplyList){
            Subject subject = subjectMapper.selectByPrimaryKey(userReply.getSubject());
            subject.setCourseName(courseMapper.selectByPrimaryKey(subject.getCourseId()).getCourseName());
            List<Option> optionList = optionMapper.selectBySubjectId(subject.getId());
            subject.setOptions(optionList);
            userReply.setSubjectModel(subject);
        }
        return userReplyList;
    }

    @Override
    public int insertSelective(UserReply record) {
        return userReplyMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(UserReply record) {
        return userReplyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public CourseJobUser selectCJU(Long id) {
        return courseJobUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateCourseJobUser(CourseJobUser record) {
        return courseJobUserMapper.updateByPrimaryKeySelective(record);
    }


}
