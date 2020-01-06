package furthertrainingapp.dao;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import furthertrainingapp.student.Adres;
import furthertrainingapp.student.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Repository
public class StudentDAO {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Pawel", "java", new Adres("Krakow", "Nowa", "4")));
                put(2, new Student(2, "Jasio", "Baja", new Adres("Poznan", "Poznanska", "12")));
                put(3, new Student(3, "Kulfon", "Monika", new Adres("Krakow", "Krakowska", "1")));
                put(4, new Student(4, "Werner", "dotnet", new Adres("Warszawa", "Warszawska", "21")));
            }
        };
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void removeStudentById(int id) {
        students.remove(id);
    }

    public void updateStudent(Student student) {
        Student stud = students.get(student.getId());
        stud.setName(student.getName());
        stud.setCourse(student.getCourse());
        stud.getAdres().setMiasto(student.getAdres().getMiasto());
        stud.getAdres().setUlica(student.getAdres().getUlica());
        stud.getAdres().setNumerDomu(student.getAdres().getNumerDomu());
        students.put(student.getId(), student);
    }

    public void updateStudentById(int id, Student student){
        Student stud = students.get(id);
        stud.setName(student.getName());
        stud.setCourse(student.getCourse());
        stud.getAdres().setMiasto(student.getAdres().getMiasto());
        stud.getAdres().setUlica(student.getAdres().getUlica());
        stud.getAdres().setNumerDomu(student.getAdres().getNumerDomu());
        students.put(student.getId(), student);
    }

    public void insertStudentToDb(Student student) {
        students.put(student.getId(), student);
    }
}
