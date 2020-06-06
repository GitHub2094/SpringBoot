package com.lsm.frame.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class CourseJob {
    private Integer id;

    private Integer courseId;

    private Integer jobId;

    private Date startTime;

    private Date endTime;


}