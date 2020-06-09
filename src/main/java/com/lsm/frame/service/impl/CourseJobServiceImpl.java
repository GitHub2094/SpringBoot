package com.lsm.frame.service.impl;

import com.lsm.frame.mapper.CourseJobMapper;
import com.lsm.frame.mapper.CourseJobUserMapper;
import com.lsm.frame.mapper.CourseMapper;
import com.lsm.frame.mapper.JobMapper;
import com.lsm.frame.model.entity.Course;
import com.lsm.frame.model.entity.CourseJob;
import com.lsm.frame.model.entity.CourseJobUser;
import com.lsm.frame.model.entity.Job;
import com.lsm.frame.model.vo.Jobs;
import com.lsm.frame.model.vo.StudentJob;
import com.lsm.frame.service.intf.CourseJobService;
import com.lsm.frame.utils.string.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseJobServiceImpl implements CourseJobService {

    @Autowired
    CourseJobMapper courseJobMapper;

    @Autowired
    JobMapper jobMapper;

    @Autowired
    CourseJobUserMapper courseJobUserMapper;

    @Autowired
    CourseMapper courseMapper;

    @Override
    public List<CourseJob> selectCourseJobByCourseId(Integer id) {
        return courseJobMapper.selectByCourseId(id);
    }

    @Override
    public Job selectJobByJobId(Integer id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public CourseJobUser selectCJUByCJidAndUid(Integer cjId, Integer userId) {
        return courseJobUserMapper.selectCjuBycju(cjId,userId);
    }

    @Override
    public List<Jobs> listJobsByCourseIdAndUserId(Integer id,Integer userId) {
        List<CourseJob> courseJobList = courseJobMapper.selectByCourseId(id);
        List<Jobs> jobsList = new ArrayList<Jobs>();
        for (CourseJob courseJob : courseJobList){
            Jobs jobs = new Jobs();
            jobs.setJobId(courseJob.getJobId());
            jobs.setJobTitle(jobMapper.selectByPrimaryKey(courseJob.getJobId()).getTitle());
            jobs.setStartTime(courseJob.getStartTime());
            jobs.setEndTime(courseJob.getEndTime());
            CourseJobUser courseJobUser = courseJobUserMapper.selectCjuBycju(courseJob.getId(),userId);
            jobs.setCourseJobUser(courseJobUser);
            jobsList.add(jobs);
        }
        return jobsList;
    }

    @Override
    public Course selectCourseByCourseId(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Job> selectJobList(Job job) {
        return jobMapper.selectJobList(job);
    }

    @Override
    public int deleteJobByIds(String ids) {
        Integer[] jobIds = Convert.toIntArray(ids);
        return jobMapper.deleteJobByIds(jobIds);
    }

    @Override
    public int insertSelective(Job record) {
        return jobMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelective(Job record) {
        return jobMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Job selectJob(Job record) {
        return jobMapper.selectJob(record);
    }

    @Override
    public Job selectJobByPrimaryKey(Integer id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<CourseJobUser> getList(CourseJobUser courseJobUser) {
        return courseJobUserMapper.getList(courseJobUser);
    }

    @Override
    public CourseJob selectCourseJobByCourseIdAndJobId(Integer courseId, Integer jobId) {
        return courseJobMapper.selectCourseJobByCourseIdAndJobId(courseId,jobId);
    }

    @Override
    public int updateByPrimaryKeySelective(CourseJobUser record) {
        return courseJobUserMapper.updateByPrimaryKeySelective(record);
    }
}
