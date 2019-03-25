package com.dt.webflux.dao;

import com.dt.webflux.domain.Person;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author dt 2019/3/25 15:37
 */
public interface PersonDao extends ReactiveCrudRepository<Person,String> {

    Mono<Person> findByUserName(String userName);

    Mono<Long> deleteByUserName(String userName);


}
