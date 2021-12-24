package com.bookshop.Entities;

public class NullPerson extends Person{
    @Override
    public String getName() {
        return  "Person Not Found!";
    }

    @Override
    public String getEmail() {
        return "Person Not Found!";
    }

    @Override
    public String getPhone() {
        return "Person Not Found!";
    }
}
