package com.bookshop.DB;

import com.bookshop.Entities.Author;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorDAO implements InterfaceDAO<Author> {

    @Override
    public void persist(Author author) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Author already exists!");
        }
    }

    @Override
    public void remove(Author author) {

    }

    @Override
    public Author get(Object pk) {
        return null;
    }

    @Override
    public List<Author> getAll() {
        List<Author> authors = UtilDB.getEntityManager().createQuery("SELECT a FROM Author a").getResultList();

        return authors;
    }
}
