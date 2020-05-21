package com.example.mazur.p.mazurapp.furthertrainingapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.StringReader;

public class JsonMapper {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(JsonMapper.class);
    private static final ObjectWriter OBJECT_WRITER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .writer()
            .withDefaultPrettyPrinter();

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String objectToJson(Object object) {
        try{
            return OBJECT_WRITER.writeValueAsString(object);
        }catch (IOException e) {
            throw new IllegalArgumentException("Cannot write json", e);
        }
    }

    public <T> T jsonToObject(String json, Class<T> classType) {
        try {
            return OBJECT_MAPPER.readValue(new StringReader(json), classType);
        }
        catch (IOException e) {
            LOGGER.warn("Cannot read json:\n" + json);
            throw new IllegalArgumentException("Cannot read json:\n", e);
        }
    }
}
