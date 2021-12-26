package com.bookshop.DB;

import com.bookshop.Entities.Genre;

import javax.persistence.EntityManager;
import java.time.temporal.UnsupportedTemporalTypeException;
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
        EntityManager em = UtilDB.getEntityManager();
        em.getTransaction().begin();
        em.remove(genre);
        em.getTransaction().commit();
    }

    @Override
    public Genre get(Object pk) {
        Genre genre;
        genre = UtilDB.getEntityManager().find(Genre.class, pk);

        return genre;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres;
        genres = UtilDB.getEntityManager().createQuery("SELECT g FROM Genre g").getResultList();

        return genres;
    }
}
