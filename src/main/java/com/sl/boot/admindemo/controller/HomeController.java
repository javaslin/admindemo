package com.sl.boot.admindemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/")
public class HomeController {


    @RequestMapping(value = "/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/user/index")
    public String index() {
        return "user/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

}
