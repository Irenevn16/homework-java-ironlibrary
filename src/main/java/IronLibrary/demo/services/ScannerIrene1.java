package IronLibrary.demo.services;
import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScannerIrene implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    LibraryService libraryService;

    public static void main(String[] args) {
        SpringApplication.run(ScannerIrene.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //aqui ponemos while loop menu
        Scanner scanner = new Scanner(System.in);
        boolean continueRunning = true;

        while (continueRunning) {
            System.out.println("5.List all books along with author");
            System.out.println("6. Issue book to student");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 5:
                    System.out.println("This is the list for all books available and their corresponding authors: " + authorRepository.findAllByAuthor());
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

                    libraryService.issueBookToStudent(usn, name, isbn);
                    break;
            }
        } //metamos default con invalid choice
        //habra que cerrar el bucle con un running = false en el exit
        scanner.close();
        System.exit(0);
    }
}
