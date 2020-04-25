package com.lsm.frame.model.vo;


import com.lsm.frame.model.entity.CourseJobUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Jobs {

    private int jobId;

    private String jobTitle;

    private Date startTime;

    private Date endTime;

    private CourseJobUser courseJobUser;
}
