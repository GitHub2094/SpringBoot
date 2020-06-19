package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.FileUpload;

import java.util.List;

public interface FileService {
    int insertSelective(FileUpload record);

    List<FileUpload> selectByJobId(Integer id);


    FileUpload selectByPrimaryKey(Integer id);

}
