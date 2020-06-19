package com.lsm.frame.mapper;

import com.lsm.frame.model.entity.FileUpload;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileUploadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FileUpload record);

    int insertSelective(FileUpload record);

    FileUpload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FileUpload record);

    int updateByPrimaryKey(FileUpload record);

    List<FileUpload> selectByJobId(Integer id);
}