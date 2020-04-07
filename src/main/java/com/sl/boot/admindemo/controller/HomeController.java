package com.sl.boot.admindemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class HomeController {


    @RequestMapping(value = "/")
    public String getIndex() {
        return "login";
    }


    @RequestMapping("/drug/index")
    public String drugindex() {
        return "drug/index";
    }

    @RequestMapping("/drug/index1")
    public String drugindex1() {
        return "drug/index1";
    }

    @RequestMapping("/patient/selfinfo")
    public String patientinfo() {
        return "patient/selfinfo";
    }

    @RequestMapping("/patient/index")
    public String patientindex() {
        return "patient/index";
    }

    @RequestMapping("/drug/report")
    public String drugreport() {
        return "drug/report";
    }

    @RequestMapping("/index")
    public String toindex() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "login";
    }

    @RequestMapping("/user/alluser")
    public String alluser() {
        return "user/alluser";
    }

    @RequestMapping("/drugadminuser/index")
    public String drugadminuserindex() {
        return "drugadminuser/index";
    }

    @RequestMapping("/patient/patients")
    public String patients() {
        return "patient/patients";
    }

    @RequestMapping("/patient/patients1")
    public String patients1() {
        return "patient/patients1";
    }


    @RequestMapping("/patient/patients2")
    public String patients2() {
        return "patient/patients2";
    }


    @RequestMapping("/doctor/index")
    public String docindex() {
        return "doctor/index";
    }

    @RequestMapping("/doctor/doctors")
    public String docall() {
        return "doctor/doctors";
    }

    @RequestMapping("/prescription/all")
    public String preAll() {
        return "prescription/all";
    }

    @RequestMapping("/prescription/patientPresc")
    public String pp() {
        return "prescription/patientPresc";
    }

    @RequestMapping("/drug/stastic")
    public String sts() {
        return "drug/stastic";
    }

    @RequestMapping("/drug/monthSta")
    public String ms() {
        return "drug/monthSta";
    }

    @RequestMapping("/drug/quarterSta")
    public String qs() {
        return "drug/quarterSta";
    }


}
