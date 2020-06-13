package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByLoginName(String loginName);

    List<User> selectUserTable(User user);

    int deleteUserByIds(Integer[] ids);
}