package com.powernode.spring6.bean;

import java.util.Date;

public class User {
    private String name; //简单类型
    private String password;
    private int age; //简单类型
    private Date date;
    private Class clazz;

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", clazz=" + clazz +
                '}';
    }
}
