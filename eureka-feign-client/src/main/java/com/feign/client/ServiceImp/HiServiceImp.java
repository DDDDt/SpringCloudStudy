package com.feign.client.ServiceImp;

import com.feign.client.Service.HiService;
import com.feign.client.inter.EurekaClientFeignInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by dt on 2018/6/4
 */
@Service
public class HiServiceImp implements HiService {

    @Autowired
    private EurekaClientFeignInter eurekaClientFeignInter;

    public String sayHi(){
        return eurekaClientFeignInter.sayHelloWowd();
    }


}
