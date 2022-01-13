package com.bookshop.DB;

import com.bookshop.Entities.User;

import javax.persistence.EntityManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class UserDAOProxy implements InterfaceDAO<User> {
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
        EntityManager em = UtilDB.getEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e);
        }
    }

    @Override
    public User get(Object pk) throws Exception {
        Method getEmailMethod = pk.getClass().getMethod("getEmail", null);
        User user = UtilDB.getEntityManager().find(User.class, getEmailMethod.invoke(pk));

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> users = UtilDB.getEntityManager().createQuery("SELECT u FROM User u").getResultList();
        return users;
    }
}
