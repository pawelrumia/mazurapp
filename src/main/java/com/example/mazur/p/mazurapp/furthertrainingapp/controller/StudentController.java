package com.example.mazur.p.mazurapp.furthertrainingapp.controller;

import com.example.mazur.p.mazurapp.furthertrainingapp.exceptionshandle.ProductNotFoundException;
import com.example.mazur.p.mazurapp.furthertrainingapp.service.StudentService;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public University getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id) {
        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody University university) {
        studentService.updateStudent(university);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateStudenta(@PathVariable("id") int id, @RequestBody University university) {
        if(id <= 0){
            throw new ProductNotFoundException();
        }
        studentService.updateStudentById(id, university);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody University university) {
        studentService.insertStudent(university);
        System.out.println("Great success!");
    }
}
