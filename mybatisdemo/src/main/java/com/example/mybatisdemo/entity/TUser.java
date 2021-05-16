package com.example.mybatisdemo.entity;

import java.util.Date;

public class TUser {
    private Long id;

    private String username;

    private String passwd;

    private Date birth_day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Date getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(Date birth_day) {
        this.birth_day = birth_day;
    }
}