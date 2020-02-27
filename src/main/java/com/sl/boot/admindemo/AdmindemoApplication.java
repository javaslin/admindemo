package com.sl.boot.admindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.sl.boot.admindemo.dao")
@SpringBootApplication
public class AdmindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmindemoApplication.class, args);
    }

}
