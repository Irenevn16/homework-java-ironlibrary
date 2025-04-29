package IronLibrary.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Issue")

public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "issue_id")
    private int issueId;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "return_date")
    private Date returnDate;

    //he añadido la relación
    @OneToOne
    @JoinColumn(name = "issue_student", referencedColumnName = "usn")
    private Student issueStudent;

    @OneToOne
    @JoinColumn(name = "issue_book", referencedColumnName = "isbn")
    private Book issueBook;

    /*@OneToOne
    private Student studentIssue;*/

    public Issue() {
    }

    public Issue(Date issueDate, Date returnDate, Student issueStudent, Book issueBook) {
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

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
