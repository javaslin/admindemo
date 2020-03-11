package com.sl.boot.admindemo.service.impl;

import com.sl.boot.admindemo.dao.ActionRecordDAO;
import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.entity.ActionRecordExample;
import com.sl.boot.admindemo.service.ActionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
