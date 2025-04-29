package IronLibrary.demo.models;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "Author")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int authorId;

    private String name;

    private String email;

    @OneToOne
    @JoinColumn(name = "author_book", referencedColumnName = "isbn")
    private Book authorBook;

    public Author() {
    }

    public Author(String name, String email, Book authorBook) {
        this.name = name;
        this.email = email;
        this.authorBook = authorBook;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Book getAuthorBook() {
        return authorBook;
    }

    public void setAuthorBook(Book authorBook) {
        this.authorBook = authorBook;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", authorBook=" + authorBook +
                '}';
    }
}
