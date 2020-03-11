package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.*;
import com.sl.boot.admindemo.entity.*;
import com.sl.boot.admindemo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;

    @Autowired
    private PwdUserDAO pwdUserDAO;

    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private DrugAdminUserDAO drugAdminUserDAO;


    @Override
    public Integer addOneUser(String userName, String password, Integer type) {
        boolean isSuccess = false;
        Integer a = 1;
        if (type == 1) {
            AdminUser adminUser = new AdminUser();
            adminUser.setAddTime(new Date());
            adminUser.setName(userName);
            a = adminUserDAO.insert(adminUser);

        } else if (type == 2) {
            DrugAdminUser drugAdminUser = new DrugAdminUser();
            drugAdminUser.setDrugAdminUsername(userName);
            drugAdminUser.setInserttime(new Date());
            a = drugAdminUserDAO.insert(drugAdminUser);

        } else if (type == 3) {
            Doctor doctor = new Doctor();
            doctor.setDoctorname(userName);
            doctor.setInserttime(new Date());
            a = doctorDAO.insert(doctor);
        } else if (type == 4) {
            Patient patient = new Patient();
            patient.setAddTime(new Date());
            patient.setPatientName(userName);
            a = patientDAO.insert(patient);

        }
        PwdUser pwdUser = new PwdUser();
        pwdUser.setPassword(password);
        pwdUser.setUserName(userName);
        pwdUser.setUserType(type);

        Integer b = pwdUserDAO.insert(pwdUser);

        if (a == 0 & b == 0) {
            isSuccess = true;
        }
        return isSuccess ? 0 : 1;
    }

    @Override
    public Integer delUser(String userName, Integer type) {
        PwdUserExample pwdUserExample = new PwdUserExample();
        pwdUserExample.createCriteria().andUserNameEqualTo(userName);
        return pwdUserDAO.deleteByExample(pwdUserExample);
    }

    @Override
    public List<PwdUser> queryAllUser() {
        PwdUserExample pwdUserExample = new PwdUserExample();
        return pwdUserDAO.selectByExample(pwdUserExample);
    }
}
