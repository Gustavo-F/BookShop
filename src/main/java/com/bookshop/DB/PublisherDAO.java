package com.bookshop.DB;

import com.bookshop.Entities.NullPerson;
import com.bookshop.Entities.Person;
import com.bookshop.Entities.Publisher;

import javax.persistence.EntityManager;
import java.util.List;

public class PublisherDAO implements InterfaceDAO<Person> {
    @Override
    public void persist(Person publisher) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(publisher);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        }
    }

    @Override
    public void remove(Person publisher) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(publisher);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(publisher.getName());
        }
    }

    @Override
    public Person get(Object pk) {
        Person publisher = UtilDB.getEntityManager().find(Publisher.class, pk);

        if (publisher == null)
            publisher = new NullPerson();

        return publisher;
    }

    @Override
    public List<Person> getAll() {
        List<Person> publishers = UtilDB.getEntityManager().createQuery("SELECT p FROM Publisher p").getResultList();
        return publishers;
    }
}
