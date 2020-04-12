package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.DoctorDAO;
import com.sl.boot.admindemo.entity.Doctor;
import com.sl.boot.admindemo.entity.DoctorExample;
import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.service.DoctorService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    private DoctorDAO doctorDAO;


    @Override
    public List<Doctor> allDoctors(Integer page, Integer limit, BaseResp baseResp) {
        Page<Doctor> page1 = PageHelper.startPage(page, limit);
        DoctorExample doctorExample = new DoctorExample();
        doctorDAO.selectByExample(doctorExample);
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }

    @Override
    public Integer update(Doctor doctor) {
        Doctor doctor1 = new Doctor();
        doctor1.setAnoName(doctor.getAnoName());
        doctor1.setIdCard(doctor.getIdCard());
        doctor1.setPhoneNum(doctor.getPhoneNum());
        doctor1.setSection(doctor.getSection());
        doctor1.setTTitle(doctor.getTTitle());
        DoctorExample doctorExample = new DoctorExample();
        doctorExample.createCriteria().andIdEqualTo(doctor.getId());
        return doctorDAO.updateByExampleSelective(doctor1, doctorExample);
    }
}
