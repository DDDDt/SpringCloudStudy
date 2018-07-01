package com.zuul.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Create by dt on 2018/6/9
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulClientApplication {

    public static void main(String[] args) {

        SpringApplication.run(ZuulClientApplication.class);

    }

}
