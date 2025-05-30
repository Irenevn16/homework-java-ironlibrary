package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Author;
import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    //Add book
    @Modifying
    @Transactional
    @Query(value=  "INSERT INTO Book (isbn, title, category, quantity) VALUES (:isbn, :title, :category, :quantity)", nativeQuery = true)

    void addBook(
            @Param("isbn") String isbn,
            @Param("title") String title,
            @Param("category") String category,
            @Param("quantity") int quantity
    );

    // Search book by title: This action is responsible for searching a book by title.
    Book findBookByTitle(String title);

    //Search book by category: This action is responsible for searching a book by category.
    Book findBookByCategory(String category);

    //Issue book to student
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Student (usn, name) VALUES (:usn, :name)", nativeQuery = true)
    void insertStudent(@Param("usn") String usn, @Param("name") String name);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Issue (issue_date, return_date, issue_student, issue_book) VALUES (:issueDate, :returnDate, :issueStudent, :issueBook)", nativeQuery = true)
    void insertIssue(
            @Param("issueDate") String issueDate,
            @Param("returnDate") String returnDate,
            @Param("issueStudent") Student issueStudent,
            @Param("issueBook") Book issueBook
    );

    // List books by usn:
    @Query(value = "SELECT Book.title FROM Book " +
            "INNER JOIN Issue ON Book.isbn = Issue.issue_book " +
            "WHERE Issue.issue_student = :usn",
            nativeQuery = true)
    List<Book> findBookTitlesByStudentUsn(@Param("usn") String usn);



    List<Book> findByCategory(String category);

    List<Book> findByTitle(String title);

    Book findByIsbn(String isbn);

}
