package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.PatientDAO;
import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.entity.PatientExample;
import com.sl.boot.admindemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Override
    public Patient queryOne(String patientName) {
        return null;
    }

    @Override
    public List<Patient> queryAllPatient() {
        PatientExample patientExample = new PatientExample();
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        return patients;
    }
}
