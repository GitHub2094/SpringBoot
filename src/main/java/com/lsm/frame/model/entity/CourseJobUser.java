package com.lsm.frame.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lsm.frame.model.dto.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class CourseJobUser extends BaseEntity {
    private Integer id;

    private Integer courseJobId;

    private Integer userId;

    private String state;

    private Integer score;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date submitTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date reviewTime;

    private String reviewBy;

    private String studentName;

    private String loginName;


}