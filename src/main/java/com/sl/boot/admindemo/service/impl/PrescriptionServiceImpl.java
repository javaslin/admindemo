package com.sl.boot.admindemo.service.impl;


import com.sl.boot.admindemo.dao.PrescriptionDAO;
import com.sl.boot.admindemo.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionDAO prescriptionDAO;
}
