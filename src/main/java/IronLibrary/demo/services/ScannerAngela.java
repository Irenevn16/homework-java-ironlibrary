package IronLibrary.demo.services;

import IronLibrary.demo.IronLibraryApplication;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Issue;
import IronLibrary.demo.models.Student;
import IronLibrary.demo.repositories.BookRepository;
import IronLibrary.demo.repositories.IssueRepository;
import IronLibrary.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;
/*
@SpringBootApplication

public class ScannerAngela implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private IssueRepository issueRepository;

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
        SpringApplication.run(IronLibraryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bienvenido a nuestra app de libros");

        java.util.Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println(ANSI_PURPLE + "7.List books by USN" + ANSI_RESET);
            System.out.println("8. Exit");


            System.out.println(ANSI_PURPLE_BACKGROUND + "Enter your choice:" + ANSI_RESET);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 7:
                    System.out.println("You choosed searching books by USN.");
                    System.out.println("Please, enter a USN number:");
                    String usn = scanner.nextLine();
                    List<Book> books = bookRepository.findBookTitlesByStudentUsn(usn);
                    Student student = studentRepository.findStudentByUsn(usn);
                    Issue issue = issueRepository.findByStudentIssue(student);
                    if (books.isEmpty()) {

                    } else {
                        for(Book book: books) {
                            System.out.println("Book Title      Student Name        Return date\n" +
                                   book.getTitle() + "        " +  student.getName() + "        " + issue.getReturnDate());
                        }
                    }
                    break;
// me falta coger la return date de issue !!!
//                Enter your choice: 7
//                Enter usn : 09003688800
//
//                Book Title          Student Name    Return date
//                Da Vinci Code       John Doe        2022-08-01 16:45:40.636000
//

                case 8:
                    System.out.println("Exiting program...");
                    continueRunning = false;
                    break;
            }
        }
            scanner.close();
            System.exit(0);
    }
}*/