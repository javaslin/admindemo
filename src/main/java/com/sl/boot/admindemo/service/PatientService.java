package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.Patient;

import java.util.List;

public interface PatientService {

    Patient queryOne(String patientName);

    List<Patient> queryAllPatient();
}
