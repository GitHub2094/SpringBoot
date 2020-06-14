package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.UserRoleKey;

public interface UserRoleService {
    /**
     * 通过UserId找到对应的角色key
     */
    String selectKeyByUserID(Integer userId);

    /**
     * 修改用户类型
     */
    int updateByUserId(UserRoleKey userRoleKey);

    /**
     * 创建用户，添加权限
     */
    int insert(UserRoleKey record);
}
