package com.sl.boot.admindemo.service.impl;

import com.sl.boot.admindemo.dao.ActionRecordDAO;
import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.entity.ActionRecordExample;
import com.sl.boot.admindemo.service.ActionRecordService;
import com.sl.boot.admindemo.tools.DateRange;
import com.sl.boot.admindemo.tools.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ActionRecordServiceImpl implements ActionRecordService {


    @Autowired
    private ActionRecordDAO actionRecordDAO;


    @Override
    public List<ActionRecord> queryAllRecord() {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        return actionRecordDAO.selectByExample(actionRecordExample);
    }

    @Override
    public List<ActionRecord> queryTodayRecord() {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        DateRange dateRange = DateUtils.getYesterdayRange();
        actionRecordExample.createCriteria().andActionTimeGreaterThan(dateRange.getEnd());
        return actionRecordDAO.selectByExample(actionRecordExample);
    }

    @Override
    public List<ActionRecord> queryMonthRecord() {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        DateRange dateRange = DateUtils.getMonthRange(new Date());
        actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd());
        return actionRecordDAO.selectByExample(actionRecordExample);
    }

    @Override
    public List<ActionRecord> querySeasonRecord() {
        ActionRecordExample actionRecordExample = new ActionRecordExample();
        DateRange dateRange = DateUtils.getThisQuarter();
        actionRecordExample.createCriteria().andActionTimeBetween(dateRange.getStart(), dateRange.getEnd());
        return actionRecordDAO.selectByExample(actionRecordExample);
    }
}
