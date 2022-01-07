package com.bookshop.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class User implements Observer{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String email;
    private String password;
    @ManyToMany protected List<Book> library;
    @ManyToMany protected List<Author> favoriteAuthors;

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public abstract String getUsername();

    public abstract String getPassword();

    public abstract List<Book> getLibrary();

    public abstract void addBook(Book book);

    public abstract void removeBook(Book book);

    public abstract List<Author> getFavoriteAuthors();

    public abstract void addFavoriteAuthor(Author author);

    public abstract void removeFavoriteAuthor(Author author);
}
