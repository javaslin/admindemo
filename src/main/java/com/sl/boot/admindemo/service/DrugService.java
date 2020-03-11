package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.Drug;

import java.util.List;

public interface DrugService {


    List<Drug> queryAllDrug();

    Integer addOneDrug(Drug drug);

    Integer delOneDrug(Long id);

    Integer descrDrugAmount(String drugName, Integer amount);

    Integer incrDrugAmount(String drugName, Integer amount);
}
