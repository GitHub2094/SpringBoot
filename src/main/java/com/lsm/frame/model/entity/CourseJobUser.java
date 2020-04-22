package com.lsm.frame.model.entity;

public class CourseJobUser {
    private Integer id;

    private Integer courseJobId;

    private Integer userId;

    private String state;

    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseJobId() {
        return courseJobId;
    }

    public void setCourseJobId(Integer courseJobId) {
        this.courseJobId = courseJobId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}