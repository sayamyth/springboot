package com.myth.springboot.entity;

public class Dept {
    private Integer d_id;
    private String d_name;


    public Integer getD_id() {
        return d_id;
    }

    public void setD_id(Integer d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }


    public Dept(Integer d_id, String d_name) {
        this.d_id = d_id;
        this.d_name = d_name;
    }


    @Override
    public String toString() {
        return "Dept{" +
                "d_id=" + d_id +
                ", d_name='" + d_name + '\'' +
                '}';
    }
}
