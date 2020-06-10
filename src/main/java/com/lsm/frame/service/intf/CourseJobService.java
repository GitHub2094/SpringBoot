package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.*;
import com.lsm.frame.model.vo.Jobs;
import com.lsm.frame.model.vo.StudentJob;

import java.util.List;

public interface CourseJobService {
    /**
     *
     * @param id
     * @return
     */
    List<CourseJob> selectCourseJobByCourseId(Integer id);

    /**
     *
     * @param id
     * @return
     */
    Job selectJobByJobId(Integer id);

    /**
     *
     */
    CourseJobUser selectCJUByCJidAndUid(Integer cjId,Integer userId);

    List<Jobs> listJobsByCourseIdAndUserId(Integer id,Integer userId);

    List<Jobs> listJobsByCourseIdAndTeacherId(Integer id,Integer userId);

    Course selectCourseByCourseId(Integer id);

    List<Job> selectJobList(Job job);


    int deleteJobByIds(String ids);

    /**
     *  向作业库添加作业
     */
    int insertSelective(Job record);

    /**
     * 作业数据更新
     */

    int updateByPrimaryKeySelective(Job record);

    /**
     * 查找作业
     */
    Job selectJob(Job record);

    /**
     * 通过作业id查找作业
     */
    Job selectJobByPrimaryKey(Integer id);

    /**
     *
     */
    List<CourseJobUser> getList(CourseJobUser courseJobUser);
    /**
     * 用课程id和作业id查询课程i作业d
     */
    CourseJob selectCourseJobByCourseIdAndJobId(Integer courseId,Integer jobId);

    int updateByPrimaryKeySelective(CourseJobUser record);

    /**
     * 灵活插入信息CourseJob
     */
    int insertSelective(CourseJob record);
}
