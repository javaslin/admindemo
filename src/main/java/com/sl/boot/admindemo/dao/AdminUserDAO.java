package com.sl.boot.admindemo.dao;

import com.sl.boot.admindemo.entity.AdminUser;
import com.sl.boot.admindemo.entity.AdminUserExample;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * AdminUserDAO继承基类
 */
@Mapper
@Repository
public interface AdminUserDAO extends MyBatisBaseDao<AdminUser, Long, AdminUserExample> {
}