package com.example.mazur.p.mazurapp.furthertrainingapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class JsonWriter {
    private static final ObjectWriter OBJECT_WRITER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .writer()
            .withDefaultPrettyPrinter();

    public static String objectToJson(Object object) {
        try{
            return OBJECT_WRITER.writeValueAsString(object);
        }catch (IOException e) {
            throw new IllegalArgumentException("Cannot write json", e);
        }
    }
}
