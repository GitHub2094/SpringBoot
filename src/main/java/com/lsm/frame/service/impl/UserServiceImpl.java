package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.UserMapper;
import com.lsm.frame.model.entity.User;
import com.lsm.frame.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByLoginName(String loginName) {
        return userMapper.selectByLoginName(loginName);
    }
}
