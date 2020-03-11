package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.AdminUserDAO;
import com.sl.boot.admindemo.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;


}
