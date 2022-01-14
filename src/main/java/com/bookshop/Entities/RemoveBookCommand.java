package com.bookshop.Entities;

import com.bookshop.DB.UserDAODecorator;

import java.util.List;

public class RemoveBookCommand implements LibraryCommands {
    private User user;

    public RemoveBookCommand(User user) {
        this.user = user;
    }

    @Override
    public List<Book> executeLibCommand(Book book) {
        try {
            this.user.removeBook(book);
            new UserDAODecorator().persist(this.user);
        } catch (Exception e) {
            System.err.println(e);
        }

        return this.user.getLibrary();
    }
}
