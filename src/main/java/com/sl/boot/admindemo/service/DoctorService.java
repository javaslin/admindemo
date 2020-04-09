package com.sl.boot.admindemo.service;

import com.sl.boot.admindemo.entity.Doctor;
import com.sl.boot.admindemo.vo.resp.BaseResp;

import java.util.List;

public interface DoctorService {

    List<Doctor> allDoctors(Integer page, Integer limit, BaseResp baseResp);

    Integer update(Doctor doctor);
}
