package com.sl.boot.admindemo.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.ActionRecordDAO;
import com.sl.boot.admindemo.dao.DrugDAO;
import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.entity.ActionRecordExample;
import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.entity.DrugExample;
import com.sl.boot.admindemo.service.DrugService;
import com.sl.boot.admindemo.tools.DateRange;
import com.sl.boot.admindemo.tools.DateUtils;
import com.sl.boot.admindemo.vo.StaVo;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import com.sl.boot.admindemo.vo.resp.StaRep;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDAO drugDAO;

    @Autowired
    private ActionRecordDAO actionRecordDAO;

    @Override
    public List<Drug> queryAllDrug(Integer page, Integer limit, BaseResp baseResp) {
        Page<Drug> page1 = PageHelper.startPage(page, limit);
        DrugExample drugExample = new DrugExample();
        drugDAO.selectByExample(drugExample);
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
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
        Integer in = 0;
        Integer out = 0;
        for (Drug drug : drugs1) {
            drugs.add(drug.getDrugName());
            ActionRecordExample actionRecordExample = new ActionRecordExample();
            actionRecordExample.createCriteria().andActionTimeGreaterThan(dateRange.getStart()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("出库药品");
            List<ActionRecord> actionRecords = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a1 = 0;
            for (ActionRecord actionRecord : actionRecords) {
                a1 += actionRecord.getAmount();
                in += actionRecord.getAmount();
            }
            actionRecordExample.clear();
            actionRecordExample.createCriteria().andActionTimeGreaterThan(dateRange.getStart()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("入库药品");
            List<ActionRecord> actionRecords1 = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a2 = 0;
            for (ActionRecord actionRecord : actionRecords1) {
                a2 += actionRecord.getAmount();
                out += actionRecord.getAmount();
            }
            amount.add(a1);
            amount1.add(a2);
        }
        List<StaVo> staVos = new ArrayList<>();
        StaVo staVo = new StaVo();
        staVo.setName("入库");
        staVo.setValue(out);
        StaVo staVo1 = new StaVo();
        staVo1.setName("出库");
        staVo1.setValue(in);
        staVos.add(staVo);
        staVos.add(staVo1);
        StaRep staRep = new StaRep();
        staRep.setDataX(drugs);
        staRep.setDataY(amount);
        staRep.setDataY1(amount1);
        staRep.setDataO(staVos);
        return staRep;
    }

    @Override
    public StaRep monthSta() {
        List<String> drugs = new ArrayList<>();
        List<Integer> amount = new ArrayList<>();
        List<Integer> amount1 = new ArrayList<>();
        DrugExample drugExample = new DrugExample();
        List<Drug> drugs1 = drugDAO.selectByExample(drugExample);
        DateRange dateRange = DateUtils.getMonthRange(new Date());
        Integer in = 0;
        Integer out = 0;
        for (Drug drug : drugs1) {
            drugs.add(drug.getDrugName());
            ActionRecordExample actionRecordExample = new ActionRecordExample();
            actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("出库药品");
            List<ActionRecord> actionRecords = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a1 = 0;
            for (ActionRecord actionRecord : actionRecords) {
                a1 += actionRecord.getAmount();
                in += actionRecord.getAmount();
            }
            actionRecordExample.clear();
            actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("入库药品");
            List<ActionRecord> actionRecords1 = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a2 = 0;
            for (ActionRecord actionRecord : actionRecords1) {
                a2 += actionRecord.getAmount();
                out += actionRecord.getAmount();
            }
            amount.add(a1);
            amount1.add(a2);
        }
        List<StaVo> staVos = new ArrayList<>();
        StaVo staVo = new StaVo();
        staVo.setName("入库");
        staVo.setValue(out);
        StaVo staVo1 = new StaVo();
        staVo1.setName("出库");
        staVo1.setValue(in);
        staVos.add(staVo);
        staVos.add(staVo1);
        StaRep staRep = new StaRep();
        staRep.setDataX(drugs);
        staRep.setDataY(amount);
        staRep.setDataY1(amount1);
        staRep.setDataO(staVos);
        return staRep;
    }

    @Override
    public StaRep quarterSta() {
        List<String> drugs = new ArrayList<>();
        List<Integer> amount = new ArrayList<>();
        List<Integer> amount1 = new ArrayList<>();
        DrugExample drugExample = new DrugExample();
        List<Drug> drugs1 = drugDAO.selectByExample(drugExample);
        DateRange dateRange = DateUtils.getThisQuarter();
        Integer in = 0;
        Integer out = 0;
        for (Drug drug : drugs1) {
            drugs.add(drug.getDrugName());
            ActionRecordExample actionRecordExample = new ActionRecordExample();
            actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("出库药品");
            List<ActionRecord> actionRecords = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a1 = 0;
            for (ActionRecord actionRecord : actionRecords) {
                a1 += actionRecord.getAmount();
                in += actionRecord.getAmount();
            }
            actionRecordExample.clear();
            actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd()).andDrugNameEqualTo(drug.getDrugName()).andActionEqualTo("入库药品");
            List<ActionRecord> actionRecords1 = actionRecordDAO.selectByExample(actionRecordExample);
            Integer a2 = 0;
            for (ActionRecord actionRecord : actionRecords1) {
                a2 += actionRecord.getAmount();
                out += actionRecord.getAmount();
            }
            amount.add(a1);
            amount1.add(a2);
        }
        List<StaVo> staVos = new ArrayList<>();
        StaVo staVo = new StaVo();
        staVo.setName("入库");
        staVo.setValue(out);
        StaVo staVo1 = new StaVo();
        staVo1.setName("出库");
        staVo1.setValue(in);
        staVos.add(staVo);
        staVos.add(staVo1);
        StaRep staRep = new StaRep();
        staRep.setDataX(drugs);
        staRep.setDataY(amount);
        staRep.setDataY1(amount1);
        staRep.setDataO(staVos);
        return staRep;
    }

    @Override
    public List<Drug> queryDrug(String durgName) {
        DrugExample drugExample = new DrugExample();
        StringBuffer sb = new StringBuffer(durgName);
        sb.append("%");
        sb.insert(0, '%');
        drugExample.createCriteria().andDrugNameLike(sb.toString());
        List<Drug> drugs = drugDAO.selectByExample(drugExample);
        return drugs;
    }
}
