package com.ribbon.client.service.imp;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ribbon.client.service.RestTemplateHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Create by dt on 2018/6/9
 *
 * 增加熔断器机制
 *
 */
@Service
public class RestTemplateHystrixImp implements RestTemplateHystrix {

    @Autowired
    private RestTemplate restTemplate;


    /**
     * 使用 HystrixCommand 开启熔断器机制 , 若调用不通直接返回 fallbackMethod 的方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(String name){

        return restTemplate.getForObject("http://eureka-client/hello",String.class);

    }

    /**
     * 错误重新返回
     * @param name
     * @return
     */
    public String hiError(String name){

        return "error";

    }

}
