package com.bookshop.Entities;

import java.util.List;

public interface BookFacadeInterface<T> {
    public void addGenre(T t);

    public List<T> getAllGenres();
}
