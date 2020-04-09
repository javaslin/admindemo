package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import com.sl.boot.admindemo.vo.resp.StaRep;

import java.util.List;

public interface DrugService {


    List<Drug> queryAllDrug(Integer page, Integer limit, BaseResp baseResp);

    Integer addOneDrug(Drug drug);

    Integer delOneDrug(Long id);

    Integer descrDrugAmount(String drugName, Integer amount);

    Integer incrDrugAmount(String drugName, Integer amount);

    StaRep todaySta();

    StaRep monthSta();

    StaRep quarterSta();

    List<Drug> queryDrug(String durgName);

}
