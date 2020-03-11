package com.sl.boot.admindemo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author
 */
@Data
public class PwdUser implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 类型 1-管理员 2-药库管理员 3-医生 4-病患
     */
    private Integer userType;

    private static final long serialVersionUID = 1L;
}