package com.sl.boot.admindemo.dto;

import lombok.Data;

@Data
public class UserDTO {
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
    private String userType;
}
