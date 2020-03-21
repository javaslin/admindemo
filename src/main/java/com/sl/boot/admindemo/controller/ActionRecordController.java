package com.sl.boot.admindemo.controller;


import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.service.ActionRecordService;
import com.sl.boot.admindemo.vo.resp.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/actionRecord")
public class ActionRecordController {

    @Autowired
    ActionRecordService actionRecordService;


    @GetMapping(value = "/all")
    public BaseResp getAllRecord(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<ActionRecord> actionRecords = actionRecordService.queryAllRecord(page, limit, baseResp);
        baseResp.setData(actionRecords);
        return baseResp;
    }

    @GetMapping(value = "/today")
    public BaseResp getTodayRecord(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<ActionRecord> actionRecords = actionRecordService.queryTodayRecord(page, limit, baseResp);
        baseResp.setData(actionRecords);
        return baseResp;
    }

    @GetMapping(value = "/month")
    public BaseResp getMonthRecord(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<ActionRecord> actionRecords = actionRecordService.queryMonthRecord(page, limit, baseResp);
        baseResp.setData(actionRecords);
        return baseResp;
    }

    @GetMapping(value = "/season")
    public BaseResp getSeasonRecord(@RequestParam(value = "page") Integer page, @RequestParam(value = "limit") Integer limit) {
        BaseResp baseResp = new BaseResp();
        List<ActionRecord> actionRecords = actionRecordService.querySeasonRecord(page, limit, baseResp);
        baseResp.setData(actionRecords);
        return baseResp;
    }

}
