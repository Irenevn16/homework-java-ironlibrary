package IronLibrary.demo;
import static org.junit.jupiter.api.Assertions.*;

import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Issue;
import IronLibrary.demo.repositories.BookRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMiguel {
    @Autowired
    private BookRepository bookRepository;
    //private IssueRepository issueRepository;


    @Test
    @DisplayName("Buscar Libro por USN")
    public void testFindBookTitlesByStudentUsn() {
        String usn = "978-0140449136";
        List<Book> titles = bookRepository.findBookTitlesByStudentUsn(usn);
        assertNotNull(titles);
        assertFalse(titles.isEmpty(), "No se encontraron libros emitidos para el USN dado");

        for (Book title : titles) {
            System.out.println(title);
        }
    }

}
