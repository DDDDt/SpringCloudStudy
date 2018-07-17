package com.oauth.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/7/17
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/getUser")
    public String getUser(){
        return "dt";
    }

}
