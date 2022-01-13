package com.bookshop.DB;

import com.bookshop.Entities.Book;

import javax.persistence.EntityManager;
import java.util.List;

public class BookDAOProxy implements InterfaceDAO<Book> {
    @Override
    public void persist(Book book) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        }
    }

    @Override
    public void remove(Book book) {
        EntityManager em = UtilDB.getEntityManager();
        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
    }

    @Override
    public Book get(Object pk) {
        Book book = UtilDB.getEntityManager().find(Book.class, pk);
        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> books = UtilDB.getEntityManager().createQuery("SELECT b FROM Book b").getResultList();

        return books;
    }
}
