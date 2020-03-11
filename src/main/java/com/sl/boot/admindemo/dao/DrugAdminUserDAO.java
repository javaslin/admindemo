package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.DrugAdminUser;
import com.sl.boot.admindemo.entity.DrugAdminUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DrugAdminUserDAO继承基类
 */
@Mapper
@Repository
public interface DrugAdminUserDAO extends MyBatisBaseDao<DrugAdminUser, Integer, DrugAdminUserExample> {
}