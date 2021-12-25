package com.bookshop.DB;

import com.bookshop.Entities.Genre;

import javax.persistence.EntityManager;
import java.util.List;

public class GenreDAO implements InterfaceDAO<Genre> {
    @Override
    public void persist(Genre genre) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();
        } catch (Exception e ) {
            em.getTransaction().rollback();
            System.err.println("Genre \"" + genre.getName() + "\" already exists!");
        }
    }

    @Override
    public void remove(Genre genre) {

    }

    @Override
    public Genre get(Object pk) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }
}
