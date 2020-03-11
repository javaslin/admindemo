package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.DrugDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl {

    @Autowired
    private DrugDAO drugDAO;

}
