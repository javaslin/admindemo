package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.PatientDAO;
import com.sl.boot.admindemo.dao.PrescriptionDAO;
import com.sl.boot.admindemo.dao.PwdUserDAO;
import com.sl.boot.admindemo.dto.PatientDTO;
import com.sl.boot.admindemo.entity.*;
import com.sl.boot.admindemo.service.PatientService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private PwdUserDAO pwdUserDAO;

    @Autowired
    private PrescriptionDAO prescriptionDAO;

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
    public List<PatientDTO> queryAllPatient(Integer page, Integer limit, BaseResp baseResp) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Page<Patient> page1 = PageHelper.startPage(page, limit);
        PatientExample patientExample = new PatientExample();
        patientDAO.selectByExample(patientExample);
        List<PatientDTO> patientDTOS = new ArrayList<>();
        patientDTOS = page1.getResult().stream().map(m -> {
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setAddTime(simpleDateFormat.format(m.getAddTime()));
            patientDTO.setAge(m.getAge());
            patientDTO.setAnoName(m.getAnoName());
            patientDTO.setDisease(m.getDisease());
            patientDTO.setGender(m.getGender());
            patientDTO.setId(m.getId());
            patientDTO.setIdCard(m.getIdCard());
            patientDTO.setMedicalId(m.getMedicalId());
            patientDTO.setPatientName(m.getPatientName());
            patientDTO.setPtype(m.getPtype());
            PrescriptionExample prescriptionExample = new PrescriptionExample();
            if (m.getAnoName() == null) {
                return patientDTO;
            }
            prescriptionExample.createCriteria().andBelongToPatientNameEqualTo(m.getPatientName());
            List<Prescription> prescriptions = prescriptionDAO.selectByExample(prescriptionExample);
            if (prescriptions.size() == 0) {
                patientDTO.setDescription("");
                patientDTO.setUsage("");
                patientDTO.setPreId(-1);
                patientDTO.setStatus("无");
            } else {
                for (Prescription prescription : prescriptions) {
                    if (prescription.getStatus().equals("未取药")) {
                        patientDTO.setDescription(prescription.getDescription());
                        patientDTO.setUsage(prescription.getUsage());
                        patientDTO.setStatus(prescription.getStatus());
                        patientDTO.setPreId(prescription.getId());
                        patientDTO.setDname(prescription.getBelongToDoctorName());
                        return patientDTO;
                    }
                }
                Prescription prescription = prescriptions.get(0);
                patientDTO.setDescription(prescription.getDescription());
                patientDTO.setUsage(prescription.getUsage());
                patientDTO.setStatus(prescription.getStatus());
                patientDTO.setPreId(prescription.getId());
                patientDTO.setDname(prescription.getBelongToDoctorName());
            }
            return patientDTO;
        }).collect(Collectors.toList());
        baseResp.setCount((int) page1.getTotal());
        return patientDTOS;
    }

    @Override
    public Integer updateOne(Patient patient, String patientName) {
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientNameEqualTo(patientName);
        patientDAO.updateByExampleSelective(patient, patientExample);
        return patientDAO.updateByExampleSelective(patient, patientExample);
    }

    @Override
    public Integer addOne(Patient patient) {
        PwdUser pwdUser = new PwdUser();
        pwdUser.setUserType(4);
        pwdUser.setUserName(patient.getPatientName());
        pwdUser.setPassword(patient.getPassword());
        patient.setAddTime(new Date());
        PatientExample patientExample = new PatientExample();
        patientExample.createCriteria().andPatientNameEqualTo(patient.getPatientName());
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        if (patients.size() != 0) {
            return -1;
        } else {
            pwdUserDAO.insert(pwdUser);
            return patientDAO.insert(patient);
        }

    }

    @Override
    public List<PatientDTO> search(String patientName) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        PatientExample patientExample = new PatientExample();
        StringBuffer sb = new StringBuffer(patientName);
        sb.insert(0, '%');
        sb.append('%');
        patientExample.createCriteria().andAnoNameLike(sb.toString());
        List<Patient> patients = patientDAO.selectByExample(patientExample);
        List<PatientDTO> patientDTOS = new ArrayList<>();
        patientDTOS = patients.stream().map(m -> {
            PatientDTO patientDTO = new PatientDTO();
            patientDTO.setAddTime(simpleDateFormat.format(m.getAddTime()));
            patientDTO.setAge(m.getAge());
            patientDTO.setAnoName(m.getAnoName());
            patientDTO.setDisease(m.getDisease());
            patientDTO.setGender(m.getGender());
            patientDTO.setId(m.getId());
            patientDTO.setIdCard(m.getIdCard());
            patientDTO.setMedicalId(m.getMedicalId());
            patientDTO.setPatientName(m.getPatientName());
            PrescriptionExample prescriptionExample = new PrescriptionExample();
            prescriptionExample.createCriteria().andBelongToPatientNameEqualTo(m.getPatientName());
            List<Prescription> prescriptions = prescriptionDAO.selectByExample(prescriptionExample);
            if (prescriptions.size() == 0) {
                patientDTO.setDescription("");
                patientDTO.setUsage("");
                patientDTO.setPreId(-1);
                patientDTO.setStatus("无");
            } else {
                Prescription prescription = prescriptions.get(0);
                patientDTO.setDescription(prescription.getDescription());
                patientDTO.setUsage(prescription.getUsage());
                patientDTO.setStatus(prescription.getStatus());
                patientDTO.setPreId(prescription.getId());
                patientDTO.setDname(prescription.getBelongToDoctorName());
            }
            return patientDTO;
        }).collect(Collectors.toList());
        return patientDTOS;

    }
}
