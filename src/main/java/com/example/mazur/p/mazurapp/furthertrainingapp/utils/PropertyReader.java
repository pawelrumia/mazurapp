package com.example.mazur.p.mazurapp.furthertrainingapp.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public String readProperty(String key) throws IOException {
        FileReader reader = new FileReader("src/main/resources/properties.properties");
        Properties properties = new Properties();
        properties.load(reader);
        key = properties.getProperty(key);
        System.out.println(key);
        return key;
    }
}
