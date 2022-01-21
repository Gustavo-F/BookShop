package com.bookshop.Entities;

import java.util.List;

public class BookFacadeExecutor {
    private BookFacadeInterface book;

    public BookFacadeExecutor(Book book) {
        this.book = book;
    }

    public void add(Genre genre) {
        this.book.addGenre(genre);
    }

    public List<Genre> getAll() {
            return this.book.getAllGenres();
    }
}
