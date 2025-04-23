package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryAngela extends JpaRepository<Book, Integer> {
//    Search book by title
//    Search book by category
//List all books along with author
}
