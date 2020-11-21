package com.lqtest.druid_mybatis.lqtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LqtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(LqtestApplication.class, args);
    }

}
