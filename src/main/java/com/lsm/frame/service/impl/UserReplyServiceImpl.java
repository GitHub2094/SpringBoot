package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.*;
import com.lsm.frame.model.entity.*;
import com.lsm.frame.service.intf.UserReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public List<UserReply> selectByCjuId(Integer id) {
        List<UserReply> userReplyList = userReplyMapper.selectByCjuId(id);
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
    public CourseJobUser selectCJU(Integer id) {
        return courseJobUserMapper.selectByPrimaryKey(id);
    }


}
