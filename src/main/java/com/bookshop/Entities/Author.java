package com.bookshop.Entities;

import javax.persistence.Entity;

@Entity
public class Author extends Person {

    public Author() {
    }

    public Author(String name, String email, String phone) {
        super(name, email, phone);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPhone() {
        return this.phone;
    }
}