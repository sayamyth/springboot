package com.myth.springboot.entity;

public class Teaching {
    private Integer te_id;
    private String class_name;
    private String dept_name;
    private String teacher_name;
    private String course_name;

    public Integer getTe_id() {
        return te_id;
    }

    public void setTe_id(Integer te_id) {
        this.te_id = te_id;
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

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Teaching() {
    }

    public Teaching(String class_name, String dept_name, String teacher_name, String course_name) {
        this.class_name = class_name;
        this.dept_name = dept_name;
        this.teacher_name = teacher_name;
        this.course_name = course_name;
    }
}
