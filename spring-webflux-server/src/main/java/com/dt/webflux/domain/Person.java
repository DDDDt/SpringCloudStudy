package com.dt.webflux.domain;

/**
 * @author dt 2019/3/25 13:35
 */
public class Person {

    private String userName;

    private String sex;

    public Person() {
    }

    public Person(String userName, String sex) {
        this.userName = userName;
        this.sex = sex;
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
