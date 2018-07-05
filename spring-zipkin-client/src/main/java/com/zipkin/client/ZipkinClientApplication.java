package com.zipkin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/7/5
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class ZipkinClientApplication {

    @GetMapping("/zipkin/hello")
    public String getZipkinHello(){
        return "hello zipkin";
    }

    public static void main(String[] args) {

        SpringApplication.run(ZipkinClientApplication.class);

    }

}
