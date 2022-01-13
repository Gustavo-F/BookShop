package com.bookshop.Entities;

import javax.persistence.*;
import java.util.List;

@Entity
public abstract class User implements Observer{
    @Id @Column(unique = true) protected String email;
    protected String password;
    @ManyToMany protected List<Book> library;
    @Transient protected CalculateUserLibrary calculateUserLibrary;

    public abstract User emailAddress(String email);

    public abstract User passwordIs(String password);

    public abstract String getEmail();

    public abstract String getPassword();

    public abstract List<Book> getLibrary();

    public abstract void showLibrary();

    public abstract void addBook(Book book);

    public abstract void removeBook(Book book);

    public void setCalculateStrategy(CalculateUserLibrary strategy) {
        this.calculateUserLibrary = strategy;
    }

    public abstract double calculatePrices();
}
