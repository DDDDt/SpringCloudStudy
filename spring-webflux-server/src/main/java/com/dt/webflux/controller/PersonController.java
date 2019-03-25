package com.dt.webflux.controller;

import com.dt.webflux.Service.PersonService;
import com.dt.webflux.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author dt 2019/3/22 12:40
 * 响应式
 */
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personServiceImpl;

    @Autowired
    public PersonController(PersonService personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @GetMapping("/getPerson")
    public Mono<Person> getPerson(){
        return Mono.just(new Person("dt","男"));
    }

    /**
     * 保存用户信息
     * @param person
     * @return
     */
    @PostMapping("/save")
    public Mono<Person> save(@RequestBody Person person){
        return personServiceImpl.save(person);
    }

    @GetMapping("/delete/{userName}")
    public Mono<Long> deleteByUsername(@PathVariable("userName") String userName){
        return personServiceImpl.deleteByPerson(userName);
    }

    /**
     * 查询所有的用户信息
     * @return
     */
    @GetMapping("/findAll")
    public Flux<Person> findAll(){
        return personServiceImpl.findAll();
    }

    /**
     * 延迟 1 秒查询
     * @return
     */
    @GetMapping("/findAllDelay")
    public Flux<Person> findAllDelay(){
        return personServiceImpl.findAll().delaySequence(Duration.ofSeconds(1));
    }

    /**
     * 流的形式吐出数据
     * @return
     */
    @GetMapping(value = "/findAllDelayStream",produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Person> findAllDelayStream(){
        return personServiceImpl.findAll().delaySequence(Duration.ofSeconds(2));
    }

}
