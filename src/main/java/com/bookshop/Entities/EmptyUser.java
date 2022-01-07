package com.bookshop.Entities;

import java.util.List;

public class EmptyUser extends User {
    @Override
    public void addBook(Book book) {

    }

    @Override
    public void removeBook(Book book) {

    }

    @Override
    public List<Author> getFavoriteAuthors() {
        return null;
    }

    @Override
    public void addFavoriteAuthor(Author author) {

    }

    @Override
    public void removeFavoriteAuthor(Author author) {

    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public List<Book> getLibrary() {
        return null;
    }

    @Override
    public void notify(Observable observable, String message) {

    }
}
