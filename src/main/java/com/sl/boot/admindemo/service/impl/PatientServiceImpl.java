package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.PatientDAO;
import com.sl.boot.admindemo.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;


}
