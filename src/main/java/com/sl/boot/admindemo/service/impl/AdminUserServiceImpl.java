package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.*;
import com.sl.boot.admindemo.dto.UserDTO;
import com.sl.boot.admindemo.entity.*;
import com.sl.boot.admindemo.service.AdminUserService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        if (type == 3) {
            DoctorExample doctorExample = new DoctorExample();
            doctorExample.createCriteria().andDoctornameEqualTo(userName);
            doctorDAO.deleteByExample(doctorExample);
        } else if (type == 2) {
            DrugAdminUserExample drugAdminUserExample = new DrugAdminUserExample();
            drugAdminUserExample.createCriteria().andDrugAdminUsernameEqualTo(userName);
            drugAdminUserDAO.deleteByExample(drugAdminUserExample);
        } else if (type == 4) {
            PatientExample patientExample = new PatientExample();
            patientExample.createCriteria().andPatientNameEqualTo(userName);
            patientDAO.deleteByExample(patientExample);
        }
        return pwdUserDAO.deleteByExample(pwdUserExample);
    }

    @Override
    public List<UserDTO> queryAllUser(Integer page, Integer limit, BaseResp baseResp) {
        PwdUserExample pwdUserExample = new PwdUserExample();
        Page<PwdUser> page1 = PageHelper.startPage(page, limit);
        pwdUserDAO.selectByExample(pwdUserExample);
        List<UserDTO> userDTOs = new ArrayList<>();
        userDTOs = page1.getResult().stream().map(m -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(m.getId());
            userDTO.setPassword(m.getPassword());
            userDTO.setUserName(m.getUserName());
            if (m.getUserType() == 1) {
                userDTO.setUserType("管理员");
            } else if (m.getUserType() == 2) {
                userDTO.setUserType("药房管理员");
            } else if (m.getUserType() == 3) {
                userDTO.setUserType("医生");
            } else {
                userDTO.setUserType("病患");
            }
            return userDTO;
        }).collect(Collectors.toList());

        for (int i = 0; i < userDTOs.size(); i++) {
            UserDTO userDTO = userDTOs.get(i);
            if (userDTO.getUserType().equals("管理员")) {
                userDTOs.remove(i);
            }
        }

        baseResp.setCount((int) page1.getTotal());
        return userDTOs;
    }

    @Override
    public Integer updateOne(Integer id, String userName, String password, Integer type) {
        PwdUser pwdUser = pwdUserDAO.selectByPrimaryKey(id);
        boolean isSuccess = false;
        Integer a = 1;
        if (type == 1) {
            AdminUser adminUser = new AdminUser();
            adminUser.setAddTime(new Date());
            adminUser.setName(userName);
            AdminUserExample adminUser1 = new AdminUserExample();
            adminUser1.createCriteria().andNameEqualTo(pwdUser.getUserName());
            a = adminUserDAO.updateByExampleSelective(adminUser, adminUser1);

        } else if (type == 2) {
            DrugAdminUser drugAdminUser = new DrugAdminUser();
            drugAdminUser.setDrugAdminUsername(userName);
            DrugAdminUserExample drugAdminUserExample = new DrugAdminUserExample();
            drugAdminUserExample.createCriteria().andDrugAdminUsernameEqualTo(pwdUser.getUserName());
            a = drugAdminUserDAO.updateByExampleSelective(drugAdminUser, drugAdminUserExample);
        } else if (type == 3) {
            Doctor doctor = new Doctor();
            doctor.setDoctorname(userName);
            DoctorExample doctorExample = new DoctorExample();
            doctorExample.createCriteria().andAnoNameEqualTo(pwdUser.getUserName());
            a = doctorDAO.updateByExampleSelective(doctor, doctorExample);
        } else if (type == 4) {
            Patient patient = new Patient();
            patient.setPatientName(userName);
            PatientExample patientExample = new PatientExample();
            patientExample.createCriteria().andPatientNameEqualTo(pwdUser.getUserName());
            a = patientDAO.updateByExampleSelective(patient, patientExample);

        }
        PwdUser pwdUser1 = new PwdUser();
        pwdUser1.setPassword(password);
        pwdUser1.setUserName(userName);
        PwdUserExample pwdUserExample = new PwdUserExample();
        pwdUserExample.createCriteria().andIdEqualTo(id);
        Integer b = pwdUserDAO.updateByExampleSelective(pwdUser1, pwdUserExample);

        if (a == 0 & b == 0) {
            isSuccess = true;
        }
        return isSuccess ? 0 : 1;
    }
}
