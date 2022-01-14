package com.bookshop;

import com.bookshop.DB.*;
import com.bookshop.Entities.*;

import java.util.List;
import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        User user = new EmptyUser();

        while (run) {
            System.out.println("---------------------- Home ----------------------");
            System.out.println("1 - Books");
            System.out.println("2 - Authors");
            System.out.println("3 - Genres");
            System.out.println("4 - Publishers");
            System.out.println("5 - User Area");
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
                    user = userMenu(scanner, user);
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

                    Person newAuthor = new Author().named(name).emailAddress(email).phoneNumber(phone);

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

                    Person newPublisher = new Publisher().named(name).emailAddress(email).phoneNumber(phone);

                    new PublisherDAO().persist(newPublisher);
                    break;

                case "2":
                    List<Person> publishers = new PublisherDAO().getAll();

                    for(Person publisher : publishers) {
                        System.out.println("ID: " + publisher.getId() + " - Name: " + publisher.getName() + " - Email: " + publisher.getEmail());
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
                    new BookDAODecorator().persist(newBook);

                    String notifyMessage = "The book '" + newBook.getTitle() + "' is now available! Written by: " + newBook.writtenBy();
                    newBook.addObserver(user);
                    newBook.notify(notifyMessage);


                    break;

                case "2":
                    List<Book> books = new BookDAODecorator().getAll();

                    for(Book b : books) {
                        System.out.println("ID: " + b.getId() + " - Title: " + b.getTitle());
                    }

                    break;

                case "3":
                    System.out.println("Type book id: ");
                    int bookId = scanner.nextInt();

                    Book book = new BookDAODecorator().get(bookId);
                    new BookDAODecorator().remove(book);

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

        Book newBook = new Book().entitled(title).numberOfPages(pages).priced(price);

        addAuthorBook(newBook, scanner);
        addGenreBook(newBook, scanner);

//        Set Publisher
        List<Person> publishers = new PublisherDAO().getAll();

        for (Person p : publishers) {
            System.out.println("ID: " + p.getId() + " - Name: " + p.getName());
        }

        System.out.println("Type publisher id: ");
        int publisherId = scanner.nextInt();

        for (Person p : publishers) {
            if (publisherId == p.getId()) {
                newBook.publishedBy((Publisher) p);
                System.out.println(newBook.getPublisher().getName());
                break;
            }
        }

        System.out.println("Book Publisher: " + newBook.getPublisher().getName());
        return newBook;
    }

    private static Book addAuthorBook(Book book, Scanner scanner) {
        List<Person> authors = new AuthorDAO().getAll();
        boolean loop = true;

        Scanner numScan = new Scanner(System.in);

        if (authors != null) {
            for (Person a : authors) {
                System.out.println("ID: " + a.getId() + " - Name: " + a.getName());
            }

            do {
                System.out.println("Type author ID: ");
                int id = scanner.nextInt();

                for (Person a : authors) {
                    if (a.getId() == id) {
                        book.addAuthor((Author) a);
                        break;
                    }
                }

                System.out.println("Add another author? (Y/N)");
                String continueLoop = numScan.nextLine();

                if (continueLoop.equalsIgnoreCase("n"))
                    loop = false;

            } while (loop);
        }

        return book;
    }

    private static Book addGenreBook(Book book, Scanner scanner) {
        List<Genre> genres = new GenreDAO().getAll();
        boolean loop = true;

        for (Genre g : genres) {
            System.out.println("Genre: " + g.getName());
        }

        do {
            System.out.println("Genre to add: ");
            String genreName = scanner.nextLine();

            for (Genre g : genres) {
                if (g.getName() == genreName) {
                    book.addGenre(g);
                    break;
                }
            }

            System.out.println("Add another genre? (Y/N)");
            String continueLoop = scanner.nextLine();

            if (continueLoop.equalsIgnoreCase("n"))
                loop = false;

        } while (loop);

        return book;
    }

    private static User userMenu(Scanner scanner, User user) {
        boolean run = true;
        CommandExecutor commandExecutor = new CommandExecutor();

        while (run) {
            System.out.println("---------------------- User ----------------------");
            System.out.println("1 - Show Library");
            System.out.println("2 - Add book to library");
            System.out.println("3 - Remove book from your library");
            System.out.println("4 - Highest price book");
            System.out.println("5 - Lowest price book");
            System.out.println("6 - Average price");
            System.out.println("7 - Total Spent");

            if (userIsLogged(user)) {
                System.out.println("8 - LogOut");
            } else {
                System.out.println("8 - SignIn");
                System.out.println("9 - Register");
            }

            System.out.println("10 - Back");

            System.out.println("Type your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    user.showLibrary();
                    break;

                case "2":
                    List<Book> books = new BookDAODecorator().getAll();
                    for(Book b : books)
                        System.out.println("ID: " + b.getId() + " - Title: " + b.getTitle());

                    System.out.println("Type book id: ");
                    int bookId = scanner.nextInt();

                    try {
                        Book book = new BookDAODecorator().get(bookId);
                        commandExecutor.execute(new AddBookCommand(user), book);

                        new UserDAODecorator().persist(user);
                    } catch (Exception e) {
                        System.err.println(e);
                    }

                    break;

                case "3":
                    user.showLibrary();

                    System.out.println("Book ID to remove: ");
                    bookId = scanner.nextInt();

                    try {
                        Book book = new BookDAODecorator().get(bookId);
                        commandExecutor.execute(new RemoveBookCommand(user), book);

                        new UserDAODecorator().persist(user);
                    } catch (Exception e) {
                        System.err.println(e);
                    }

                    break;

                case "4":
                    user.setCalculateStrategy(new HighestPrice());

                    System.out.println("Highest price: " + user.calculatePrices());
                    break;

                case "5":
                    user.setCalculateStrategy(new LowestPrice());

                    System.out.println("Lowest price: " + user.calculatePrices());
                    break;

                case "6":
                    user.setCalculateStrategy(new AveragePrice());

                    System.out.println("Average price: " + user.calculatePrices());
                    break;

                case "7":
                    user.setCalculateStrategy(new TotalSpent());

                    System.out.println("Total Spent: " + user.calculatePrices());
                    break;

                case "8":
                    if (userIsLogged(user))
                        user = new EmptyUser();
                    else {
                        System.out.println("Email: ");
                        String email = scanner.nextLine();

                        System.out.println("Password: ");
                        String password = scanner.nextLine();

                        User auxUser = new UserState().emailAddress(email).passwordIs(password);
                        auxUser = new UserDAODecorator().get(auxUser);

                        if (auxUser == null)
                            System.err.println("Email or password incorrect! Try again.");
                        else
                            user = auxUser;
                    }

                    break;

                case "9":
                    System.out.println("Email: ");
                    String email = scanner.nextLine();

                    System.out.println("Password: ");
                    String password = scanner.nextLine();

                    try {
                        User newUser = new UserState().emailAddress(email).passwordIs(password);

                        new UserDAODecorator().persist(newUser);
                        user = newUser;
                    } catch (Exception e) {
                        System.err.println(e);
                    }

                    break;

                case "10":
                    run = false;
                    break;

                default:
                    System.out.println("Option not available!");
                    break;
            }
        }

        return user;
    }

    private static boolean userIsLogged(User user) {
        if (!(user.getLibrary() == null))
            return true;

        return false;
    }
}






















