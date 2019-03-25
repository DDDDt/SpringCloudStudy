package com.dt.webflux.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author dt 2019/3/25 14:00
 */
@Component
public class TimeHandler {
    /**
     * 查询当前时间
     */
    HandlerFunction<ServerResponse> timeFunction = request -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just("现在时间是:"+ LocalDateTime.now().toString()),String.class);

    /**
     * 查询当前时间是多少, 精确到天
     */
    HandlerFunction<ServerResponse> dateFunction = request -> ServerResponse.ok()
            .contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just("今天是"+ LocalDate.now().toString()),String.class);

    /**
     * 路由写在同一个文件中
     */
    RouterFunction<ServerResponse>  router = RouterFunctions.route(RequestPredicates.GET("/time"), timeFunction)
            .andRoute(RequestPredicates.GET("/date"), dateFunction);

}
