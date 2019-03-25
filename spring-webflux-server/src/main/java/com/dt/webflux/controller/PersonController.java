package com.dt.webflux.controller;

import com.dt.webflux.domain.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author dt 2019/3/22 12:40
 * 响应式
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/getPerson")
    public Mono<Person> getPerson(){
        return Mono.just(new Person("dt","男"));
    }

}
