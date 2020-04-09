package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.service.DrugService;
import com.sl.boot.admindemo.vo.DrugVo;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import com.sl.boot.admindemo.vo.resp.StaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
    public BaseResp getAllDrug(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<Drug> drugs = drugService.queryAllDrug(page, limit, baseResp);
        baseResp.setData(drugs);
        return baseResp;
    }

    @PostMapping(value = "/del")
    public BaseResp delOneDrug(@RequestBody HashMap<String, String> map) {
        return new BaseResp(drugService.delOneDrug(Long.parseLong(map.get("id"))));
    }

    @PostMapping(value = "/incr")
    public BaseResp incrAmount(@RequestBody DrugVo drugVo) {
        return new BaseResp(drugService.incrDrugAmount(drugVo.getDrugName(), drugVo.getAmount()));
    }

    @PostMapping(value = "/desc")
    public BaseResp descAmount(@RequestBody DrugVo drugVo) {
        return new BaseResp(drugService.descrDrugAmount(drugVo.getDrugName(), drugVo.getAmount()));
    }

    @GetMapping(value = "/todayS")
    public StaRep todayS() {
        return drugService.todaySta();

    }

    @GetMapping(value = "/monthS")
    public StaRep monthS() {
        return drugService.monthSta();

    }

    @GetMapping(value = "/quarterS")
    public StaRep quarterS() {
        return drugService.quarterSta();

    }

    @GetMapping(value = "/search")
    public BaseResp search(@RequestParam(value = "drugName") String drugName) {
        return new BaseResp(drugService.queryDrug(drugName));

    }

}
