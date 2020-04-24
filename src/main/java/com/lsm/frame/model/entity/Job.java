package com.lsm.frame.model.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Job {

    @JSONField(name = "Id")
    private Integer id;

    @JSONField(name = "Title")
    private String title;

    private String createBy;

    private Date createTime;

}