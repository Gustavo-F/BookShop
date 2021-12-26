package com.bookshop;

import com.bookshop.DB.GenreDAO;
import com.bookshop.DB.UtilDB;
import com.bookshop.Entities.Genre;
import com.bookshop.Entities.Person;
import com.bookshop.Entities.Publisher;

import java.util.List;
import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("---------------------- Home ----------------------");
            System.out.println("1 - Genre");
            System.out.println("2 - Person");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    genresMenu(scanner);
                    break;
                case "2":

                    break;
                default:
                    System.out.println("No");
                    break;
            }
        }
    }

    private static void genresMenu(Scanner scanner) {
        Boolean run = true;
        String genreName;

        while (run) {
            System.out.println("---------------------- Genres ----------------------");
            System.out.println("1 - Add Genre");
            System.out.println("2 - List Genres");
            System.out.println("3 - Remove Genre");
            System.out.println("4 - Exit");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("New Genre name: ");
                    genreName = scanner.nextLine();

                    Genre newGenre = new Genre(genreName);
                    new GenreDAO().persist(newGenre);

                    break;
                case "2":
                    List<Genre> genres = new GenreDAO().getAll();

                    for (int i = 0; i < genres.size(); i++) {
                        System.out.println(genres.get(i).getName());
                    }

                    break;
                case "3":
                    System.out.println("Genre to remove: ");
                    genreName = scanner.nextLine();

                    Genre genre = new Genre(genreName);
                    new GenreDAO().remove(genre);

                    break;
                case "4":
                    return;
                default:
                    break;
            }
        }
    }
}