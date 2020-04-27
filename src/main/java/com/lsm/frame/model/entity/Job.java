package com.lsm.frame.model.entity;

import com.lsm.frame.model.dto.BaseEntity;
import lombok.*;

import java.util.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job extends BaseEntity {

    private Integer id;

    private String title;


}