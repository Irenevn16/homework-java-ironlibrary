package IronLibrary.demo.services;

import IronLibrary.demo.IronLibraryApplication;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Student;
import IronLibrary.demo.repositories.BookRepository;
import IronLibrary.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication

public class ScannerAngela implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(IronLibraryApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Bienvenido a nuestra app de libros");

        java.util.Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("7.List books by USN");
            System.out.println("8. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 7:
                    System.out.println("You choosed searching books by USN.");
                    System.out.println("Please, enter a USN number:");
                    String usn = scanner.nextLine();
                    List<Book> books = bookRepository.findBookTitlesByStudentUsn(usn);
                    Student student = studentRepository.findStudentByUsn(usn);
                    if (books.isEmpty()) {

                    } else {
                        for(Book book: books) {
                            System.out.println("Book Title      Student Name        Return date\n" +
                                   book.getTitle() + "        " +  student.getName() );


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
}