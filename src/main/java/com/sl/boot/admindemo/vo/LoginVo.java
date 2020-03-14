package com.sl.boot.admindemo.vo;


import lombok.Data;

@Data
public class LoginVo {
    private String username;
    private String password;
    private String role;
}
