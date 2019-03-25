package com.dt.webflux.config;

import com.dt.webflux.handler.TimerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author dt 2019/3/25 14:02
 */
@Configuration
public class RouterConfig {

    private final TimerHandler timerHandler;

    @Autowired
    public RouterConfig(TimerHandler timerHandler) {
        this.timerHandler = timerHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> timerRouter(){
        return RouterFunctions.route(RequestPredicates.GET("/timer/time"), timerHandler::getTime)
                .andRoute(RequestPredicates.GET("/timer/date"),timerHandler::getDate)
                .andRoute(RequestPredicates.GET("/timer/times"),timerHandler::sendTimePerSec);
    }

}
