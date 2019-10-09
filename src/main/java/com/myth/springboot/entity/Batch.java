package com.myth.springboot.entity;

public class Batch {
    private Integer b_id;
    private String b_name;
    private String b_type;


    public Integer getB_id() {
        return b_id;
    }

    public void setB_id(Integer b_id) {
        this.b_id = b_id;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_type() {
        return b_type;
    }

    public void setB_type(String b_type) {
        this.b_type = b_type;
    }

    public Batch() {
    }

    public Batch(Integer b_id) {
        this.b_id = b_id;
    }

    public Batch(String b_type) {
        this.b_type = b_type;
    }

    public Batch(String b_name, String b_type) {
        this.b_name = b_name;
        this.b_type = b_type;
    }

    public Batch(Integer b_id, String b_name) {
        this.b_id = b_id;
        this.b_name = b_name;
    }

    public Batch(Integer b_id, String b_name, String b_type) {
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_type = b_type;
    }
}
