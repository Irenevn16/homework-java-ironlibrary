package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepositoryMiguel extends JpaRepository<Book, String> {
    // List books by usn:
    List<Book> findBooksByUsn (String usn);
}
