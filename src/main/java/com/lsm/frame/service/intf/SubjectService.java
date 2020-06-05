package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.JobSubject;
import com.lsm.frame.model.entity.Subject;

public interface SubjectService {

    int insertSelective(Subject record);

    int insertSelective(JobSubject record);
}
