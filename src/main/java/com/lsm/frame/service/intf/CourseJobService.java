package com.lsm.frame.service.intf;

import com.lsm.frame.model.entity.*;
import com.lsm.frame.model.vo.Jobs;

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

    Course selectCourseByCourseId(Integer id);

    List<Job> selectJobList(Job job);

}
