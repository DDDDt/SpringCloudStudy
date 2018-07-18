package com.oauth.jwt.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * Create by dt on 2018/7/18
 */
@Configuration
public class JwtConfig {

    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;



}
