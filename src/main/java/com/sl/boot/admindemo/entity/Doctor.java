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

    private static final long serialVersionUID = 1L;
}