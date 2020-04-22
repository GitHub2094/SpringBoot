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
public class Course {
    private Integer id;

    private String courseName;

    private Integer collegeId;

    private Date startTime;

    private Date endTime;

    private String createBy;

    private String code;

    private String remark;


}