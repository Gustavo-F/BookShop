package com.bookshop.Entities;

import com.bookshop.DB.UserDAODecorator;

import java.util.List;

public class AddBookCommand implements LibraryCommands {
    private User user;

    public AddBookCommand(User user) {
        this.user = user;
    }

    @Override
    public List<Book> executeLibCommand(Book book) {
        try {
            this.user.addBook(book);
            new UserDAODecorator().persist(this.user);
        } catch (Exception e) {
            System.err.println(e);
        }

        return this.user.getLibrary();
    }
}
