package com.example.mazur.p.mazurapp.furthertrainingapp.dao;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Repository
public class StudentDAO {
    private static final Map<Integer, Student> STUDENTS = new HashMap<>();

    public University getAllStudents() {
        return new University()
                .withStudents(new ArrayList<>(STUDENTS.values()));
    }

    public Student getStudentById(int id) {
        return STUDENTS.get(id);
    }

    public void removeStudentById(int id) {
        STUDENTS.remove(id);
    }

    public void updateStudent(Student student) {
        Student stud = STUDENTS.get(student.getId());
        stud.setId(student.getId());
        updateStudent(student, stud);
        STUDENTS.put(student.getId(), student);
    }

    public void updateStudentById(int id, Student student) {
        Student stud = STUDENTS.get(id);
        updateStudent(student, stud);
        STUDENTS.put(student.getId(), student);
    }

    private void updateStudent(Student student, Student stud) {
        stud.setName(student.getName());
        stud.setCourse(student.getCourse());
        stud.getAdres().setCity(student.getAdres().getCity());
        stud.getAdres().setStreet(student.getAdres().getStreet());
        stud.getAdres().setNumber(student.getAdres().getNumber());
        stud.getEducation().setSchool(student.getEducation().getSchool());
        stud.getEducation().setSpecialization(student.getEducation().getSpecialization());
        stud.getEducation().setGraduationYear(student.getEducation().getGraduationYear());
    }

    public void insertStudentToDb(Student student) {
        STUDENTS.put(student.getId(), student);
    }
}
