package com.security.client.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by dt on 2018/7/10
 */
@RestController
@RequestMapping("/blog")
public class BlogController {


    /**
     * 也可以写为 @PreAuthorize("hasRole('admin')")
     * @return
     */
    @RequestMapping("/delBlog")
    @PreAuthorize("hasAuthority('role_admin')")
    public String delBlog(){

        return "权限测试删除";

    }

    /**
     * 也可以写为 @PreAuthorize("hasAuthority('admin,user')")
     * @return
     */
    @RequestMapping("/getBlog")
    @PreAuthorize("hasAnyRole('role_admin,role_user')")
    public String getBlog(){
        return "查询博客信息";
    }

}
