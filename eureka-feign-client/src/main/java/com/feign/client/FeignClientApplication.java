package com.feign.client;

import com.feign.client.Service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/6/4
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class FeignClientApplication {

    @Autowired
    private HiService hiServiceImp;

    public String sayHello(){
        return hiServiceImp.sayHi();
    }

    public static void main(String[] args) {

        SpringApplication.run(FeignClientApplication.class,args);

    }

}