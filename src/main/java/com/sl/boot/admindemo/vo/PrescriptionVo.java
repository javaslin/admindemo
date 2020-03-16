package com.sl.boot.admindemo.vo;

import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode
@ToString
public class PrescriptionVo {

    private Integer id;

    private String stauts;
}
