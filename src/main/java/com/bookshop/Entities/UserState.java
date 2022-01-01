package com.bookshop.Entities;

import javax.persistence.Entity;

@Entity
public class UserState extends User{
    @Override
    public void addBook(Book book) {

    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
