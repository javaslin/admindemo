package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.Drug;
import com.sl.boot.admindemo.entity.DrugExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DrugDAO继承基类
 */
@Mapper
@Repository
public interface DrugDAO extends MyBatisBaseDao<Drug, Long, DrugExample> {
}