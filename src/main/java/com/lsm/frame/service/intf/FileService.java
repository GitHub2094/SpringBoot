package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.FileUpload;

public interface FileService {
    int insertSelective(FileUpload record);

    FileUpload selectByJobId(Integer id);
}
