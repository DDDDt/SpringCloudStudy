package com.turbine.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Create by dt on 2018/7/1
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
public class TurbineClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(TurbineClientApplication.class);

    }

}
