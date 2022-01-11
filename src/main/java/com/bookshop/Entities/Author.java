package com.bookshop.Entities;

import javax.persistence.Entity;

@Entity
public class Author extends Person {

    public Author() {

    }

    public Author(String name, String email, String phone) {
        super(name, email, phone);
    }
}