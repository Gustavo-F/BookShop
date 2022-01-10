package com.bookshop.Entities;

import java.util.List;

public class EmptyUser extends User {
    @Override
    public void addBook(Book book) {
        System.err.println("Login to add books to your library!");
    }

    @Override
    public void removeBook(Book book) {
        System.err.println("Login to remove the book from your library!");
    }

    @Override
    public double calculatePrices() {
        System.err.println("Login to see your spending!");
        return 0;
    }

    @Override
    public String getEmail() {
        return null;
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
    public void showLibrary() {
        System.err.println("Login to view your library!");
    }

    @Override
    public void notify(Observable observable, String message) {

    }
}
