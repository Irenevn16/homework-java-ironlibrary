package IronLibrary.demo.services;

import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Student;
import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class LibraryService1 {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;


 /*   public LibraryService1(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }*/

    public void issueBookToStudent (Student usn, String name, Book isbn) {
        //bookRepository.insertStudent(usn, name);

        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = issueDate.plusDays(30);

        bookRepository.insertIssue(
                issueDate.toString(),
                returnDate.toString(),
                usn,
                isbn
        );
        System.out.println("Book issued. Return date " + returnDate);

    }


    @Transactional
    public void addBookAndAuthor(String isbn, String title, String category, int quantity, String authorName, String authorEmail, Book authorBook) {
        //insertar libro
        bookRepository.addBook(isbn, title, category, quantity);
        //insertar autor
        authorRepository.addAuthor(authorName, authorEmail, authorBook);


        System.out.println("Book and author had been added correctly");
    }
}
