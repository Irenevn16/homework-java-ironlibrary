package IronLibrary.demo.repositories;
import IronLibrary.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepositoryAngela extends JpaRepository<Book, Integer> {
//    Search book by title: This action is responsible for searching a book by title.
    Book findBookByTitle(String title);

//    Search book by category: This action is responsible for searching a book by category.
    Book findBookByCategory(String category);

//List all books along with author: This action is responsible for listing all the books available and there corresponding authors.
    List<Book> findAllByAuthor(String author);



}
