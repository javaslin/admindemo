package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.DrugDAO;
import com.sl.boot.admindemo.dao.PatientDAO;
import com.sl.boot.admindemo.dao.PrescriptionDAO;
import com.sl.boot.admindemo.entity.*;
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

    @Autowired
    private DrugDAO drugDAO;

    @Override
    public List<Prescription> queryAll(Integer page, Integer limit, BaseResp baseResp) {
        Page<Prescription> page1 = PageHelper.startPage(page, limit);
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionDAO.selectByExample(prescriptionExample);
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
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

    @Override
    public Long settle(Integer id) {
        Prescription prescription = prescriptionDAO.selectByPrimaryKey(id);
        String description = prescription.getDescription();
        String[] drugs = description.split(",");
        long total = 0;
        for (int i = 0; i < drugs.length; i++) {
            DrugExample drugExample = new DrugExample();
            String[] drugAndCount = drugs[i].split("x");
            drugExample.createCriteria().andDrugNameEqualTo(drugAndCount[0]);
            List<Drug> drugs1 = drugDAO.selectByExample(drugExample);
            if (drugs1.size() != 0) {
                Drug drug = drugs1.get(0);
                total += drug.getPrice() * Integer.parseInt(drugAndCount[1]);
            }
        }
        Prescription prescription1 = new Prescription();
        prescription1.setStatus("已取药");
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionExample.createCriteria().andIdEqualTo(id);
        prescriptionDAO.updateByExampleSelective(prescription1, prescriptionExample);
        return total;
    }
}
