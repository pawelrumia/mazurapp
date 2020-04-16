package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @JsonProperty("school")
    private String school;
    @JsonProperty("specialization")
    private String specialization;
    @JsonProperty("graduationYear")
    private int graduationYear;

    public Education withSchool(String school) {this.school=school; return this;}
    public Education withSpecialization(String specialization) {this.specialization=specialization; return this;}
    public Education withGraduation(int graduation) {this.graduationYear=graduation; return this;}
}
