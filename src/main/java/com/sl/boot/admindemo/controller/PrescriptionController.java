package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.entity.Prescription;
import com.sl.boot.admindemo.service.PrescriptionService;
import com.sl.boot.admindemo.vo.PrescriptionVo;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/allPre")
    public BaseResp getAll(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<Prescription> prescriptions = prescriptionService.queryAll(page, limit, baseResp);
        baseResp.setData(prescriptions);
        return baseResp;
    }

    @GetMapping("/patients")
    public BaseResp getByPatientName(@RequestParam(value = "patientname") String patientName) {

        return new BaseResp(prescriptionService.getByPname(patientName));
    }

    @PostMapping("/create")
    public BaseResp createOne(@RequestBody Prescription prescription) {
        return new BaseResp(prescriptionService.createOne(prescription));
    }

    @PostMapping("/update")
    public BaseResp updateStatus(@RequestBody PrescriptionVo prescriptionVo) {
        return new BaseResp(prescriptionService.updateStatus(prescriptionVo.getId(), prescriptionVo.getStauts()));
    }

    @PostMapping("/delete")
    public BaseResp deletePre(@RequestBody PrescriptionVo prescriptionVo) {
        return new BaseResp(prescriptionService.delOne(prescriptionVo.getId()));
    }

    @PostMapping("/settle")
    public BaseResp settle(@RequestBody PrescriptionVo prescriptionVo) {
        return new BaseResp(prescriptionService.settle(prescriptionVo.getId()));
    }


}
