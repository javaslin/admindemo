package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.service.ActionRecordService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/actionRecord")
public class ActionRecordController {

    @Autowired
    ActionRecordService actionRecordService;


    @GetMapping(value = "/all")
    public BaseResp getAllRecord() {
        List<ActionRecord> actionRecords = actionRecordService.queryAllRecord();
        int count = actionRecords.size();
        return new BaseResp(count, actionRecords);
    }

    @GetMapping(value = "/today")
    public BaseResp getTodayRecord() {
        List<ActionRecord> actionRecords = actionRecordService.queryTodayRecord();
        int count = actionRecords.size();
        return new BaseResp(count, actionRecords);
    }

    @GetMapping(value = "/month")
    public BaseResp getMonthRecord() {
        List<ActionRecord> actionRecords = actionRecordService.queryMonthRecord();
        int count = actionRecords.size();
        return new BaseResp(count, actionRecords);
    }

    @GetMapping(value = "/season")
    public BaseResp getSeasonRecord() {
        List<ActionRecord> actionRecords = actionRecordService.querySeasonRecord();
        int count = actionRecords.size();
        return new BaseResp(count, actionRecords);
    }

}
