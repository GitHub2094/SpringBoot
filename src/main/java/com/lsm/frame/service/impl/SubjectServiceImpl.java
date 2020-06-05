package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.JobSubjectMapper;
import com.lsm.frame.mapper.SubjectMapper;
import com.lsm.frame.model.entity.JobSubject;
import com.lsm.frame.model.entity.Subject;
import com.lsm.frame.service.intf.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    JobSubjectMapper jobSubjectMapper;


    @Override
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    @Override
    public int insertSelective(JobSubject record) {
        return jobSubjectMapper.insertSelective(record);
    }
}
