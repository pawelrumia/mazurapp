package api;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.Adres;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Education;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Skills;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;

class Requests {

    static String request1 =
            "{\n" +
                    "        \"id\": 15,\n" +
                    "        \"name\": \"Zbychowski\",\n" +
                    "        \"course\": \"c++\",\n" +
                    "        \"adres\": {\n" +
                    "            \"city\": \"Wroclaw\",\n" +
                    "            \"street\": \"Nowa\",\n" +
                    "            \"number\": \"15\"\n" +
                    "        },\n" +
                    "        \"education\": {\n" +
                    "            \"school\": \"UL\",\n" +
                    "            \"specialization\": \"Logis5tyka\",\n" +
                    "            \"graduationYear\": 1988\n" +
                    "        }\n" +
                    "    }";

    static String request2 =
            "{\n" +
                    "        \"id\": 27,\n" +
                    "        \"name\": \"Januszowski\",\n" +
                    "        \"course\": \"c\",\n" +
                    "        \"adres\": {\n" +
                    "            \"city\": \"Krakow\",\n" +
                    "            \"street\": \"Zachlapana\",\n" +
                    "            \"number\": \"199\"\n" +
                    "        },\n" +
                    "        \"education\": {\n" +
                    "            \"school\": \"WK\",\n" +
                    "            \"specialization\": \"Metafizyka\",\n" +
                    "            \"graduationYear\": 1980\n" +
                    "        }\n" +
                    "    }";

    static String request3 =
            "{\n" +
                    "        \"id\": 17,\n" +
                    "        \"name\": \"Terlakowski\",\n" +
                    "        \"course\": \"dlubanie\",\n" +
                    "        \"adres\": {\n" +
                    "            \"city\": \"Lodz\",\n" +
                    "            \"street\": \"Kowalowa\",\n" +
                    "            \"number\": \"2\"\n" +
                    "        },\n" +
                    "        \"education\": {\n" +
                    "            \"school\": \"Archiwum\",\n" +
                    "            \"specialization\": \"Archiwistyka\",\n" +
                    "            \"graduationYear\": 1909\n" +
                    "        }\n" +
                    "    }";

    Student sendRequest() {
        Student student = new Student();
        return student
                .withId(50)
                .withName("Jozek")
                .withCourse("Golenie")
                .withAdres(new Adres()
                        .withCity("Biala Podlaska")
                        .withStreet("Zachlapana")
                        .withHomeNumber(29))
                .withEducation(new Education()
                        .withSchool("Szkola Kebaba")
                        .withSpecialization("sobota wieczor")
                        .withGraduation(1988));
    }

    static Student model1() {
        return Student.builder()
                .id(2)
                .name("Zioooome")
                .course("Trener")
                .adres(new Adres("Rumia", "Nie powiem", 16))
                .education(new Education("Najgorsza", "Trener", 2000))
                .build();
    }

    final static Student baseRequest =
            new Student()
                    .withId(100)
                    .withName("Jozek")
                    .withCourse("Golenie")
                    .withAdres(new Adres()
                            .withCity("Biala Podlaska")
                            .withStreet("Zachlapana")
                            .withHomeNumber(29))
                    .withEducation(new Education()
                            .withSchool("Szkola Kebaba")
                            .withSpecialization("sobota wieczor")
                            .withGraduation(1988));

    final static Student baseRequestWithList =
            new Student()
                    .withId(150)
                    .withName("Jozek")
                    .withCourse("Golenie")
                    .withAdres(new Adres()
                            .withCity("Biala Podlaska")
                            .withStreet("Zachlapana")
                            .withHomeNumber(29))
                    .withEducation(new Education()
                            .withSchool("Szkola Kebaba")
                            .withSpecialization("sobota wieczor")
                            .withGraduation(1988))
            .withSkills(new Skills(ImmutableList.of("pranie", "sprzatanie", "jedzenie")));

    static Student model1Lista() {
        return Student.builder()
                .id(2)
                .name("Zioooome")
                .course("Trener")
                .adres(new Adres("Rumia", "Nie powiem", 16))
                .education(new Education("Najgorsza", "Trener", 2000))
                .skills(new Skills(ImmutableList.of("pranie", "sprzatanie", "jedzenie")))
                .build();
    }
}
