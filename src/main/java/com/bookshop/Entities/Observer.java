package com.bookshop.Entities;

public interface Observer {
    public void notify(Observable observable, String message);
}
