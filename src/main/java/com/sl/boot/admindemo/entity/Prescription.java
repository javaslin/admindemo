package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;
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
     * 用法
     */
    private String usage;

    /**
     * 药方状态
     */
    private String status;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 属于哪个患者
     */
    private String belongToPatientName;

    /**
     * 开局药方的医生的姓名
     */
    private String belongToDoctorName;

    /**
     * 医生ID
     */
    private Integer did;

    private static final long serialVersionUID = 1L;
}