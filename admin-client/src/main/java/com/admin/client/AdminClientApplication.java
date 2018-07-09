package com.admin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Create by dt on 2018/7/9
 */
@SpringBootApplication
@EnableEurekaClient
public class AdminClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminClientApplication.class);

    }

}
