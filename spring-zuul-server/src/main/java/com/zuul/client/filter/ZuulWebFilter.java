package com.zuul.client.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * Create by dt on 2018/7/2过滤器
 * zull 路由网关过滤器
 */
@Component
public class ZuulWebFilter extends ZuulFilter {

    /**
     * 过滤类型 有四种 pre  post routing error
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤顺序，值越小，越早执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 表示该过滤器是否过滤逻辑,true 则执行run方法，false 不执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的过滤业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext cx = RequestContext.getCurrentContext();
        HttpServletRequest request = cx.getRequest();
        String token = request.getParameter("TOKEN");
        if(StringUtils.isBlank(token)){
            System.out.println("token 为空");
            try{

                cx.setSendZuulResponse(false);
                cx.setResponseStatusCode(401);
                cx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                /*这块可以改成日志 logger 打印出*/
                System.out.println("错误");
            }
        }

        return null;
    }
}
