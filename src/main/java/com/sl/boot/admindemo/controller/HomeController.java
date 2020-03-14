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

    @RequestMapping("/user/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/drug/index")
    public String drugindex() {
        return "drug/index";
    }

    @RequestMapping("/patient/selfinfo")
    public String patientinfo() {
        return "patient/selfinfo";
    }

    @RequestMapping("/patient/index")
    public String patientindex() {
        return "patient/index";
    }

    @RequestMapping("/index")
    public String toindex() {
        return "index";
    }


}
