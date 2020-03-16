package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.PatientDAO;
import com.sl.boot.admindemo.dao.PrescriptionDAO;
import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.entity.PatientExample;
import com.sl.boot.admindemo.entity.Prescription;
import com.sl.boot.admindemo.entity.PrescriptionExample;
import com.sl.boot.admindemo.service.PrescriptionService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Override
    public List<Prescription> queryAll() {
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        return prescriptionDAO.selectByExample(prescriptionExample);
    }

    @Override
    public Integer createOne(Prescription prescription) {
        return prescriptionDAO.insert(prescription);
    }

    @Override
    public Integer updateStatus(Integer id, String status) {
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionExample.createCriteria().andIdEqualTo(id);
        Prescription prescription = new Prescription();
        prescription.setStatus(status);
        return prescriptionDAO.updateByExampleSelective(prescription, prescriptionExample);
    }

    @Override
    public List<Prescription> getByPname(String patientName) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientNameEqualTo(patientName);
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        if (patients.size() != 0) {
            PrescriptionExample prescriptionExample = new PrescriptionExample();
            prescriptionExample.createCriteria().andBelongToPatientNameEqualTo(patients.get(0).getAnoName());
            return prescriptionDAO.selectByExample(prescriptionExample);
        }

        return new ArrayList<Prescription>();
    }

    @Override
    public Integer delOne(Integer id) {
        return prescriptionDAO.deleteByPrimaryKey(id);
    }
}
