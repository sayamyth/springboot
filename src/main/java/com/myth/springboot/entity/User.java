package com.myth.springboot.entity;

public class User {
    private Integer id;
    private String name;
    private String password;
    private String type_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public User() {
    }

    public User(Integer id, String name, String password, String type_id) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type_id = type_id;
    }

    public User(String name, String password, String type_id) {
        this.name = name;
        this.password = password;
        this.type_id = type_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type_id='" + type_id + '\'' +
                '}';
    }
}
