package com.security.client.service.imp;

import com.security.client.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Create by dt on 2018/7/10
 */
@Service
public class UserRoleServiceImp implements UserDetailsService {

    /*这个可以改为从数据库查询相关的用户权限信息*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User();
    }
}
