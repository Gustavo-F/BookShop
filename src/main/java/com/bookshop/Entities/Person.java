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

    public Person named(String name) {
        this.name = name;
        return this;
    }

    public Person emailAddress(String email) {
        this.email = email;
        return this;
    }

    public Person phoneNumber(String phone) {
        this.phone = phone;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public int getId() {
        return this.id;
    }
}
