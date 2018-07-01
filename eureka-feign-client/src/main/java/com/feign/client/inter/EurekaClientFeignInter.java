package com.feign.client.inter;

import com.feign.client.config.FeignConfig;
import com.feign.client.hystrix.HiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Create by dt on 2018/6/4
 */
@FeignClient(value="eureka-client",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeignInter {

    @GetMapping(value = "/hello")
    String sayHelloWowd();

}
