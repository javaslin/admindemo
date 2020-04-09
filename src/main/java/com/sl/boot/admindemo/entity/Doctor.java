package com.sl.boot.admindemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 医生
 */
@Data
public class Doctor implements Serializable {
    private Integer id;

    private String doctorname;

    private Date inserttime;

    /**
     * 医生姓名
     */
    private String anoName;

    /**
     * 身份证号码
     */
    private String idCard;

    /**
     * 手机号码
     */
    private String phoneNum;

    /**
     * 科室
     */
    private String section;

    /**
     * 职称
     */
    private String tTitle;

    private static final long serialVersionUID = 1L;
}