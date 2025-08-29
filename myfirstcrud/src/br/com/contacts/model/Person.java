package br.com.contacts.model;

import java.util.Date;

public class Person {
    private int id;
    private String name;
    private int age;
    private Date signinDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getSigninDate() {
        return signinDate;
    }

    public void setSigninDate(Date signinDate) {
        this.signinDate = signinDate;
    }
}
