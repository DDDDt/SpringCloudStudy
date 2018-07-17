package com.oauth.client.config;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.encoding.FeignContentGzipEncodingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Create by dt on 2018/7/17
 */
@Configuration
@EnableConfigurationProperties
@EnableOAuth2Client
public class Oauth2ClientConfig {

    @Bean
    @ConfigurationProperties(prefix = "security.oauth2.client")
    public ClientCredentialsResourceDetails clientCredentialsResourceDetails(){
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    public RequestInterceptor oauth2Feign(){
        return new FeignContentGzipEncodingInterceptor()
    }

    @Bean
    public OAuth2RestTemplate clientCredential(){
        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
    }

}
