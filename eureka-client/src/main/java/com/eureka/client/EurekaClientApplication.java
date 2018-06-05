package com.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/6/2
 * erureka client 服务提供
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {


    @GetMapping("/hello")
    public String helloWord(){
        return "hello , world";
    }

    public static void main(String[] args) {

        SpringApplication.run(EurekaClientApplication.class);

    }

}
