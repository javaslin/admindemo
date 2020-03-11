package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * @author 药品
 */
@Data
public class Drug implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 药品数量
     */
    private Long drugCount;

    /**
     * 生产厂家
     */
    private String factory;

    /**
     * 价格
     */
    private Long price;

    /**
     * 生产日期
     */
    private Date productionTime;

    /**
     * 药品功能
     */
    private String drugFunction;

    /**
     * 药品规格
     */
    private String size;

    private static final long serialVersionUID = 1L;
}