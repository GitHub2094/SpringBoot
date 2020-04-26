package com.lsm.frame.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class Subject {
    private Integer id;

    private String type;

    private String stem;

    private Integer courseId;

    private Integer score;

    private String analysis;


}