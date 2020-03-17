package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.Prescription;


import java.util.List;

public interface PrescriptionService {

    List<Prescription> queryAll();

    Integer createOne(Prescription prescription);

    Integer updateStatus(Integer id, String status);

    List<Prescription> getByPname(String patientName);

    Integer delOne(Integer id);

    Long settle(Integer id);
}
