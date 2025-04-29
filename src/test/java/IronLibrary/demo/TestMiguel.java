package IronLibrary.demo;
import static org.junit.jupiter.api.Assertions.*;

import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Issue;
import IronLibrary.demo.repositories.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMiguel {
    @Autowired
    private BookRepository bookRepository;
    //private IssueRepository issueRepository;


    @Test
    @DisplayName("Buscar Libro por USN")
    public void testFindByStudentUsn() {
        Book book1 = new Book();
        book1.setTitle("El mago");
        book1.setIsbn("252");
        bookRepository.save(book1);

        Issue issue = new Issue();
        //issue.setIssueBook("252");
        //issue.setIssueStudent("USN123");
        //issueRepository.save

    }
}
