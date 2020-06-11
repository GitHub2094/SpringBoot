package com.lsm.frame.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class SubjectAndOption {

    private  Subject subject;
    private List<Option> optionList;
}
