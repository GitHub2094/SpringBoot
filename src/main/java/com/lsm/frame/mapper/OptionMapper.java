package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.Option;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Option record);

    int insertSelective(Option record);

    Option selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Option record);

    int updateByPrimaryKey(Option record);
}