package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.entity.UserReply;

import java.util.List;

public interface UserReplyService {
    List<UserReply> selectByCjuId(Long id);

    int insertSelective(UserReply record);

    int updateByPrimaryKeySelective(UserReply record);

    CourseJobUser selectCJU(Long id);

    int updateCourseJobUser(CourseJobUser record);
}
