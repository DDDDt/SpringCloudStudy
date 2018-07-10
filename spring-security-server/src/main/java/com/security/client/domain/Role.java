package com.security.client.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * Create by dt on 2018/7/10
 * 用户的权限信息
 */
public class Role implements GrantedAuthority , Serializable {

    private Integer id;

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
