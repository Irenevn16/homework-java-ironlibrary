package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <Author, Integer> {

    //search book by author
    Book findByAuthor(Author author);

    //List all books along with author: This action is responsible for listing all the books available and there corresponding authors.
    List<Book> findAllByAuthor(String author);

    @Modifying
    @Transactional
    @Query(value=  "INSERT INTO Author (name, email, author_book) VALUES (:name, :email, :author_book)", nativeQuery = true)
        //nativeQuery = true indica que es SQL nativo, no JPQL
    void addAuthor(
            @Param("name") String name,
            @Param("email") String email,
            @Param("authorBook") Book authorBook //mirar esto
    );
}
