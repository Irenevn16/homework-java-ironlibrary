package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Issue;
import IronLibrary.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Integer> {
  Issue findByIssueStudent (Student issueStudent);
}
