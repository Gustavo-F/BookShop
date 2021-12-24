package com.bookshop.Entities;

import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    private String username;
    private String password;
    private List<Book> library;

    public void addBook(Book book) {
        if (this.library == null)
            this.library = new ArrayList<Book>();

        this.library.add(book);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
