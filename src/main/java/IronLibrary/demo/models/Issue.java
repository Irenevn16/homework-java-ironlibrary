package IronLibrary.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Issue")

public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private int issueId;

    @Column(name = "issue_date")
    private LocalDate issueDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @OneToOne
    @JoinColumn(name = "issue_student", referencedColumnName = "usn")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "issue_book", referencedColumnName = "isbn")
    private Book issueBook;


    public Issue() {
    }

    public Issue(LocalDate issueDate, LocalDate returnDate, Student issueStudent, Book issueBook) {
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.issueStudent = issueStudent;
        this.issueBook = issueBook;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public LocalDate getIssueLocalDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueLocalDate) {
        this.issueDate = issueLocalDate;
    }

    public LocalDate getReturnLocalDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnLocalDate) {
        this.returnDate = returnLocalDate;
    }

    public Student getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(Student issueStudent) {
        this.issueStudent = issueStudent;
    }

    public Book getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(Book issueBook) {
        this.issueBook = issueBook;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId=" + issueId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                ", issueStudent='" + issueStudent + '\'' +
                ", issueBook='" + issueBook + '\'' +
                '}';
    }
}
