package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepositoryMiguel extends JpaRepository<Book, Integer> {
}
