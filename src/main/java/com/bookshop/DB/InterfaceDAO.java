package com.bookshop.DB;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface InterfaceDAO<T> {
    public void persist(T t) throws Exception;

    public void remove(T t);

    public T get(Object pk) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    public List<T> getAll();
}
