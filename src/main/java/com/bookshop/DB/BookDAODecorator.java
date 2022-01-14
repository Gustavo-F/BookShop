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
    public void persist(Book book){
        try {
            getBookDAO().persist(book);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public void remove(Book book) {
        getBookDAO().remove(book);
    }

    @Override
    public Book get(Object pk){
        try {
            return new BookDAOProxy().get(pk);
        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    @Override
    public List<Book> getAll() {
        return getBookDAO().getAll();
    }
}
