package com.sl.boot.admindemo.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author 药方
 */
@Data
public class Prescription implements Serializable {
    private Integer id;

    /**
     * 药方说明
     */
    private String description;

    /**
     * 药方状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;
}