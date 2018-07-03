package com.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/7/3
 * RefreshScope 配置文件更新后调用 http://localhost:8095/bus/refresh 就可以实现在线动态更新配置文件
 * /bus/refresh?destination=eureka-client:** 刷新所有名为 eureka-client的服务实例
 */
@SpringBootApplication
@RestController
@EnableEurekaClient
@RefreshScope
public class ConfigClientApplication {



    public static void main(String[] args) {

        SpringApplication.run(ConfigClientApplication.class);

    }

}
