package com.example.mazur.p.mazurapp.furthertrainingapp.student;

public class Adres {
    private String miasto;
    private String ulica;
    private String numerDomu;

    public Adres(String miasto, String ulica, String numerDomu) {
        this.miasto = miasto;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public void setNumerDomu(String numerDomu) {
        this.numerDomu = numerDomu;
    }
}
