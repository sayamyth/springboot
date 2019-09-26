package com.myth.springboot.entity;

public class Class {
    private Integer c_id;
    private String c_name;
    private String dept_id;

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public Class() {
    }

    public Class(Integer c_id) {
        this.c_id = c_id;
    }

    public Class(Integer c_id, String c_name) {
        this.c_id = c_id;
        this.c_name = c_name;
    }

    public Class(Integer c_id, String c_name, String dept_id) {
        this.c_id = c_id;
        this.c_name = c_name;
        this.dept_id = dept_id;
    }
}
