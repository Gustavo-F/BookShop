package com.bookshop.Entities;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserState extends User{

    @Override
    public User emailAddress(String email) {
        this.email = email;
        return this;
    }

    @Override
    public User passwordIs(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
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
    public void showLibrary() {
        if (getLibrary().size() == 0)
            System.out.println("Your library is empty!");
        else
            for (Book b : getLibrary()) {
                System.out.println("ID: " + b.getId() + " - Title: " + b.getTitle());
            }
    }

    @Override
    public void removeBook(Book book) {
        this.getLibrary().remove(book);
    }

    @Override
    public double calculatePrices() {
        return this.calculateUserLibrary.calculateUserLibraryPrices(this.library);
    }

    @Override
    public void notify(Observable observable, String message) {
        System.out.println(message);
    }
}
