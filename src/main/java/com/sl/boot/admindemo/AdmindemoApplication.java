package com.sl.boot.admindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@MapperScan("com.sl.boot.admindemo.dao")
@SpringBootApplication
@EnableSwagger2
public class AdmindemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdmindemoApplication.class, args);
    }

}
