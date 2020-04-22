package com.lsm.frame.constant.enums;

import org.apache.catalina.Role;

public enum JobStatus implements RoleOperation {
    /**
     * 跳转
     */
    未完成{
        @Override
        public String op(){
            return "redirect:/student";
        }
    },
    /**
     * 00
     */
    TEACHER{
        @Override
        public String op(){
            return "redirect:/teacher";
        }
    },
    /**
     * 00
     */
    ROOT{
        @Override
        public String op(){
            return "redirect:/index";
        }
    },

}
