package com.lsm.frame.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.lsm.frame.model.dto.BaseEntity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)

@Builder
public class User extends BaseEntity implements Serializable {
    private Integer userId;

    private Integer deptId;

    private String loginName;

    private String userName;

    private String userType;

    private String email;

    private String phone;

    private String sex;

    private String avatar;

    private String password;

    private String salt;

    private String status;

    private String delFlag;

    private String loginIp;

    private Date loginDate;

    private String createBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String remark;

}