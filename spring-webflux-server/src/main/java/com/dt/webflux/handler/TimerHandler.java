package com.dt.webflux.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author dt 2019/3/25 14:15
 */
@Component
public class TimerHandler {

    /**
     * 正常的写法获取时间
     * @param request
     * @return
     */
    public Mono<ServerResponse> getTime(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just("现在时间是: "+ LocalDateTime.now().toString()),String.class);
    }

    /**
     * 获取当前天数
     * @param request
     * @return
     */
    public Mono<ServerResponse> getDate(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8).body(Mono.just("今天是: "+ LocalDate.now().toString()),String.class);
    }

    /**
     * MediaType.TEXT_EVENT_STREAM 表示 Content-Type 为 text/event-stream， 及 SSE
     * 利用 interval 生成每秒一个数据的流
     * @param request
     * @return
     */
    public Mono<ServerResponse> sendTimePerSec(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(Flux.interval(Duration.ofSeconds(1))
                        .map(x -> LocalDateTime.now().toString()),
                        String.class);
    }

}
