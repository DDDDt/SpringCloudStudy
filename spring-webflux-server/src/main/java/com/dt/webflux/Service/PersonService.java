package com.dt.webflux.Service;

import com.dt.webflux.domain.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author dt 2019/3/25 15:42
 */
public interface PersonService {

    Mono<Person> save(Person person);

    Mono<Long> deleteByPerson(String userName);

    Mono<Person> findByUsername(String userName);

    Flux<Person> findAll();

}
