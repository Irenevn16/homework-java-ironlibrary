package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepositoryMiguel extends JpaRepository<Book, String> {
    // List books by usn:
    @Query(value = "SELECT Book.tittle FROM Book " +
            "INNER JOIN Issue ON Book.isbn = Issue.issue_book " +
            "WHERE Issue.issue_student = :usn",
            nativeQuery = true)
    List<String> findBookTitlesByStudentUsn(@Param("usn") String usn);
}
