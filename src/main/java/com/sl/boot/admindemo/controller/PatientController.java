package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.service.PatientService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;


    @GetMapping(value = "/all")
    public BaseResp getAllPatient() {

        return new BaseResp(patientService.queryAllPatient());
    }

}
