package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.JobSubject;
import com.lsm.frame.model.entity.Option;
import com.lsm.frame.model.entity.Subject;

import java.util.List;

public interface SubjectService {

    int insertSelective(Subject record);

    int insertSelective(JobSubject record);

    void insertOptionList(List<Option> optionList);
}
