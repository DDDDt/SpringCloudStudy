package com.ribbon.client.controller;

import com.ribbon.client.service.RestTemplateHystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/6/9
 */
@RestController
@RequestMapping("/hi")
public class HiController {

    @Autowired
    private RestTemplateHystrix restTemplateHystrixImp;

    @GetMapping("/helloWord")
    public String helloWord(){

        return restTemplateHystrixImp.hi("hello");

    }

}
