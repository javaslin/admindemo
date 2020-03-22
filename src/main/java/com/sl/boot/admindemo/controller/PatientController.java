package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.service.PatientService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;


    @GetMapping(value = "/all")
    public BaseResp getAllPatient(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {

        BaseResp baseResp = new BaseResp();
        List<Patient> patients = patientService.queryAllPatient(page, limit, baseResp);
        baseResp.setData(patients);
        return baseResp;
    }

    @GetMapping(value = "/getPatient")
    public BaseResp getOnePatient(@RequestParam(value = "username") String username) {

        return new BaseResp(patientService.queryOne(username));
    }

}
