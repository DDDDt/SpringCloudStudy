package com.dt.webflux.Service.impl;

import com.dt.webflux.Service.PersonService;
import com.dt.webflux.dao.PersonDao;
import com.dt.webflux.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author dt 2019/3/25 15:43
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDaoImpl;

    @Autowired
    public PersonServiceImpl(PersonDao personDaoImpl) {
        this.personDaoImpl = personDaoImpl;
    }

    /**
     * 保存
     * @param person
     * @return
     */
    @Override
    public Mono<Person> save(Person person){
       return personDaoImpl.save(person)
               // 错误重试
                .onErrorResume(e ->
                        personDaoImpl.findByUserName(person.getUserName())
                                // 由于函数式为User -> Publisher，所以用flatMap。
                        .flatMap(p -> {
                            person.setId(p.getId());
                            return personDaoImpl.save(person);
                        })
                );
    }

    @Override
    public Mono<Long> deleteByPerson(String userName){
        return personDaoImpl.deleteByUserName(userName);
    }

    @Override
    public Mono<Person> findByUsername(String userName){
        return personDaoImpl.findByUserName(userName);
    }

    @Override
    public Flux<Person> findAll(){
        return personDaoImpl.findAll();
    }

}
