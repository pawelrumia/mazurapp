package api;

import assertions.AssertStudent;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Adres;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Education;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import com.example.mazur.p.mazurapp.furthertrainingapp.utils.JsonMapper;
import com.example.mazur.p.mazurapp.furthertrainingapp.utils.PropertyReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static api.Requests.*;
import static api.StudentRequest.createRequest;
import static com.example.mazur.p.mazurapp.furthertrainingapp.utils.RequestLogger.logged;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class TestClass {
    private final JsonMapper jsonMapper = new JsonMapper();
    private PropertyReader PR = new PropertyReader();
    private Requests request = new Requests();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Client client = new Client();

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {76, "Jozek", "Golenie", "Biala Podlaska", "Zachlapana", 29, "Szkola Kebaba",
                        "kebab", 1988},
        };
    }

    @Test(dataProvider = "test1")
    public void testWithDataProvider(int id, String name, String course, String city, String street, int number,
                                     String school, String spec,
                                     int yearOfG) throws IOException {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(PR.readProperty("baseUri"))
                .setBasePath(PR.readProperty("getStudentPath"))
                .addPathParam("id", 76)
                .build();
        Response response = given().spec(logged(requestSpec))
                .when().get().thenReturn();
        ResponseBody body = response.getBody();
        Student employeeModel = body.as(Student.class);

        new AssertStudent()
                .statusCodeIsOk(response.getStatusCode())
                .hasId(employeeModel.getId(), id)
                .hasIdenticalName(employeeModel.getName(), name)
                .hasIdenticaCourse(employeeModel.getCourse(), course)
                .hasIdenticalCity(employeeModel.getAdres().getCity(), city)
                .hasIdenticalStreet(employeeModel.getAdres().getStreet(), street)
                .hasIdenticalHomeNumber(employeeModel.getAdres().getNumber(), number)
                .hasIdenticalSchool(employeeModel.getEducation().getSchool(), school)
                .hasIdenticalSpecialization(employeeModel.getEducation().getSpecialization(), spec)
                .hasIdenticalyearOfGraduation(employeeModel.getEducation().getGraduationYear(), yearOfG)
                .validateAll();
    }

    @Test
    public void testWithNewModel() throws IOException {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(PR.readProperty("baseUriForPost"))
                .setBody(jsonMapper.write(request.sendRequest()))
                .build();

        Response response = given().spec(logged(requestSpec))
                .when().post().thenReturn();
        new AssertStudent().statusCodeIsOk(response.getStatusCode());
    }

    @Test
    public void testWithGeneralJacksonAnnotations() throws IOException {
        Student student = new Student(5, "", "Ziomal", new Adres("Terespol", "Nowa", 4), new Education("", "", 2000));
        String result = objectMapper.writeValueAsString(student);
        System.out.println(result);
        assertThat(result.contains("Terespol")).isTrue();
    }

    @Test(priority = 1, description = "Yayyyy, builder is working")
    public void testWithBuilder() throws IOException {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(PR.readProperty("baseUriForPost"))
                .setBody(model1())
                .build();

        Response response = given().spec(logged(requestSpec))
                .when().post().thenReturn();
        new AssertStudent().statusCodeIsOk(response.getStatusCode());
    }

    @Test
    public void buildRequest() throws IOException {
        client.post(PR.readProperty("baseUriForPost"), jsonMapper.write(request.sendRequest()));
    }

    @Test(groups = "newGets")
    public void getAllStudentsNewWay() throws IOException {
        client.getAllStudents(PR.readProperty("baseUriForPost"));
    }

    @Test(groups = "newGets")
    public void getStudentByIdNewWay() throws IOException {
        client.getStudentById(PR.readProperty("baseUri"), 50);
    }

    @Test
    public void fullModel() {
        createRequest(new Student(76, "kas", "asf",
                new Adres("asf", "asf", 16),
                new Education("asfasf", "asgjk", 1799)));
    }

    @Test
    public void sendBaseStudentRequest() throws IOException {
       client.post(PR.readProperty("baseUriForPost"),
               jsonMapper.write(baseRequest));
    }

    @Test
    public void sendBaseStudentRequestWithList() throws IOException {
        client.post(PR.readProperty("baseUriForPost"),
                jsonMapper.write(baseRequestWithList));
    }

    @Test
    public void getStudentNewWayWithList() throws IOException {
        University university = client.getAllStudentsNew(PR.readProperty("getAllStudents"));
        university.getStudents().forEach(student ->
                assertThat(student.getSkills()).isNotNull());
    }

    @Test
    public void getStudentNewWayWithId() throws IOException {
        Student student = client.getStudentByIdNew(PR.readProperty("getStudentsWithId"), 150);
        System.out.println(student.getSkills());
        List<String> skills = student.getSkills();
        skills.forEach(s -> assertThat(student.getSkills()).contains("pranie"));
    }
}
