package IronLibrary.demo.services;
import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Issue;
import IronLibrary.demo.models.Student;
import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import IronLibrary.demo.repositories.IssueRepository;
import IronLibrary.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScannerMenu implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    LibraryService1 libraryService1;
    @Autowired
    IssueRepository issueRepository;
    @Autowired
    StudentRepository studentRepository;

    //PALETA DE COLORES TERMINAL
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void main(String[] args) {
        SpringApplication.run(Scanner.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //aqui ponemos while loop menu
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Search by title");
            System.out.println("3. Search by category");
            System.out.println("4. Search by author");
            System.out.println("5.List all books along with author");
            System.out.println("6. Issue book to student");
            System.out.println(ANSI_PURPLE + "7.List books by USN" + ANSI_RESET);
            System.out.println("8. Exit");

            System.out.println(ANSI_PURPLE_BACKGROUND + "Enter your choice:" + ANSI_RESET);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.print("Author: ");
                    String authorName = scanner.nextLine();

                    Author author = authorRepository.findByName(authorName);
                    if (author == null) {
                        author = new Author();
                        author.setName(authorName);
                        authorRepository.save(author);
                    }

                    Book book = new Book();
                    book.setTitle(title);
                    book.setCategory(category);
                    author.setName(authorName);
                    bookRepository.save(book);

                    System.out.println("Book added");


                case 2:
                    System.out.print("Book title: ");
                    title = scanner.nextLine();
                    bookRepository.findByTitle(title).forEach(System.out::println);


                case 3:
                    System.out.print("Category: ");
                    category = scanner.nextLine();
                    bookRepository.findByCategory(category).forEach(System.out::println);

                case 4:
                    System.out.print("Author: ");
                    authorName = scanner.nextLine();
                    if (authorName != null) {
                        bookRepository.findByAuthor(authorName).forEach(System.out::println);
                    } else {
                        System.out.println("Author not found.");
                    }

                case 5:
                    System.out.println("This is the list for all books available and their corresponding authors: " + authorRepository.findAllBooksWithAuthor());
                    //hay que corregir el metodo
                    break;

                case 6:
                    System.out.println("You chose to issue a book to a student");
                    System.out.println("Please enter the student's usn: ");
                    String usn = scanner.nextLine();

                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.println("Enter book ISBN: ");
                    String isbn = scanner.nextLine();

                    libraryService1.issueBookToStudent(usn, name, isbn);
                    break;

                case 7:
                    System.out.println("You choosed searching books by USN.");
                    System.out.println("Please, enter a USN number:");
                    usn = scanner.nextLine();
                    List<Book> books = bookRepository.findBookTitlesByStudentUsn(usn);
                    Student student = studentRepository.findStudentByUsn(usn);
                    Issue issue = issueRepository.findByStudentIssue(student);
                    if (books.isEmpty()) {
                        System.out.println("This student doesn't have any book issued");
                    } else {
                        for(Book eachBook: books) {
                            System.out.println("Book Title      Student Name        Return date\n" +
                                    eachBook.getTitle() + "        " +  student.getName() + "        " + issue.getReturnDate());
                        }
                    }
                case 8:
                    System.out.println("Exiting program...");
                    continueRunning = false;
                    break;

                default: System.out.println("Option not recognized.");
            }
        }

        scanner.close();
        System.exit(0);
    }
}
