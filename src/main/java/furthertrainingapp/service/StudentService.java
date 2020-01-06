package furthertrainingapp.service;

import furthertrainingapp.dao.StudentDAO;
import furthertrainingapp.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Qualifier(value = "mongoData")
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Collection<Student> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id){
        return studentDAO.getStudentById(id);
    }

    public void removeStudentById(int id){
        studentDAO.removeStudentById(id);
    }

    public void updateStudentById(int id,Student student){
        studentDAO.updateStudentById(id, student);
    }

    public void updateStudent(Student student){
        studentDAO.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDAO.insertStudentToDb(student);
    }
}
