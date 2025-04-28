package IronLibrary.demo.services;
import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ServiceMiguel {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    //Agregar un libro
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    //Buscar libro por título
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    //Buscar libro por categoría
    public List<Book> findBooksByCategory(String category) {
        return bookRepository.findByCategory(category);
    }

    //Buscar libro por autor
    public List<Book> findBooksByAuthor(String authorName) {
        Author author = authorRepository.findByName(authorName);
        if (author != null) {
            return bookRepository.findByAuthor(author);
        } else {
            return null;
        }
    }
}
