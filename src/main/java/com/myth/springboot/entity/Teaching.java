package com.myth.springboot.entity;

public class Teaching {
    private Integer te_id;
    private String batch_id;
    private String batch_name;
    private String class_id;
    private String class_name;
    private String dept_id;
    private String dept_name;
    private String teacher_id;
    private String teacher_name;
    private String course_id;
    private String course_name;
    private String mark;
    private String is_end;

    public String getIs_end() {
        return is_end;
    }

    public void setIs_end(String is_end) {
        this.is_end = is_end;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public Integer getTe_id() {
        return te_id;
    }

    public void setTe_id(Integer te_id) {
        this.te_id = te_id;
    }

    public String getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(String batch_id) {
        this.batch_id = batch_id;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getDept_id() {
        return dept_id;
    }

    public void setDept_id(String dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }



    public Teaching() {
    }

    public Teaching(Integer te_id) {
        this.te_id = te_id;
    }

    public Teaching(String class_name) {
        this.class_name = class_name;
    }

    public Teaching(String batch_id, String batch_name, String class_id, String class_name, String dept_id, String dept_name, String teacher_id, String teacher_name, String course_id, String course_name) {
        this.batch_id = batch_id;
        this.batch_name = batch_name;
        this.class_id = class_id;
        this.class_name = class_name;
        this.dept_id = dept_id;
        this.dept_name = dept_name;
        this.teacher_id = teacher_id;
        this.teacher_name = teacher_name;
        this.course_id = course_id;
        this.course_name = course_name;
    }
}
