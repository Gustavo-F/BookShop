package com.bookshop;

import com.bookshop.DB.GenreDAO;
import com.bookshop.DB.UtilDB;
import com.bookshop.Entities.Genre;
import com.bookshop.Entities.Person;
import com.bookshop.Entities.Publisher;

import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("---------------------- Menu ----------------------");
            System.out.println("1 - Add Genre");
            System.out.println("2 - Add Person");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("New Genre name: ");
                    String genreName = scanner.nextLine();

                    Genre newGenre = new Genre(genreName);
                    new GenreDAO().persist(newGenre);

                    break;
                case "2":

                    break;
                default:
                    System.out.println("No");
                    break;
            }
        }
    }
}