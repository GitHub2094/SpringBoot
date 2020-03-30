package com.lsm.frame.service.intf;

public interface UserRoleService {
    /**
     * 通过UserId找到对应的角色key
     */
    String selectKeyByUserID(Integer userId);
}
