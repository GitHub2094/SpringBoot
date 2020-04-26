package com.lsm.frame.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class UserReply {
    private Integer id;

    private Integer cjuId;

    private Integer subject;

    private String reply;

    private Integer score;

    private String remarks;

    private Subject subjectModel;

}