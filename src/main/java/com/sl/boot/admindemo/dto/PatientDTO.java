package com.sl.boot.admindemo.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@EqualsAndHashCode
public class PatientDTO {
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
    private String addTime;

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

    private String description;
    private String usage;

    private Integer preId;

    private String status;

    private String dname;

    private String ptype;
}
