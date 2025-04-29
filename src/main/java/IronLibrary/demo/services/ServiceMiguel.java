package IronLibrary.demo.services;
import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
/*
@SpringBootApplication
public class ServiceMiguel implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Search by title");
            System.out.println("3. Search by category");
            System.out.println("4. Search by author");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            String opcion = sc.nextLine();

            if (opcion.equals("0")) break;

            switch (opcion) {
                case "1" -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("Author: ");
                    String authorName = sc.nextLine();

                    Author author = authorRepository.findByName(authorName);
                    if (author == null) {
                        author = new Author();
                        author.setName(authorName);
                        authorRepository.save(author);
                    }

                    Book book = new Book();
                    book.setTitle(title);
                    book.setCategory(category);
                    book.setAuthor(author); // falla por el ManyToOne
                    bookRepository.save(book);

                    System.out.println("Book added");
                }

                case "2" -> {
                    System.out.print("Book title: ");
                    String title = sc.nextLine();
                    bookRepository.findByTitle(title).forEach(System.out::println);
                }

                case "3" -> {
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    bookRepository.findByCategory(category).forEach(System.out::println);
                }

                case "4" -> {
                    System.out.print("Author: ");
                    String authorName = sc.nextLine();
                    Author author = authorRepository.findByName(authorName);
                    if (author != null) {
                        bookRepository.findByAuthor(author).forEach(System.out::println);
                    } else {
                        System.out.println("Author not found.");
                    }
                }

                default -> System.out.println("Option not recognized.");
            }
        }

        System.out.println("Library closed");
    }

}*/