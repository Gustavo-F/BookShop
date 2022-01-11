package com.bookshop.Entities;

import javax.persistence.Entity;

@Entity
public class Publisher extends Person{

    public Publisher() {

    }

    public Publisher(String name, String email, String phone) {
        super(name, email, phone);
    }
}
