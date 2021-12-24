package com.bookshop.Entities;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private int pages;
    private float price;
    private List<Author> authorList;
    private List<Genre> genreList;
    private Publisher publisher;

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
}
