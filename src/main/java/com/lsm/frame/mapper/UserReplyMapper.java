package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.UserReply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserReply record);

    int insertSelective(UserReply record);

    UserReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserReply record);

    int updateByPrimaryKey(UserReply record);

    List<UserReply> selectByCjuId(Long id);
}