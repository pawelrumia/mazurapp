package com.example.mazur.p.mazurapp.furthertrainingapp.utils;

import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public class RequestLogger {
    public static RequestSpecification logged(RequestSpecification requestSpec) {
        return requestSpec.log().all().filter(new ResponseLoggingFilter());
    }
}
