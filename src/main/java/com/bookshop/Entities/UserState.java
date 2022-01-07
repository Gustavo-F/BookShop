package com.bookshop.Entities;

import javax.persistence.Entity;

@Entity
public class UserState extends User implements Observer{
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

    @Override
    public void notify(Observable observable, String message) {

    }
}
