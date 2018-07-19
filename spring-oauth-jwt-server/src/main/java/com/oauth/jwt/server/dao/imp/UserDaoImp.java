package com.oauth.jwt.server.dao.imp;


import com.oauth.jwt.server.dao.UserDao;
import com.oauth.jwt.server.domain.Role;
import com.oauth.jwt.server.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

/**
 * Create by dt on 2018/7/16
 * 查询用户信息
 */
@Repository
public class UserDaoImp implements UserDao {

    /**
     * 可以改为从数据库查询，这里为了简单，直接写死
     * @return
     */
    public User getUser(){

        User user = new User();
        user.setUsername("dt");
        user.setPassword("123456");
        Role role = new Role();
        role.setName("admin");
        role.setId(1);
        user.setAuthorities(Arrays.asList(role));
        return user;

    }

}
