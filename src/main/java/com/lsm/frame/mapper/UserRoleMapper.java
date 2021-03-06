package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.Role;
import com.lsm.frame.model.entity.UserRoleKey;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    UserRoleKey selectByUserID(Integer userId);

    int updateByUserId(UserRoleKey userRoleKey);

    int deleteByUserId(Integer id);
}