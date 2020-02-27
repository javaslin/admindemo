package com.sl.boot.admindemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @RequestMapping(value = "/")
    public String getIndex(){
        return "index";
    }
}
