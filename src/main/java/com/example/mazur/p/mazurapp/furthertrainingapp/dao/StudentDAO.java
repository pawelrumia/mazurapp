package com.example.mazur.p.mazurapp.furthertrainingapp.dao;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Repository
public class StudentDAO {
    private static Map<Integer, University> students;

    static {
        students = new HashMap<Integer, University>() {
            {
            }
        };
    }

    public Collection<University> getAllStudents() {
        return students.values();
    }

    public University getStudentById(int id) {
        return students.get(id);
    }

    public void removeStudentById(int id) {
        students.remove(id);
    }

//????????????????????????????
//    public void updateStudent(Student student) {
//        Student stud = students.get(student.getId());
//        stud.setId(student.getId());
//        stud.setName(student.getName());
//        stud.setCourse(student.getCourse());
//        stud.getAdres().setCity(student.getAdres().getCity());
//        stud.getAdres().setStreet(student.getAdres().getStreet());
//        stud.getAdres().setNumber(student.getAdres().getNumber());
//        stud.getEducation().setSchool(student.getEducation().getSchool());
//        stud.getEducation().setSpecialization(student.getEducation().getSpecialization());
//        stud.getEducation().setGraduationYear(student.getEducation().getGraduationYear());
//        students.put(student.getId(), student);
//    }
//to samo tutaj ????????????????????/
//    public void updateStudentById(int id, Student student) {
//        Student stud = students.get(id);
//        stud.setName(student.getName());
//        stud.setCourse(student.getCourse());
//        stud.getAdres().setCity(student.getAdres().getCity());
//        stud.getAdres().setStreet(student.getAdres().getStreet());
//        stud.getAdres().setNumber(student.getAdres().getNumber());
//        stud.getEducation().setSchool(student.getEducation().getSchool());
//        stud.getEducation().setSpecialization(student.getEducation().getSpecialization());
//        stud.getEducation().setGraduationYear(student.getEducation().getGraduationYear());
//        students.put(student.getId(), student);
//    }

    public void insertStudentToDb(University university) {
        students.put(student.getId(), university);
    }
}
