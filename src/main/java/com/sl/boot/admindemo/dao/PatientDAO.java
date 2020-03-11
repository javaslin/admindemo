package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.Patient;
import com.sl.boot.admindemo.entity.PatientExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PatientDAO继承基类
 */
@Mapper
@Repository
public interface PatientDAO extends MyBatisBaseDao<Patient, Long, PatientExample> {
}