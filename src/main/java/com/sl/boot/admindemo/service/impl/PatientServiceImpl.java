package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.PatientDAO;
import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.entity.PatientExample;
import com.sl.boot.admindemo.service.PatientService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Override
    public Patient queryOne(String patientName) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientNameEqualTo(patientName);
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        if (patients.size() != 0) {
            Patient patient = patients.get(0);
            return patient;
        }
        return new Patient();
    }

    @Override
    public List<Patient> queryAllPatient(Integer page, Integer limit, BaseResp baseResp) {
        Page<Patient> page1 = PageHelper.startPage(page, limit);
        PatientExample patientExample = new PatientExample();
        patientDAO.selectByExample(patientExample);
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }

    @Override
    public Integer updateOne(Patient patient) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andAnoNameEqualTo(patient.getAnoName());
        patientDAO.updateByExampleSelective(patient, patientExample);
        return null;
    }

    @Override
    public Integer addOne(Patient patient) {
        patient.setAddTime(new Date());
        return patientDAO.insert(patient);
    }
}
