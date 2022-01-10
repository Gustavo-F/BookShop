package com.bookshop.DB;

import com.bookshop.Entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO implements InterfaceDAO<User> {
    @Override
    public void persist(User user) {
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public void remove(User user) {

    }

    @Override
    public User get(Object pk) {
        User user = UtilDB.getEntityManager().find(User.class, pk);

        return user;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
