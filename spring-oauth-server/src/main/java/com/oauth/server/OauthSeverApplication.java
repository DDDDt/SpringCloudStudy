package com.oauth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Create by dt on 2018/7/16
 */
@SpringBootApplication
@EnableEurekaClient
public class OauthSeverApplication {

    public static void main(String[] args) {

        SpringApplication.run(OauthSeverApplication.class);

    }

}
