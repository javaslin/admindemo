package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.dto.PatientDTO;
import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.service.PatientService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {


    @Autowired
    private PatientService patientService;


    @GetMapping(value = "/all")
    public BaseResp getAllPatient(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {

        BaseResp baseResp = new BaseResp();
        List<PatientDTO> patients = patientService.queryAllPatient(page, limit, baseResp);
        baseResp.setData(patients);
        return baseResp;
    }

    @GetMapping(value = "/getPatient")
    public BaseResp getOnePatient(@RequestParam(value = "username") String username) {

        return new BaseResp(patientService.queryOne(username));
    }

    @PostMapping(value = "update")
    public BaseResp update(@RequestBody Patient patient, @RequestParam(value = "patientName") String patientName) {
        return new BaseResp(patientService.updateOne(patient, patientName));
    }

    @PostMapping(value = "add")
    public BaseResp add(@RequestBody Patient patient) {
        return new BaseResp(patientService.addOne(patient));
    }

    @GetMapping(value = "/search")
    public BaseResp search(@RequestParam(value = "patientName") String patientName) {
        return new BaseResp(patientService.search(patientName));
    }

}
