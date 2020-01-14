package com.example.mazur.p.mazurapp.furthertrainingapp.student;

public class Wyksztalcenie {
    private String nazwaSzkoly;
    private String kierunek;
    private int rokUkonczenia;

    Wyksztalcenie(String nazwaSzkoly, String kierunek, int rokUkonczenia) {
        this.nazwaSzkoly = nazwaSzkoly;
        this.kierunek = kierunek;
        this.rokUkonczenia = rokUkonczenia;
    }

    public Wyksztalcenie() {
    }

    public String getNazwaSzkoly() {
        return nazwaSzkoly;
    }

    public void setNazwaSzkoly(String nazwaSzkoly) {
        this.nazwaSzkoly = nazwaSzkoly;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    public int getRokUkonczenia() {
        return rokUkonczenia;
    }

    public void setRokUkonczenia(int rokUkonczenia) {
        this.rokUkonczenia = rokUkonczenia;
    }
}
