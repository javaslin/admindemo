package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 操作记录
 */
@Data
public class ActionRecord implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 药品ID
     */
    private Long drugId;

    /**
     * 药品名称
     */
    private String drugName;

    /**
     * 操作
     */
    private String action;

    /**
     * 操作时间
     */
    private Date actionTime;

    /**
     * 操作数量
     */
    private Integer amount;

    private static final long serialVersionUID = 1L;
}