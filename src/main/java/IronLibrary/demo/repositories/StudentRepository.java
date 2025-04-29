package IronLibrary.demo.repositories;

import IronLibrary.demo.models.Book;
import IronLibrary.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Student findStudentByUsn(String usn);

}
