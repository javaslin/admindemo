package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.PwdUser;
import com.sl.boot.admindemo.entity.PwdUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * PwdUserDAO继承基类
 */
@Mapper
@Repository
public interface PwdUserDAO extends MyBatisBaseDao<PwdUser, Integer, PwdUserExample> {
}