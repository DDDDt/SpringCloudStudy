package com.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Create by dt on 2018/7/9
 * admin server
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
@EnableTurbine
@EnableHystrixDashboard
@EnableHystrix
public class AdminServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(AdminServerApplication.class);

    }

}
