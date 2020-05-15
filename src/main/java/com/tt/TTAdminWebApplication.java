package com.tt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tt.*.dao")
public class TTAdminWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TTAdminWebApplication.class, args);
    }

}
