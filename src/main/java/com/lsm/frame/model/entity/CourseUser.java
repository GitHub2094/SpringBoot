package com.lsm.frame.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseUser {
    private Integer id;

    private Integer courseId;

    private Integer userId;

    private Integer[] studentIds;


}