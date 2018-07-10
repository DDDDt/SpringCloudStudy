package com.security.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Create by dt on 2018/7/10
 */
@SpringBootApplication
@EnableEurekaClient
public class SecurityClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(SecurityClientApplication.class);

    }

}
