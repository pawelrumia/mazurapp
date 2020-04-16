package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Student {
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("course")
    private String course;
    @JsonProperty("adres")
    private Adres adres;
    @JsonProperty("education")
    private Education education;

    public Student(int id, String name, String course, Adres adres, Education education) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.adres = new Adres(adres.getCity(), adres.getStreet(), adres.getNumber());
        this.education =
                new Education(education.getSchool(),
                        education.getSpecialization(), education.getGraduationYear());
    }

    public Adres getAdres() {
        return adres;
    }

    public Education getEducation() {
        return education;
    }

    public Student withId(int id) {this.id=id; return this;}
    public Student withName(String name) {this.name=name; return this;}
    public Student withCourse(String course) {this.course=course; return this;}
    public Student withAdres(Adres adres) {this.adres=adres; return this;}
    public Student withEducation(Education education) {this.education=education; return this;}

}
