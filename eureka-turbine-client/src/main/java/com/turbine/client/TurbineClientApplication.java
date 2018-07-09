package com.turbine.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Create by dt on 2018/7/1
 */
@SpringBootApplication
@EnableTurbine
public class TurbineClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(TurbineClientApplication.class);

    }

}
