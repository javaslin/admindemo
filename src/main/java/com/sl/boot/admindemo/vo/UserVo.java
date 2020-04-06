package com.sl.boot.admindemo.vo;


import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVo {

    private Integer id;

    private String userName;

    private String passWord;

    private Integer type;
}
