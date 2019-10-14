package com.myth.springboot.entity;

public class Student {
    private Integer s_id;
    private String user_id;
    private String s_name;
    private String sex;
    private String class_id;
    private Class cla;


    //为匹配layui设计两个字段
    private String class_name;
    private String dept_name;
    private String user_name;

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

    public Class getCla() {
        return cla;
    }

    public void setCla(Class cla) {
        this.cla = cla;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Student() {
    }


    public Student(String user_name) {
        this.user_name = user_name;
    }

    public Student(Integer s_id, String s_name, String sex, String class_id) {
        this.s_id = s_id;
        this.s_name = s_name;
        this.sex = sex;
        this.class_id = class_id;
    }

    public Student(String user_name, String s_name, String sex, String class_id) {
        this.user_id = user_name;
        this.s_name = s_name;
        this.sex = sex;
        this.class_id = class_id;
    }
}
