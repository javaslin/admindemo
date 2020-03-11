package com.sl.boot.admindemo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author s4n
 * @since 2020-02-27 22:20:14
 */
public class User implements Serializable {
    private static final long serialVersionUID = 900301730436192269L;
    /**
     * 用户ID
     */
    private Integer uid;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer age;


    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}