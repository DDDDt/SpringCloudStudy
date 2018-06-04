package com.feign.client.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by dt on 2018/6/4
 */
@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer(){

        return new Retryer.Default(100,100l,5);

    }

}
