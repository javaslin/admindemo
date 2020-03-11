package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.DrugDAO;
import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.entity.DrugExample;
import com.sl.boot.admindemo.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDAO drugDAO;

    @Override
    public List<Drug> queryAllDrug() {
        DrugExample drugExample = new DrugExample();
        return drugDAO.selectByExample(drugExample);
    }

    @Override
    public Integer addOneDrug(Drug drug) {
        return drugDAO.insertSelective(drug);
    }


    @Override
    public Integer delOneDrug(Long id) {
        return drugDAO.deleteByPrimaryKey(id);
    }

    @Override
    public Integer descrDrugAmount(String drugName, Integer amount) {
        Drug drug = new Drug();
        DrugExample drugExample = new DrugExample();
        drugExample.createCriteria().andDrugNameEqualTo(drugName);
        List<Drug> drugs = drugDAO.selectByExample(drugExample);
        Drug drug1 = drugs.get(0);
        drug.setDrugCount(drug1.getDrugCount() - amount);
        return drugDAO.updateByExampleSelective(drug, drugExample);
    }

    @Override
    public Integer incrDrugAmount(String drugName, Integer amount) {
        Drug drug = new Drug();
        DrugExample drugExample = new DrugExample();
        drugExample.createCriteria().andDrugNameEqualTo(drugName);
        List<Drug> drugs = drugDAO.selectByExample(drugExample);
        Drug drug1 = drugs.get(0);
        drug.setDrugCount(drug1.getDrugCount() + amount);
        return drugDAO.updateByExampleSelective(drug, drugExample);
    }
}
