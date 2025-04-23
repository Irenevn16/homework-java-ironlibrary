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

    @Column(name = "issue_student")
    private String issueStudent;

    @Column(name = "issue_book")
    private String issueBook;

    public Issue() {
    }

    public Issue(Date issueDate, Date returnDate, String issueStudent, String issueBook) {
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

    public String getIssueStudent() {
        return issueStudent;
    }

    public void setIssueStudent(String issueStudent) {
        this.issueStudent = issueStudent;
    }

    public String getIssueBook() {
        return issueBook;
    }

    public void setIssueBook(String issueBook) {
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
