package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Education {
    @JsonProperty("school")
    private String school;
    @JsonProperty("specialization")
    private String specialization;
    @JsonProperty("yearOfGraduation")
    private int yearOfGraduation;
}

