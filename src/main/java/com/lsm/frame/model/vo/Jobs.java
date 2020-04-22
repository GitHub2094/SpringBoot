package com.lsm.frame.model.vo;


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

    private String statu;

    private int score;
}
