package com.example.mybatisdemo.entity;

public class TblStudents {
    private Integer id;

    private String name;

    private String sax;

    private Integer age;

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
        this.name = name == null ? null : name.trim();
    }

    public String getSax() {
        return sax;
    }

    public void setSax(String sax) {
        this.sax = sax == null ? null : sax.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}