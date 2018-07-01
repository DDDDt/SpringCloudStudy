package com.ribbon.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Create by dt on 2018/6/4
 *
 * EnableHystrix 增加熔断器机制
 * EnableHystrixDashboard 增加监控
 *
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
public class RibbonClientApplication {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/helloRibbon")
    public String helloRibbon(){

        String result = restTemplate.getForObject("http://eureka-client/hello",String.class);

        return result;

    }

    public static void main(String[] args) {

        SpringApplication.run(RibbonClientApplication.class);

    }

}
