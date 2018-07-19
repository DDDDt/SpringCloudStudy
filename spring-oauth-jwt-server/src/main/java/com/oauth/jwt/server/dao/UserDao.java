package com.oauth.jwt.server.dao;


import com.oauth.jwt.server.domain.User;

/**
 * Create by dt on 2018/7/16
 */
public interface UserDao {

    /**
     * 可以改为从数据库查询，这里为了简单，直接写死
     * @return
     */
    User getUser();

}
