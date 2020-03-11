package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.ActionRecord;
import com.sl.boot.admindemo.entity.ActionRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * ActionRecordDAO继承基类
 */
@Mapper
@Repository
public interface ActionRecordDAO extends MyBatisBaseDao<ActionRecord, Long, ActionRecordExample> {
}