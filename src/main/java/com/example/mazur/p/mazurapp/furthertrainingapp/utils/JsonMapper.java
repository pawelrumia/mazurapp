package com.example.mazur.p.mazurapp.furthertrainingapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class JsonMapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonMapper.class);

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper().findAndRegisterModules();

    public <T> String write(T object) {
        try {
            return JSON_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot write json", e);
        }
    }

    public <T> T read(String json, Class<T> classType) {
        try {
            return JSON_MAPPER.readValue(json, classType);
        } catch (IOException e) {
            LOGGER.warn("Cannot read json:\n" + json);
            throw new IllegalArgumentException("Cannot read json:\n", e);
        }
    }
}
