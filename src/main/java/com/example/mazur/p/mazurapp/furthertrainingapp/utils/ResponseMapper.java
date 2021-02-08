package com.example.mazur.p.mazurapp.furthertrainingapp.utils;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import io.restassured.response.Response;

public class ResponseMapper {
    public static Student getStudentIdResponse(Response response) {
        return new JsonMapper().read(response.getBody().asString(), Student.class);
    }

    public static University getAllStudentsResponse(Response response) {
        return new JsonMapper().read(response.getBody().asString(), University.class);
    }
}
