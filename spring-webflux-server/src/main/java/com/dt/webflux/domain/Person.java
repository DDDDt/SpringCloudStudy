package com.dt.webflux.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author dt 2019/3/25 13:35
 */
@Document(collection = "person")
public class Person {

    @Id
    private String id;

    @Indexed(unique = true)
    private String userName;

    private String sex;

    public Person() {
    }

    public Person(String userName, String sex) {
        this.userName = userName;
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
