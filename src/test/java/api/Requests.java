package api;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.Adres;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Education;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.utils.JsonWriter;

import java.util.function.Supplier;

public class Requests {
    private Student studentModel = new Student();
    public JsonWriter jsonWriter = new JsonWriter();
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
                .withId(73)
                .withName("Jozek")
                .withCourse("Golenie")
                .withAdres(new Adres()
                        .withCity("Biala Podlaska")
                        .withStreet("Zachlapana")
                        .withHomeNumber(29))
                .withEducation(new Education()
                        .withSchool("Szkola Kebaba")
                        .withSpecialization("kebab")
                        .withGraduation(1988))
                ;
    }

    static Student model1() {
        return Student.builder()
                .id(2)
                .name("Zioooome")
                .course("Trener")
                .adres(new Adres("Rumia", "Nie powiem bydlaki", 16))
                .education(new Education("Najgorsza", "Lamacz kosci", 2000))
                .build();
    }
}
