package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class University {
    @JsonProperty("students")
    private List<Student> students;

    public University withStudents(List<Student> students) {
        this.students = students;
        return this;
    }
}
