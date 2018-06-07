package com.dt.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dt 2018/6/7 11:10
 * 启动类
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.dt.demo.dataInter")
public class BootDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(BootDemoApplication.class);

    }

}
