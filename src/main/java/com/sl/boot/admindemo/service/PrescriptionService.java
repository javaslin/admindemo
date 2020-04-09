package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.Prescription;
import com.sl.boot.admindemo.vo.resp.BaseResp;


import java.util.List;

public interface PrescriptionService {

    List<Prescription> queryAll(Integer page, Integer limit, BaseResp baseResp);

    Integer createOne(Prescription prescription, String doctorName);

    Integer update(Prescription prescription);

    List<Prescription> getByPname(String patientName);

    Integer delOne(Integer id);

    Integer settle(Integer id);
}
