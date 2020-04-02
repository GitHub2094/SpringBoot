package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.RoleMapper;
import com.lsm.frame.mapper.UserRoleMapper;
import com.lsm.frame.model.entity.Role;
import com.lsm.frame.model.entity.UserRoleKey;
import com.lsm.frame.service.intf.UserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleMapper roleMapper;

    private Logger logger =  LoggerFactory.getLogger(this.getClass());

    @Override
    public String selectKeyByUserID(Integer userId) {
        UserRoleKey userRoleKey = userRoleMapper.selectByUserID(userId);
        Role  role = roleMapper.selectByPrimaryKey(userRoleKey.getRoleId());
        logger.info("获取到的角色Role:"+role);
        return role.getRoleKey();
    }
}
