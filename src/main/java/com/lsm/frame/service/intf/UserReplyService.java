package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.UserReply;

import java.util.List;

public interface UserReplyService {
    List<UserReply> selectByCjuId(Integer id);
}
