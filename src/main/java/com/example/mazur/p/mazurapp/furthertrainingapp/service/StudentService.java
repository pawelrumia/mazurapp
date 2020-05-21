package com.example.mazur.p.mazurapp.furthertrainingapp.service;

import com.example.mazur.p.mazurapp.furthertrainingapp.dao.StudentDAO;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Qualifier(value = "mongoData")
public class StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public Collection<University> getAllStudents(){
        return studentDAO.getAllStudents();
    }

    public University getStudentById(int id){
        return studentDAO.getStudentById(id);
    }

    public void removeStudentById(int id){
        studentDAO.removeStudentById(id);
    }

    public void updateStudentById(int id,University university){
        studentDAO.updateStudentById(id, university);
    }

    public void updateStudent(University university){
        studentDAO.updateStudent(university);
    }

    public void insertStudent(University university) {
        studentDAO.insertStudentToDb(university);
    }
}
