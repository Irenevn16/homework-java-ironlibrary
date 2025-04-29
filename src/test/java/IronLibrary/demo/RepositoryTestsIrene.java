package IronLibrary.demo;

import IronLibrary.demo.models.Student;
import IronLibrary.demo.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.repositories.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional

public class RepositoryTestsIrene {
    private static final Logger log = LoggerFactory.getLogger(RepositoryTestsIrene.class);
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;


    @Test
    @DisplayName("añade un libro")
    public void addBookCorrectly(){
        Book book = new Book("895-755-121", "El Quijote", "Drama", 5);
        List<Book> bookList = new ArrayList<>();
        bookList.add(book); //addBook o add?
        System.out.println("New book added: " + book);
    }
    @Test
    @DisplayName("añade un autor")
    public void addAuthorCorrectly(){
        Author author = new Author("Isabel Allende", "isabel.allende@example.com", new Book("978-0061120060", "La casa de los espíritus", "Novela", 3));
        List<Author> authorList = new ArrayList<>();
        authorList.add(author); //addBook o add?
        System.out.println("New book added: " + author);
    }

    @Test
    @DisplayName("comprobando si encuentra un libro por su autor")
    public void findByAuthorReturnsCorrectBook(){
        authorRepository.findByAuthor(new Author("Isabel Allende", "isabel.allende@example.com", new Book("978-0061120060", "La casa de los espíritus", "Novela", 3)));
       // System.out.println("");//?
    }
    @Test
    @DisplayName("comprobando si se añade el libro al estudiante")
    public void testIssueBookToStudent(){

        //tengo que hacer la parte de insert book y luego insert student
        String usn = "123ABC";
        String name = "John Doe";

        bookRepository.insertStudent(usn, name);

        bookRepository.addBook("879998-45", "Biography", "Drama", 1);



    }
    /*
    @Query(value = "INSERT INTO Student (usn, name) VALUES (:usn, :name)", nativeQuery = true)
    void insertStudent(@Param("usn") String usn, @Param("name") String name);
    */

}
