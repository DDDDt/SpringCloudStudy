package com.oauth.server.Service.imp;

import com.oauth.server.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Create by dt on 2018/7/16
 * 查询用户具体的安全信息
 */
@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private UserDao userDaoImp;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDaoImp.getUser();
    }
}
