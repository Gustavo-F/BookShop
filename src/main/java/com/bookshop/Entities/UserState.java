package com.bookshop.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserState extends User{
    public UserState(String email, String password) {
        super(email, password);
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
    public List<Book> getLibrary() {
        if (this.library == null)
            this.library = new ArrayList<Book>();

        return this.library;
    }

    @Override
    public void addBook(Book book) {
        this.getLibrary().add(book);
    }

    @Override
    public void removeBook(Book book) {
        this.getLibrary().remove(book);
    }

    @Override
    public List<Author> getFavoriteAuthors() {
        if (favoriteAuthors == null)
            this.favoriteAuthors = new ArrayList<Author>();

        return this.favoriteAuthors;
    }

    @Override
    public void addFavoriteAuthor(Author author) {
        this.getFavoriteAuthors().add(author);
    }

    @Override
    public void removeFavoriteAuthor(Author author) {
        this.getFavoriteAuthors().remove(author);

    }

    @Override
    public void notify(Observable observable, String message) {
        System.out.println(message);
    }
}
