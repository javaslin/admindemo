package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author
 */
@Data
public class Patient implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String patientName;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 密码
     */
    private String password;

    /**
     * 患病
     */
    private String disease;

    /**
     * 年龄
     */
    private String age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 药方ID
     */
    private Integer method;

    /**
     * 属于哪个医生
     */
    private Long belongToDoctorId;

    /**
     * 患者真实姓名
     */
    private String anoName;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 医疗卡号
     */
    private String medicalId;

    /**
     * 住院或门诊
     */
    private String ptype;

    private static final long serialVersionUID = 1L;
}