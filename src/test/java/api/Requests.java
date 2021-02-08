package api;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.Adres;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Education;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;

class Requests {
    static Student createBaseRequest(int id, String role, String name, String course, Adres adres, Education education) {
        return new Student(id, role, name, course, adres, education);
    }
}
