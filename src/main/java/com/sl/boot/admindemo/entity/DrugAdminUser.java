package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author 药库管理员
 */
@Data
public class DrugAdminUser implements Serializable {
    private Integer id;

    /**
     * 账号
     */
    private String drugAdminUsername;

    /**
     * 添加时间
     */
    private Date inserttime;

    private static final long serialVersionUID = 1L;
}