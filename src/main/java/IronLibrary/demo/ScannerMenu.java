package IronLibrary.demo;
import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Issue;
import IronLibrary.demo.models.Student;
import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import IronLibrary.demo.repositories.IssueRepository;
import IronLibrary.demo.repositories.StudentRepository;
import IronLibrary.demo.services.LibraryService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
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
        SpringApplication.run(ScannerMenu.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //aqui ponemos while loop menu
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;
        while (continueRunning) {
            System.out.println("Welcome to the Iron Library. \nEnter your choice from the menu below:");
            System.out.println(ANSI_PURPLE_BACKGROUND + "1. Add Book"+ ANSI_RESET);
            System.out.println(ANSI_PURPLE_BACKGROUND + "2. Search by title"+ ANSI_RESET);
            System.out.println(ANSI_PURPLE_BACKGROUND + "3. Search by category"+ ANSI_RESET);
            System.out.println(ANSI_PURPLE_BACKGROUND + "4. Search by author"+ ANSI_RESET);
            System.out.println(ANSI_PURPLE_BACKGROUND+ "5.List all books along with author"+ ANSI_RESET);
            System.out.println(ANSI_PURPLE_BACKGROUND + "6. Issue book to student"+ ANSI_RESET);
            System.out.println(ANSI_PURPLE_BACKGROUND + "7.List books by USN" + ANSI_RESET);
            System.out.println("8. Exit"+ ANSI_RESET);



            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("\n1. Add a Book");
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Category: ");
                    String category = scanner.nextLine();

                    System.out.println("How many books are you adding?: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(isbn, title, category, quantity);
                    book.setTitle(title);
                    book.setCategory(category);
                    bookRepository.save(book);

                    System.out.print("Author name: ");
                    String authorName = scanner.nextLine();
                    Optional<Author> author = Optional.ofNullable(authorRepository.findByName(authorName));

                    if (author.isEmpty()) {
                        System.out.println("Author email: ");
                        String email = scanner.nextLine();
                        Author newAuthor = new Author(authorName, email, book);
                        /*author.setName(authorName);
                        author.setEmail(email);
                        author.setAuthorBook(book);*/
                        authorRepository.save(newAuthor);
                        System.out.println("Book added: " + book.getIsbn() + " " + book.getTitle() + " " + book.getCategory() + " " + newAuthor.getName() + " " + newAuthor.getEmail());
                    } else {
                        System.out.println("This author already exists");
                        System.out.println("Book added to author: " + book.getIsbn() + " " + book.getTitle() + " " + book.getCategory() + " " + author.toString());
                    }


                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;


                case 2:
                    System.out.println("\n2. Search by title");
                    System.out.print("Book title: ");
                    title = scanner.nextLine();
                    bookRepository.findByTitle(title).forEach(System.out::println);
                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("\n3. Search by category");
                    System.out.print("Category: ");
                    category = scanner.nextLine();
                    bookRepository.findByCategory(category).forEach(System.out::println);
                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("\n4. Search by author");
                    System.out.print("Author: ");
                    authorName = scanner.nextLine();
                    if (authorName != null) {
                        Author author1 = authorRepository.findByName(authorName);
                        System.out.println("Author's book is: " + author1.getAuthorBook());
                    } else {
                        System.out.println("Author not found.");
                    }
                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println("You chose to list all books along with their author: ");
                    List<Author> authorBookList = authorRepository.findAll();
                    for (Author item: authorBookList ){
                        System.out.println(item.getAuthorBook().getTitle());
                        System.out.println(item.getName());
                    }
                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;

                case 6:
                    System.out.println("You chose to issue a book to a student");
                    System.out.println("Please enter the student's usn: ");
                    String usn = scanner.nextLine();

                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();

                    Student student = new Student(usn, name);
                    studentRepository.save(student);

                    System.out.println("Enter book ISBN: ");
                    String isbnBook = scanner.nextLine();

                    Book bookSaved = bookRepository.findByIsbn(isbnBook);
                    Student studentSaved =  studentRepository.findStudentByUsn(usn);
                    libraryService1.issueBookToStudent(studentSaved, name, bookSaved);

                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;

                case 7:
                    System.out.println("You choosed searching books by USN.");
                    System.out.println("Please, enter a USN number:");
                    usn = scanner.nextLine();
                    List<Book> books = bookRepository.findBookTitlesByStudentUsn(usn);
                    Student student1 = studentRepository.findStudentByUsn(usn);
                    Issue issue = issueRepository.findByIssueStudent(student1);
                    if (books.isEmpty()) {
                        System.out.println("This student doesn't have any book issued");
                    } else {
                        for(Book eachBook: books) {
                            System.out.println("Book Title      Student Name        Return date\n" +
                                    eachBook.getTitle() + "        " + student1.getName() + "        " + issue.getReturnLocalDate());
                            System.out.println("prueba");
                        }
                    }
                    System.out.println("Press any key to return to the main page");
                    scanner.nextLine();
                    break;
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
