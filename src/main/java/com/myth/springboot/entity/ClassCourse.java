package com.myth.springboot.entity;

public class ClassCourse {
    private Integer id;
    private String class_id;
    private String course_id;
    private Class cla;
    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public Class getCla() {
        return cla;
    }

    public void setCla(Class cla) {
        this.cla = cla;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public ClassCourse() {
    }

    public ClassCourse(Integer id, String class_id, String course_id) {
        this.id = id;
        this.class_id = class_id;
        this.course_id = course_id;
    }

}
