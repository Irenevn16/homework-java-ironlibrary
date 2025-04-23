package IronLibrary.demo.models;
import jakarta.persistence.*;

@Entity
@Table (name= "student")
public class Student { //lo de inherot?

    @Id
    private String usn; //Universal Student Number-unique identifier

    private String name;

    public Student(){

    }

    public Student(String usn, String name) {
        this.usn = usn;
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "usn='" + usn + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
