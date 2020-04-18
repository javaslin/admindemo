package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.*;
import com.sl.boot.admindemo.entity.*;
import com.sl.boot.admindemo.service.PrescriptionService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private DrugDAO drugDAO;
    @Autowired
    private ActionRecordDAO actionRecordDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    @Override
    public List<Prescription> queryAll(Integer page, Integer limit, BaseResp baseResp) {
        Page<Prescription> page1 = PageHelper.startPage(page, limit);
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionDAO.selectByExample(prescriptionExample);
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }

    @Override
    public Integer createOne(Prescription prescription, String doctorName) {
        PatientExample patientExample = new PatientExample();
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andDoctornameEqualTo(doctorName);
        List<Doctor> doctors = doctorDAO.selectByExample(doctorExample);
        if (doctors.size() != 0) {
            Doctor doctor = doctors.get(0);
            prescription.setBelongToDoctorName(doctor.getAnoName());
            prescription.setDid(doctor.getId());
            prescription.setStatus("未取药");
        } else {
            return -4;
        }
        List<String> paNs = new ArrayList<>();
        for (Patient p : patients) {
            paNs.add(p.getPatientName());
        }
        String[] split = prescription.getDescription().split(",");
        List<String> objects = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < split.length; i++) {
            objects.add(split[i].split("x")[0]);
            if (Integer.parseInt(split[i].split("x")[1]) > 10) {
                flag = true;
            }
        }
        for (String s :
                objects) {
            System.out.println(s);
        }
        DrugExample drugExample = new DrugExample();
        drugExample.createCriteria().andDrugNameIn(objects);
        List<Drug> drugs = drugDAO.selectByExample(drugExample);
        System.out.println("drugs Size" + drugs.size());
        if (!paNs.contains(prescription.getBelongToPatientName())) {
            return -1;
        }
        if (drugs.size() == 0) {
            return -2;
        }
        if (flag) {
            return -3;
        } else {
            return prescriptionDAO.insert(prescription);
        }

    }

    @Override
    public Integer update(Prescription prescription) {
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionExample.createCriteria().andIdEqualTo(prescription.getId());
        return prescriptionDAO.updateByExampleSelective(prescription, prescriptionExample);
    }

    @Override
    public List<Prescription> getByPname(String patientName) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientNameEqualTo(patientName);
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        if (patients.size() != 0) {
            if (patients.get(0).getAnoName() == null) {
                return new ArrayList<Prescription>();
            }
            PrescriptionExample prescriptionExample = new PrescriptionExample();
            prescriptionExample.createCriteria().andBelongToPatientNameEqualTo(patients.get(0).getPatientName());
            return prescriptionDAO.selectByExample(prescriptionExample);
        } else {
            return new ArrayList<Prescription>();
        }

    }

    @Override
    public Integer delOne(Integer id) {
        return prescriptionDAO.deleteByPrimaryKey(id);
    }

    @Override
    public Integer settle(Integer id) {
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
            Drug drug = new Drug();
            DrugExample drugExample1 = new DrugExample();
            drugExample1.createCriteria().andDrugNameEqualTo(drugAndCount[0]);
            List<Drug> drugs2 = drugDAO.selectByExample(drugExample1);
            if (drugs2.size() != 0) {
                Drug drug1 = drugs2.get(0);
                drug1.setId(null);
                System.out.println("=================drugAndCount[1]=====" + drugAndCount[1]);
                Long count = drug1.getDrugCount() - Integer.parseInt(drugAndCount[1]);
                System.out.println("=================count=====" + count);
                if (count < 0) {
                    return -1;
                }
                drug1.setDrugCount(count);
                ActionRecord actionRecord = new ActionRecord();
                actionRecord.setAction("出库药品");
                actionRecord.setDrugName(drugAndCount[0]);
                actionRecord.setActionTime(new Date());
                actionRecord.setAmount(Integer.parseInt(drugAndCount[1]));
                actionRecordDAO.insert(actionRecord);
                drugDAO.updateByExampleSelective(drug1, drugExample1);
            }
        }
        Prescription prescription1 = new Prescription();
        prescription1.setStatus("已取药");
        PrescriptionExample prescriptionExample = new PrescriptionExample();
        prescriptionExample.createCriteria().andIdEqualTo(id);
        prescriptionDAO.updateByExampleSelective(prescription1, prescriptionExample);
        return Math.toIntExact(total);
    }
}
