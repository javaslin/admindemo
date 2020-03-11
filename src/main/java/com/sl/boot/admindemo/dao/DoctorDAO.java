package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.Doctor;
import com.sl.boot.admindemo.entity.DoctorExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DoctorDAO继承基类
 */
@Mapper
@Repository
public interface DoctorDAO extends MyBatisBaseDao<Doctor, Integer, DoctorExample> {
}