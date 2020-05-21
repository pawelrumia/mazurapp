package com.example.mazur.p.mazurapp.furthertrainingapp.service;

import com.example.mazur.p.mazurapp.furthertrainingapp.dao.StudentDAO;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier(value = "mongoData")
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public University getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public Student getStudentById(int id){
        return studentDAO.getStudentById(id);
    }

    public void removeStudentById(int id){
        studentDAO.removeStudentById(id);
    }

    public void updateStudentById(int id, Student student){
        studentDAO.updateStudentById(id, student);
    }

    public void updateStudent(Student student){
        studentDAO.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDAO.insertStudentToDb(student);
    }
}
