package com.bookshop.DB;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;

import com.bookshop.Entities.Genre;

public class GenreDAO implements InterfaceDAO<Genre> {
    @Override
    public void persist(Genre genre) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(genre);
            em.getTransaction().commit();

            JsonDB.insert(genre);
        } catch (Exception e ) {
            em.getTransaction().rollback();
            System.err.println(e);
        }
    }

    @Override
    public void remove(Genre genre) {
        EntityManager em = UtilDB.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(genre);
            em.getTransaction().commit();

            JsonDB.remove(genre);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    public Genre get(Object pk) {
        Genre genre = null;

        try {
            Method getGenreName = pk.getClass().getMethod("getName", null);
            String name = (String) getGenreName.invoke(pk);

            genre = UtilDB.getEntityManager().find(Genre.class, name);

            if (genre == null) {
                genre = (Genre) JsonDB.get(name, pk.getClass());
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return genre;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genres = UtilDB.getEntityManager().createQuery("SELECT g FROM Genre g").getResultList();

        return genres;
    }
}
