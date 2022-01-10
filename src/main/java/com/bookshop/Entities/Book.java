package com.bookshop.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book implements Observable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int pages;
    private float price;
    @ManyToMany private List<Author> authorList;
    @ManyToMany private List<Genre> genreList;
    @ManyToOne private Publisher publisher;
    @Transient private List<Observer> observers;

    public Book() {

    }

    public Book(String title, int pages, float price) {
        this.title = title;
        this.pages = pages;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void addAuthor(Author author) {
        if (this.authorList == null)
            this.authorList = new ArrayList<Author>();

        this.authorList.add(author);
    }

    public List<Author> getAuthors() {
        return this.authorList;
    }

    public void addGenre(Genre genre) {
        if (this.genreList == null)
            this.genreList = new ArrayList<Genre>();

        this.genreList.add(genre);
    }

    public List<Genre> getGenres() {
        return this.genreList;
    }

    public List<Observer> getObservers() {
        if (observers == null)
            this.observers = new ArrayList<Observer>();

        return observers;
    }

    @Override
    public void addObserver(Observer observer) {
        getObservers().add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        getObservers().remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer o : observers) {
            o.notify(this, message);
        }
    }
}
