package com.bookshop.DB;

import com.bookshop.Entities.Person;

import javax.persistence.EntityManager;
import java.util.List;

public class PersonDAO implements InterfaceDAO<Person> {

    @Override
    public void persist(Person person) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Person \"" + person.getName() + "\" already exists!");
        }
    }

    @Override
    public void remove(Person person) {

    }

    @Override
    public Person get(Object pk) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }
}
