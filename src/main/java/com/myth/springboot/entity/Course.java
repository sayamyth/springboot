package com.myth.springboot.entity;

public class Course {
    private Integer co_id;
    private String co_name;

    public Integer getCo_id() {
        return co_id;
    }

    public void setCo_id(Integer co_id) {
        this.co_id = co_id;
    }

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }


    public Course(Integer co_id, String co_name) {
        this.co_id = co_id;
        this.co_name = co_name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "co_id=" + co_id +
                ", co_name='" + co_name + '\'' +
                '}';
    }
}
