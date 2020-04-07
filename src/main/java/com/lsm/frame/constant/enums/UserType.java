package com.lsm.frame.constant.enums;

public enum UserType implements RoleOperation{
    /**
     * 跳转
     */
    STUDENT{
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
