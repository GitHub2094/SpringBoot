package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.User;

public interface UserService {
    /**
     * 通过登录账号查找用户
     */
    User selectByLoginName(String loginName);
}
