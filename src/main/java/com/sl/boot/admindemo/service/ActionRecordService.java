package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.vo.resp.BaseResp;

import java.util.List;

public interface ActionRecordService {


    List<ActionRecord> queryAllRecord(Integer page, Integer limit, BaseResp baseResp);

    List<ActionRecord> queryTodayRecord(Integer page, Integer limit, BaseResp baseResp);

    List<ActionRecord> queryMonthRecord(Integer page, Integer limit, BaseResp baseResp);

    List<ActionRecord> querySeasonRecord(Integer page, Integer limit, BaseResp baseResp);
}
