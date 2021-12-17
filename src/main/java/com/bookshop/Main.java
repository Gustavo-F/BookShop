package com.bookshop;

import com.bookshop.Entities.*;

public class Main {
    public static void main(String[] args) {
        Publisher pa = new Publisher();
        pa.setName("Publisher A");

        Author ab = new Author();
        ab.setName("Adalberto");

        Book b = new Book();
        b.setTitle("Book Title");
        b.addAuthor(ab);
        b.setPublisher(pa);

        System.out.println(b.getTitle());
    }
}