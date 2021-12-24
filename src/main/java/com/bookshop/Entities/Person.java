package com.bookshop.Entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String name;
    protected String email;
    protected String phone;

    public abstract String getName();

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getEmail();

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String getPhone();

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
