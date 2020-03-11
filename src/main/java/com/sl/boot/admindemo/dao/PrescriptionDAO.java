package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.Prescription;
import com.sl.boot.admindemo.entity.PrescriptionExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PrescriptionDAO继承基类
 */
@Mapper
@Repository
public interface PrescriptionDAO extends MyBatisBaseDao<Prescription, Integer, PrescriptionExample> {
}