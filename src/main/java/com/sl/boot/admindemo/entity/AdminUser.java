package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author
 */
@Data
public class AdminUser implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String name;

    /**
     * 添加时间
     */
    private Date addTime;

    private static final long serialVersionUID = 1L;
}