package com.sl.boot.admindemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sl.boot.admindemo.dao.ActionRecordDAO;
import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.entity.ActionRecordExample;
import com.sl.boot.admindemo.service.ActionRecordService;
import com.sl.boot.admindemo.tools.DateRange;
import com.sl.boot.admindemo.tools.DateUtils;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ActionRecordServiceImpl implements ActionRecordService {


    @Autowired
    private ActionRecordDAO actionRecordDAO;


    @Override
    public List<ActionRecord> queryAllRecord(Integer page, Integer limit, BaseResp baseResp) {
        System.out.println("page" + page + "limit" + limit);
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        Page<ActionRecord> page1 = PageHelper.startPage(page, limit).doSelectPage(() -> actionRecordDAO.selectByExample(actionRecordExample));
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }

    @Override
    public List<ActionRecord> queryTodayRecord(Integer page, Integer limit, BaseResp baseResp) {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        DateRange dateRange = DateUtils.getYesterdayRange();
        actionRecordExample.createCriteria().andActionTimeGreaterThan(dateRange.getStart());
        Page<ActionRecord> page1 = PageHelper.startPage(page, limit).doSelectPage(() -> actionRecordDAO.selectByExample(actionRecordExample));
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }

    @Override
    public List<ActionRecord> queryMonthRecord(Integer page, Integer limit, BaseResp baseResp) {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        DateRange dateRange = DateUtils.getMonthRange(new Date());
        actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd());
        Page<ActionRecord> page1 = PageHelper.startPage(page, limit).doSelectPage(() -> actionRecordDAO.selectByExample(actionRecordExample));
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }

    @Override
    public List<ActionRecord> querySeasonRecord(Integer page, Integer limit, BaseResp baseResp) {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        DateRange dateRange = DateUtils.getThisQuarter();
        actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd());
        Page<ActionRecord> page1 = PageHelper.startPage(page, limit).doSelectPage(() -> actionRecordDAO.selectByExample(actionRecordExample));
        baseResp.setCount((int) page1.getTotal());
        return page1.getResult();
    }
}
