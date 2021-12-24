package com.bookshop;

import com.bookshop.DB.UtilDB;
import com.bookshop.Entities.Person;
import com.bookshop.Entities.Publisher;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Publisher name: ");
        String publisherName = scanner.nextLine();

        Person p1 = new Publisher();
        p1.setName(publisherName);

        System.out.println(p1.getName());

        System.out.println(UtilDB.getEntityManager());
    }
}