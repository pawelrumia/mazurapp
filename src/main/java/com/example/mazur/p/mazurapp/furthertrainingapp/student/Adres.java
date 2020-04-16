package com.example.mazur.p.mazurapp.furthertrainingapp.student;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adres {
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("number")
    private int number;

    public Adres withCity(String city) {this.city=city; return this;}
    public Adres withStreet(String street) {this.street=street; return this;}
    public Adres withHomeNumber(int homeNumber) {this.number=homeNumber; return this;}
}
