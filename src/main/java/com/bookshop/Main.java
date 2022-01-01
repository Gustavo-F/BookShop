package com.bookshop;

import com.bookshop.DB.AuthorDAO;
import com.bookshop.DB.GenreDAO;
import com.bookshop.Entities.Author;
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
            System.out.println("1 - Books");
            System.out.println("2 - Authors");
            System.out.println("3 - Genres");
            System.out.println("4 - Publishers");
            System.out.println("5 - SignIn/SignUp");
            System.out.println("6 - Exit");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    break;

                case "2":
                    authorsMenu(scanner);
                    break;

                case "3":
                    genresMenu(scanner);
                    break;

                case "4":
                    break;

                case "5":
                    break;

                case  "6":
                    run = false;
                    break;

                default:
                    System.out.println("Option not available!");
                    break;
            }
        }
    }

    private static void genresMenu(Scanner scanner) {
        boolean run = true;
        String genreName;

        while (run) {
            System.out.println("---------------------- Genres ----------------------");
            System.out.println("1 - Add Genre");
            System.out.println("2 - List Genres");
            System.out.println("3 - Remove Genre");
            System.out.println("4 - Back");

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

    private static void authorsMenu(Scanner scanner) {
        boolean run = true;

        while (run) {
            System.out.println("---------------------- Authors ----------------------");
            System.out.println("1 - Add Author");
            System.out.println("2 - List Authors");
            System.out.println("3 - Remove Author");
            System.out.println("4 - Back");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Author Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Phone: ");
                    String phone = scanner.nextLine();

                    Author newAuthor = new Author(name, email, phone);
                    System.out.println(newAuthor.getName());

                    new AuthorDAO().persist(newAuthor);

                    break;

                case "2":
                    break;

                case "3":
                    break;

                case "4":
                    run = false;
                    break;

                default:
                    System.out.println("Option not available!");
                    break;
            }
        }
    }
}






















