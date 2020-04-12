package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.dto.PatientDTO;
import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.vo.resp.BaseResp;

import java.util.List;

public interface PatientService {

    Patient queryOne(String patientName);

    List<PatientDTO> queryAllPatient(Integer page, Integer limit, BaseResp baseResp);

    Integer updateOne(Patient patient, String patientName);

    Integer addOne(Patient patient);

    List<PatientDTO> search(String patientName);

}
