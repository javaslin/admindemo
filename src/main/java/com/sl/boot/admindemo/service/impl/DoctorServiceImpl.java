package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.DoctorDAO;
import com.sl.boot.admindemo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    private DoctorDAO doctorDAO;


}
