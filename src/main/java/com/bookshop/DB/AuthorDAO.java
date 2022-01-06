package com.bookshop.DB;

import com.bookshop.Entities.Author;
import com.bookshop.Entities.NullPerson;
import com.bookshop.Entities.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorDAO implements InterfaceDAO<Person> {

    @Override
    public void persist(Person author) {
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
    public void remove(Person author) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(author);
            em.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            System.out.println(author.getName());
        }
    }

    @Override
    public Person get(Object pk) {
        Person author = UtilDB.getEntityManager().find(Author.class, pk);

        if (author == null)
            author = new NullPerson();

        return author;
    }

    @Override
    public List<Person> getAll() {
        List<Person> authors = UtilDB.getEntityManager().createQuery("SELECT a FROM Author a").getResultList();
        return authors;
    }
}
