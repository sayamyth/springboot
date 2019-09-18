package com.myth.springboot.entity;

public class Student {
    private Integer s_id;
    private String user_id;
    private String s_name;
    private String sex;
    private String class_id;
    private String dept_id;
    private Class cla;
    private Dept dept;

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public Class getCla() {
        return cla;
    }

    public void setCla(Class cla) {
        this.cla = cla;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }


    public Student() {
    }

    public Student(Integer s_id, String user_id, String s_name, String sex, String class_id, String dept_id) {
        this.s_id = s_id;
        this.user_id = user_id;
        this.s_name = s_name;
        this.sex = sex;
        this.class_id = class_id;
        this.dept_id = dept_id;
    }

    public Student(Integer s_id, String s_name, String sex, String class_id, String dept_id) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.sex = sex;
        this.class_id = class_id;
        this.dept_id = dept_id;
    }
}
