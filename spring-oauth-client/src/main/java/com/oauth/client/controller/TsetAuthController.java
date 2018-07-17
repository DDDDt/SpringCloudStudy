package com.oauth.client.controller;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Create by dt on 2018/7/17
 * 测试对应的权限
 */
@RestController
@RequestMapping("/auth")
public class TsetAuthController {

    @GetMapping("/noAuth")
    public String noAuth(){
        return "noAuth";
    }

    @PreAuthorize("hasAuthority('role_admin')")
    @GetMapping("/hasAdminAuth")
    public String hasAdminAuth(){

        return "admin";

    }

    @GetMapping("/getPrice")
    public OAuth2Authentication getPrincipe(OAuth2Authentication oAuth2Authentication, Principal principal, Authorization authorization){

        System.out.println(oAuth2Authentication.getName());
        System.out.println(principal.getName());
        System.out.println(authorization.toString());

        return oAuth2Authentication;

    }

}
