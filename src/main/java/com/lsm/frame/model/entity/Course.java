package com.lsm.frame.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lsm.frame.model.dto.BaseEntity;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Course extends BaseEntity {
    private Integer id;

    private String courseName;

    private Integer collegeId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    private String createBy;

    private String code;

    private String remark;


}