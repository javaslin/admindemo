package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.service.DrugService;
import com.sl.boot.admindemo.vo.DrugVo;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private DrugService drugService;


    @PostMapping(value = "/add")
    public BaseResp addOneDrug(@RequestBody Drug drug) {

        return new BaseResp(drugService.addOneDrug(drug));
    }

    @GetMapping(value = "all")
    public BaseResp getAllDrug() {
        List<Drug> drugs = drugService.queryAllDrug();
        return new BaseResp(drugs.size(), drugs);
    }

    @DeleteMapping(value = "/del")
    public BaseResp delOneDrug(@RequestParam("id") Long id) {
        return new BaseResp(drugService.delOneDrug(id));
    }

    @PostMapping(value = "/incr")
    public BaseResp incrAmount(@RequestBody DrugVo drugVo) {
        return new BaseResp(drugService.incrDrugAmount(drugVo.getDrugName(), drugVo.getAmount()));
    }

    @PostMapping(value = "/desc")
    public BaseResp descAmount(@RequestBody DrugVo drugVo) {
        return new BaseResp(drugService.descrDrugAmount(drugVo.getDrugName(), drugVo.getAmount()));
    }

}
