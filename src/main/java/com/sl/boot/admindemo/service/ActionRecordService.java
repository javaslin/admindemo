package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.ActionRecord;

import java.util.List;

public interface ActionRecordService {


    List<ActionRecord> queryAllRecord();

    List<ActionRecord> queryTodayRecord();

    List<ActionRecord> queryMonthRecord();

    List<ActionRecord> querySeasonRecord();
}
