package com.bookshop.DB;

import com.bookshop.Entities.Book;

import java.util.List;

public class BookDAODecorator implements InterfaceDAO<Book> {
    private static InterfaceDAO bookDAO;

    private InterfaceDAO getBookDAO() {
        if (bookDAO == null)
            bookDAO = new BookDAOProxy();

        return bookDAO;
    }

    @Override
    public void persist(Book book) throws Exception {
        getBookDAO().persist(book);
    }

    @Override
    public void remove(Book book) {
        getBookDAO().remove(book);
    }

    @Override
    public Book get(Object pk) throws Exception {
        return null;
    }

    @Override
    public List<Book> getAll() {
        return null;
    }
}
