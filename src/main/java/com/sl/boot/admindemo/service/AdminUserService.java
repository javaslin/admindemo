package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.AdminUser;
import com.sl.boot.admindemo.entity.PwdUser;

import java.util.List;

public interface AdminUserService {


    Integer addOneUser(String userName, String password, Integer type);

    Integer delUser(String userName, Integer type);

    List<PwdUser> queryAllUser();


}
