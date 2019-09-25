package com.myth.springboot.entity;

public class Teacher {
    private Integer t_id;
    private String user_id;
    private String t_name;
    private String sex;
    private String dept_id;
    private Dept dept;

    //为layui添加字段
    private String dept_name;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Teacher() {
    }

    public Teacher(Integer t_id, String t_name, String sex, String dept_id) {
        this.t_id = t_id;
        this.t_name = t_name;
        this.sex = sex;
        this.dept_id = dept_id;
    }
}
