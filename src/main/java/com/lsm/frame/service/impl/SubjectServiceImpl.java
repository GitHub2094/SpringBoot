package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.JobSubjectMapper;
import com.lsm.frame.mapper.OptionMapper;
import com.lsm.frame.mapper.SubjectMapper;
import com.lsm.frame.model.entity.JobSubject;
import com.lsm.frame.model.entity.Option;
import com.lsm.frame.model.entity.Subject;
import com.lsm.frame.service.intf.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectMapper subjectMapper;
    @Autowired
    JobSubjectMapper jobSubjectMapper;
    @Autowired
    OptionMapper optionMapper;


    @Override
    public int insertSelective(Subject record) {
        return subjectMapper.insertSelective(record);
    }

    @Override
    public int insertSelective(JobSubject record) {
        return jobSubjectMapper.insertSelective(record);
    }

    @Override
    public void insertOptionList(List<Option> optionList) {
        for (Option option:optionList){
            optionMapper.insert(option);
        }
    }

    @Override
    public List<Subject> selectByJobId(Integer id) {
        List<Subject> subjectList = subjectMapper.selectByJobId(id);
        for (Subject subject:subjectList){
            subject.setOptions(optionMapper.selectBySubjectId(subject.getId()));
        }
        return subjectList;
    }

    @Override
    public Subject selectByPrimaryKey(Integer id) {
        Subject subject = subjectMapper.selectByPrimaryKey(id);
        subject.setOptions(optionMapper.selectBySubjectId(id));
        return subject;
    }
    @Override
    public int updateSubjectSelective(Subject record) {
        if (record.getOptions() != null){
            for (Option option : record.getOptions()){
                if (option.getId()==null){
                    option.setSubjectId(record.getId());
                    optionMapper.insertSelective(option);
                }else {
                    optionMapper.updateByPrimaryKeySelective(option);
                }

            }
        }
        return subjectMapper.updateByPrimaryKeySelective(record);
    }
}
