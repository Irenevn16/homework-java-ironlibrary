package IronLibrary.demo.services;

import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public class LibraryService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public void issueBookToStudent (String usn, String name, String isbn) {
        bookRepository.insertStudent(usn, name);

        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = issueDate.plusDays(30);

        bookRepository.insertIssue(
                issueDate.toString(),
                returnDate.toString(),
                usn,
                isbn
        );

    }


    @Transactional
    public void addBookAndAuthor(String isbn, String title, String category, int quantity, String authorName, String authorEmail) {
        //insertar libro
        bookRepository.addBook(isbn, title, category, quantity);
        //insertar autor
        authorRepository.addAuthor(authorName, authorEmail, authorBook); //como lo enlazo a book?
        //como hacemos que se conecten con la foreign key? existe tabla author book


        System.out.println("Book and author had been added correctly");
    }
}
