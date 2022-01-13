package com.bookshop.DB;

import java.lang.reflect.Method;
import java.util.List;
import com.bookshop.Entities.User;

public class UserDAODecorator implements InterfaceDAO<User> {
    private static InterfaceDAO userDAO;

    private InterfaceDAO getUserDAO() {
        if (userDAO == null)
            userDAO = new UserDAOProxy();

        return userDAO;
    }

    @Override
    public void persist(User user) throws Exception {
        if (user.getEmail().isBlank())
            throw new Exception("Please enter a valid email address.");
        else if (user.getPassword().isBlank() || user.getPassword().length() < 8)
            throw new Exception("Please enter a valid password. The password must be at least 8 characters.");

        getUserDAO().persist(user);
    }

    @Override
    public void remove(User user) {
        getUserDAO().remove(user);
    }

    @Override
    public User get(Object pk) {
        try {
            User user = new UserDAOProxy().get(pk);

            Method getPasswordMethod = pk.getClass().getMethod("getPassword", null);
            String password = (String) getPasswordMethod.invoke(pk);

            if (user != null && user.getPassword().equals(password))
                return user;

        } catch (Exception e) {
            System.err.println(e);
        }

        return null;
    }

    @Override
    public List<User> getAll() {
        return getUserDAO().getAll();
    }
}
