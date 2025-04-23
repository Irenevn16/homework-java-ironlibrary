package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryIrene extends JpaRepository<Book, String> {
    @Modifying //oblig al hacer INSERT
    @Transactional //pq es dinamico
    @Query(value=  "INSERT INTO Book (isbn, title, category, quantity) VALUES (:isbn, :title, :category, :quantity)", nativeQuery = true)
    //nativeQuery = true indica que es SQL nativo, no JPQL
    void addBook(
            @Param("isbn") String isbn,
            @Param("title") String title,
            @Param("category") String category,
            @Param("quantity") int quantity
    ); //como uno esto al add author?

    @Modifying
    @Transactional
    @Query(value=  "INSERT INTO Author (name, email, author_book) VALUES (:name, :email, :author_book)", nativeQuery = true)
        //nativeQuery = true indica que es SQL nativo, no JPQL
    void addAuthor(
            @Param("name") String name,
            @Param("email") String email,
            @Param("authorBook") Book authorBook //mirar esto
    );
    //search book by author
    public Book findByAuthor(Author author);


}
