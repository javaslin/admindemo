package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.ActionRecordDAO;
import com.sl.boot.admindemo.dao.DrugDAO;
import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.entity.ActionRecordExample;
import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.entity.DrugExample;
import com.sl.boot.admindemo.service.DrugService;
import com.sl.boot.admindemo.tools.DateRange;
import com.sl.boot.admindemo.tools.DateUtils;
import com.sl.boot.admindemo.vo.resp.StaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDAO drugDAO;

    @Autowired
    private ActionRecordDAO actionRecordDAO;

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
        if (drugs.size() != 0) {
            Drug drug1 = drugs.get(0);
            drug.setDrugCount(drug1.getDrugCount() - amount);
            ActionRecord actionRecord = new ActionRecord();
            actionRecord.setAction("出库药品");
            actionRecord.setDrugName(drugName);
            actionRecord.setActionTime(new Date());
            actionRecord.setAmount(amount);
            actionRecordDAO.insert(actionRecord);
            return drugDAO.updateByExampleSelective(drug, drugExample);
        }


        return 1;

    }

    @Override
    public Integer incrDrugAmount(String drugName, Integer amount) {
        Drug drug = new Drug();
        DrugExample drugExample = new DrugExample();
        drugExample.createCriteria().andDrugNameEqualTo(drugName);
        List<Drug> drugs = drugDAO.selectByExample(drugExample);
        if (drugs.size() != 0) {
            Drug drug1 = drugs.get(0);
            drug.setDrugCount(drug1.getDrugCount() + amount);
            ActionRecord actionRecord = new ActionRecord();
            actionRecord.setAction("入库药品");
            actionRecord.setDrugName(drugName);
            actionRecord.setActionTime(new Date());
            actionRecord.setAmount(amount);
            actionRecordDAO.insert(actionRecord);
            return drugDAO.updateByExampleSelective(drug, drugExample);
        }

        return 1;
    }

    @Override
    public StaRep todaySta() {
        List<String> drugs = new ArrayList<>();
        List<Integer> amount = new ArrayList<>();
        List<Integer> amount1 = new ArrayList<>();
        DrugExample drugExample = new DrugExample();
        List<Drug> drugs1 = drugDAO.selectByExample(drugExample);
        DateRange dateRange = DateUtils.getYesterdayRange();
        for (Drug drug : drugs1) {
            drugs.add(drug.getDrugName());
            ActionRecordExample actionRecordExample = new ActionRecordExample();
            actionRecordExample.createCriteria().andActionTimeGreaterThan(dateRange.getStart()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("出库药品");
            List<ActionRecord> actionRecords = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a1 = 0;
            for (ActionRecord actionRecord : actionRecords) {
                a1 += actionRecord.getAmount();
            }
            actionRecordExample.clear();
            actionRecordExample.createCriteria().andActionTimeGreaterThan(dateRange.getStart()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("入库药品");
            List<ActionRecord> actionRecords1 = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a2 = 0;
            for (ActionRecord actionRecord : actionRecords1) {
                a2 += actionRecord.getAmount();
            }
            amount.add(a1);
            amount1.add(a2);
        }
        StaRep staRep = new StaRep();
        staRep.setDataX(drugs);
        staRep.setDataY(amount);
        staRep.setDataY1(amount1);
        return staRep;
    }
}
