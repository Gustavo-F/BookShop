package com.bookshop.Entities;

import javax.persistence.Entity;

@Entity
public class Author extends Person{

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