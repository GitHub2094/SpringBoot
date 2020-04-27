package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.User;

public interface UserService {
    /**
     * 通过登录账号查找用户
     */
    User selectByLoginName(String loginName);

    /**
     * 更细信息
     */
    int updateByPrimaryKeySelective(User record);


    /**
     * 通过主键查找
     */
    User selectByPrimaryKey(Integer userId);
    /**
     *插入
     */
    int insertSelective(User record);
    /**
     * 密码匹配
     */
    boolean matches(User user,String oldPassword);

    String encryptPassword(String password, String salt);



}
