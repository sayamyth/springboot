package com.myth.springboot.entity;

public class Mark {
    private Integer id;
    private String te_id;
    private String user_id;
    private String point;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTe_id() {
        return te_id;
    }

    public void setTe_id(String te_id) {
        this.te_id = te_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
