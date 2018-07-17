package com.oauth.server.config;

import com.oauth.server.Service.imp.UserDetailServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * Create by dt on 2018/7/17
 * 验证配置文件
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig implements AuthorizationServerConfigurer {

    @Autowired
    private UserDetailServiceImp userDetailsService;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        /*保存到内存中*/
        clients.inMemory().withClient("brower").authorizedGrantTypes("refresh_token","password").scopes("ui").and().withClient("service_hi")
                .secret("123456").authorizedGrantTypes("client_credentials","refresh_token","password").scopes("server");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {


    }
}
