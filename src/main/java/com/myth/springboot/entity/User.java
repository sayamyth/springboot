package com.myth.springboot.entity;

public class User {
    private Integer u_id;
    private String u_name;
    private String u_password;
    private String type_id;
    private Type type;
    private String type_name;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }


//

    public User() {
    }

    //

//    public User(Integer u_id) {
//        this.u_id = u_id;
//    }

    public User(String u_name) {
        this.u_name = u_name;
    }

    public User(Integer u_id, String u_name, String u_password, String type_id) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_password = u_password;
        this.type_id = type_id;
    }

    public User(String u_name, String u_password, String type_id) {
        this.u_name = u_name;
        this.u_password = u_password;
        this.type_id = type_id;
    }
}
