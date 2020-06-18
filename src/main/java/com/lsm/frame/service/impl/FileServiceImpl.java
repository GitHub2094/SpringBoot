package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.FileUploadMapper;
import com.lsm.frame.model.entity.FileUpload;
import com.lsm.frame.service.intf.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {


    @Autowired
    FileUploadMapper fileUploadMapper;

    @Override
    public int insertSelective(FileUpload record) {
        return fileUploadMapper.insertSelective(record);
    }

    @Override
    public FileUpload selectByJobId(Integer id) {
        return fileUploadMapper.selectByJobId(id);
    }
}
