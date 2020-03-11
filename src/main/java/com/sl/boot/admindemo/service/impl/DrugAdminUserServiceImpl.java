package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.DrugAdminUserDAO;
import com.sl.boot.admindemo.service.DrugAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugAdminUserServiceImpl implements DrugAdminUserService {

    @Autowired
    private DrugAdminUserDAO drugAdminUserDAO;
}
