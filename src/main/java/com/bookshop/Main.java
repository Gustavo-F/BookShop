package com.bookshop;

import com.bookshop.DB.AuthorDAO;
import com.bookshop.DB.BookDAO;
import com.bookshop.DB.GenreDAO;
import com.bookshop.DB.PublisherDAO;
import com.bookshop.Entities.*;

import java.util.List;
import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        User user = new UserState("gustavo@email.com", "12345");
        user.addFavoriteAuthor((Author) new AuthorDAO().get(2));

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
                    booksMenu(scanner, user);
                    break;

                case "2":
                    authorsMenu(scanner);
                    break;

                case "3":
                    genresMenu(scanner);
                    break;

                case "4":
                    publishersMenu(scanner);
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

                    Genre genre = new GenreDAO().get(genreName);

                    new GenreDAO().remove(genre);
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
                    List<Person> authors = new AuthorDAO().getAll();

                    for(int i = 0; i < authors.size(); i++) {
                        System.out.println("ID: " + authors.get(i).getId() + " - Name: " + authors.get(i).getName());
                    }
                    break;

                case "3":
                    System.out.println("Type the author id: ");
                    int authorId = scanner.nextInt();

                    Person author = new AuthorDAO().get(authorId);
                    new AuthorDAO().remove(author);

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

    private static void publishersMenu(Scanner scanner) {
        boolean run = true;

        while (run) {
            System.out.println("---------------------- Publishers ----------------------");
            System.out.println("1 - Add Publisher");
            System.out.println("2 - List Publishers");
            System.out.println("3 - Remove Publisher");
            System.out.println("4 - Back");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Publisher Name: ");
                    String name = scanner.nextLine();

                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Phone: ");
                    String phone = scanner.nextLine();

                    Person newPublisher = new Publisher(name, email, phone);
                    new PublisherDAO().persist(newPublisher);

                    break;

                case "2":
                    List<Person> publishers = new PublisherDAO().getAll();

                    for(int i = 0; i < publishers.size(); i++) {
                        System.out.println("ID: " + publishers.get(i).getId() + " - Name: " + publishers.get(i).getName());
                    }
                    break;

                case "3":
                    System.out.println("Type the publisher id: ");
                    int publisherId = scanner.nextInt();

                    Person publisher = new PublisherDAO().get(publisherId);
                    new PublisherDAO().remove(publisher);

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

    private static void booksMenu(Scanner scanner, User user) {
        boolean run = true;

        while(run) {
            System.out.println("---------------------- Books ----------------------");
            System.out.println("1 - Add Book");
            System.out.println("2 - List Books");
            System.out.println("3 - Remove Book");
            System.out.println("4 - Back");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Book newBook = createBook(scanner);
                    new BookDAO().persist(newBook);

                    if (newBook.getAuthors() != null) {
                        newBook.addObserver(user);
                        newBook.notify("Book added!");
                    }

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

    private static Book createBook(Scanner scanner) {
        System.out.println("Title: ");
        String title = scanner.nextLine();

        System.out.println("Pages: ");
        int pages = scanner.nextInt();

        System.out.println("Price");
        float price = scanner.nextFloat();

        Book newBook = new Book(title, pages, price);

        System.out.println("Add authors? (Y/N)");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("y"))
            addAuthorBook(newBook, scanner);

        return newBook;
    }

    private static Book addAuthorBook(Book book, Scanner scanner) {
        List<Person> authors = new AuthorDAO().getAll();

        if (authors != null) {
            for (Person a : authors) {
                System.out.println("ID: " + a.getId() + " - Name: " + a.getName());
            }

            System.out.println("Type author ID: ");
            int id = scanner.nextInt();

            for (Person a : authors) {
                if (a.getId() == id) {
                    book.addAuthor((Author) a);
                    break;
                }
            }
        }

        return book;
    }
}






















