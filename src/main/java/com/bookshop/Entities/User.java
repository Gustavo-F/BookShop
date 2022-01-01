package com.bookshop.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public abstract class User{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String email;
    private String password;
    @ManyToMany private List<Book> library;

    public abstract void addBook(Book book);

    public abstract String getUsername();

    public abstract String getPassword();
}
