package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.SubjectMapper;
import com.lsm.frame.mapper.UserReplyMapper;
import com.lsm.frame.model.entity.Job;
import com.lsm.frame.model.entity.Subject;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.model.entity.UserReply;
import com.lsm.frame.service.intf.UserReplyService;
import com.lsm.frame.service.intf.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReplyServiceImpl implements UserReplyService {

    @Autowired
    UserReplyMapper userReplyMapper;

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public List<UserReply> selectByCjuId(Integer id) {
        List<UserReply> userReplyList = userReplyMapper.selectByCjuId(id);
        for (UserReply userReply : userReplyList){
            Subject subject = subjectMapper.selectByPrimaryKey(userReply.getSubject());
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


}
