package IronLibrary.demo;


import IronLibrary.demo.repositories.AuthorRepository;
import IronLibrary.demo.repositories.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // usa tu DB o H2 si configuras una
@Transactional

public class RepositoryTestAngela {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    @DisplayName("Search book by title")

    @Test
    @DisplayName("Search book by category")

    @Test
    @DisplayName("List all books along with author")
}
