package com.bookshop.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book implements Observable, BookFacadeInterface<Genre> {
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

    public Book entitled(String title) {
        this.title = title;
        return this;
    }

    public Book priced(float price) {
        this.price = price;
        return this;
    }

    public Book numberOfPages(int pages) {
        this.pages = pages;
        return this;
    }

    public Book publishedBy(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getTitle() {
        return title;
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

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Author> getAuthors() {
        if (this.authorList == null)
            this.authorList = new ArrayList<Author>();

        return this.authorList;
    }

    public void addAuthor(Author author) {
        this.getAuthors().add(author);
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

    public List<Genre> getGenresList() {
        if (genreList == null)
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

    public int getId() {
        return this.id;
    }

    @Override
    public void addGenre(Genre genre) {
        this.getGenresList().add(genre);
    }

    @Override
    public List<Genre> getAllGenres() {
        return getGenresList();
    }
    
    public void addProperties(Wishlist wishlist) {
    	wishlist.addPropertie(WishlistProperties.PRICE, price);
    	wishlist.addPropertie(WishlistProperties.PAGES, pages);
    }
}
