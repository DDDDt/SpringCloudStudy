package com.oauth.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Create by dt on 2018/7/17
 */
@RestController
@RequestMapping("/users")
public class UseraController {


    @GetMapping("/current")
    public Principal getUser(Principal principal){
        return principal;
    }

}
