package com.bookshop.Entities;

public class EmptyUser extends User {
    @Override
    public void addBook(Book book) {

    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public String getPassword() {
        return null;
    }
}
