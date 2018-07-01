package com.feign.client.hystrix;

import com.feign.client.inter.EurekaClientFeignInter;
import org.springframework.stereotype.Component;

/**
 * Create by dt on 2018/6/10
 * Hystrix 错误返回
 */
@Component
public class HiHystrix implements EurekaClientFeignInter {


    @Override
    public String sayHelloWowd() {
        return "error hi";
    }
}
