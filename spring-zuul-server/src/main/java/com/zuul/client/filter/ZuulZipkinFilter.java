package com.zuul.client.filter;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * Create by dt on 2018/7/5
 * 链路追踪增加新的纸
 */
@Component
public class ZuulZipkinFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;


    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        /*这块获取trace id 有问题。待以后研究*/
        tracer.currentSpan().tag("userName","dt");
        System.out.println(tracer.currentSpan().context().spanId());
        return null;
    }
}
