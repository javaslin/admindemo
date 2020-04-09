package com.sl.boot.admindemo.controller;

import com.sl.boot.admindemo.entity.Doctor;
import com.sl.boot.admindemo.service.DoctorService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping(value = "/all")
    public BaseResp alldoctors(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<Doctor> doctors = doctorService.allDoctors(page, limit, baseResp);
        baseResp.setData(doctors);
        return baseResp;
    }

    @PostMapping(value = "/update")
    public BaseResp update(@RequestBody Doctor doctor) {
        return new BaseResp(doctorService.update(doctor));
    }

}
