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
        this.getAuthors().add(author);
    }

    public List<Author> getAuthors() {
        if (this.authorList == null)
            this.authorList = new ArrayList<Author>();

        return this.authorList;
    }

    public String writtenBy() {
        if (this.getAuthors().size() == 1)
            return this.getAuthors().get(0).getName();

        String aux = "";
        for (int i = 0; i < this.getAuthors().size(); i++) {
            if ( i < (this.getAuthors().size() - 2)) {
                aux.concat(this.getAuthors().get(i).getName() + ", ");
            } else if ( i == (this.getAuthors().size() - 2)) {
                aux.concat(this.getAuthors().get(i).getName() + " and ");
            } else {
                aux.concat(this.getAuthors().get(i).getName());
            }
        }

        return aux;
    }

    public void addGenre(Genre genre) {
        this.getGenres().add(genre);
    }

    public List<Genre> getGenres() {
        if (this.genreList == null)
            this.genreList = new ArrayList<Genre>();

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
