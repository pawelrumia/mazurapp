package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skills {
    @JsonProperty("skills")
    private List<String> skills;

    public Skills withSkills(List<String> skills) {this.skills=skills; return this;}

}
