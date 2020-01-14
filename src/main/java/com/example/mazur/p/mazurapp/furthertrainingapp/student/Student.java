package com.example.mazur.p.mazurapp.furthertrainingapp.student;

public class Student {
    private int id;
    private String name;
    private String course;
    private Adres adres;
    private Wyksztalcenie wyksztalcenie;

    public Student(int id, String name, String course, Adres adres, Wyksztalcenie wyksztalcenie) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.adres = new Adres(adres.getMiasto(), adres.getUlica(), adres.getNumerDomu());
        this.wyksztalcenie =
                new Wyksztalcenie(wyksztalcenie.getNazwaSzkoly(),
                        wyksztalcenie.getKierunek(), wyksztalcenie.getRokUkonczenia());
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Adres getAdres() {
        return adres;
    }

    public Wyksztalcenie getWyksztalcenie() {
        return wyksztalcenie;
    }
}
