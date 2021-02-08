package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@With
public class Student {
    @JsonProperty("id")
    private int id;
    @JsonProperty("role")
    private String role;
    @JsonProperty("name")
    private String name;
    @JsonProperty("course")
    private String course;
    @JsonProperty("adres")
    private Adres adres;
    @JsonProperty("education")
    private Education education;
}
