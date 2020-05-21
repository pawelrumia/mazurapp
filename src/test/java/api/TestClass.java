package api;

import assertions.AssertStudent;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Adres;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Education;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.utils.PropertyReader;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static api.Requests.*;
import static api.StudentRequest.createRequest;
import static com.example.mazur.p.mazurapp.furthertrainingapp.utils.JsonMapper.objectToJson;
import static com.example.mazur.p.mazurapp.furthertrainingapp.utils.RequestLogger.logged;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TestClass {
    private PropertyReader PR = new PropertyReader();
    private JsonPath jsonPath;
    private Requests request = new Requests();
    private ObjectMapper objectMapper = new ObjectMapper();
    private Client client = new Client();

    @Test
    public void getSingleEmployee() throws IOException {
        RestAssured.baseURI = PR.readProperty("baseUri");
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(PR.readProperty("baseUri"))
                .setBasePath(PR.readProperty("getStudentsPath"))
                .addPathParam("id", 45)
                .build();
        Response response = given().spec(logged(requestSpec))
                .when().get().thenReturn();
        System.out.println(response);
        assertThat(response.getStatusCode()).as("Status code").isEqualTo(200);
        jsonPath = new JsonPath(response.asString());
        assertThat(jsonPath.getString("course"))
                .isEqualTo("java");
        assertThat(jsonPath.getString("education.kierunek"))
                .isEqualTo("Logis5tyka");
    }

    @Test
    public void sprawdzPierwszyRequest() throws IOException {
        RestAssured.baseURI = PR.readProperty("baseUri");

        given().contentType(JSON)
                .when()
                .get("/students/1")
                .then().assertThat()
                .body("name", equalTo("Janek"))
                .body("education.school", equalTo("UL"))
                .body("education.information.hobby", equalTo("chess"))
                .statusCode(200);
    }

    @Test(groups = "raz")
    public void getAllEmployees() throws IOException {
        RequestSpecification requestSpec = new RequestSpecBuilder()
                .setBaseUri(PR.readProperty("baseUri"))
                .setBasePath(PR.readProperty("allStudents"))
                .build();
        Response response = given().spec(logged(requestSpec))
                .when().get().thenReturn();
        System.out.println(response);
        assertThat(response.getStatusCode()).as("Status code").isEqualTo(200);
    }

    @Test
    public void stillTrying() throws IOException {
        RestAssured.baseURI = PR.readProperty("baseUri");
        RequestSpecification requestSpec = given()
                .pathParam("id", 2);
        Response response = requestSpec.request
                (Method.GET, PR.readProperty("getStudentPath"));
        ResponseBody body = response.getBody();
        Student employeeModel = body.as(Student.class);

        new AssertStudent()
                .statusCodeIsOk(response.getStatusCode())
                .hasIdenticalName(employeeModel.getName(), "Zioooome")
//                .hasIdenticalRole(employeeModel.getRole(), "C")
//                .hasIdenticalFavouriteMovie(employeeModel.getEducation()
//                        .getInformation().getFavouriteMovie(), ("PrisonBrejk"))
                .validateAll();
    }

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
                .setBody(objectToJson(request.sendRequest()))
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
        client.post(PR.readProperty("baseUriForPost"),
                objectToJson(request.sendRequest()));
    }

    @Test(groups = "newGets")
    public void getAllStudentsNewWay() throws IOException {
        client.getAllStudents(PR.readProperty("baseUriForPost"));
    }

    @Test(groups = "newGets")
    public void getStudentByIdNewWay() throws IOException {
        client.getStudentById(PR.readProperty("baseUri"), 50);
    }
    //    @AfterTest
    @Test
    public void deleteAll() throws IOException {
        RestAssured.baseURI = PR.readProperty("baseUri");
        deleteAllItems();
    }


    private void deleteAllItems() {
        for (int i = 0; i < 500; i++) {
            given().contentType(JSON)
                    .when()
                    .delete("students/" + i);
        }
    }

    @Test(description = "Sending requests before")
    public void sendRequests() {
        RestAssured.baseURI = "http://localhost:8000";
        given().contentType(JSON)
                .body(request1)
                .post("/students")
                .then().statusCode(200);

        RestAssured.baseURI = "http://localhost:8000";
        given().contentType(JSON)
                .body(request2)
                .post("/students")
                .then().assertThat()
                .statusCode(200);

        RestAssured.baseURI = "http://localhost:8000";
        given().contentType(JSON)
                .body(request3)
                .post("/students")
                .then().statusCode(200);

        RestAssured.baseURI = "http://localhost:8000";
        given().contentType(JSON)
                .body(objectToJson(request.sendRequest()))
                .post("/students")
                .then().statusCode(200);
    }

    @Test
    public void fullModel() {
        createRequest(new Student(76, "kas", "asf",
                new Adres("asf", "asf",  16),
                new Education("asfasf", "asgjk", 1799)));
    }

    @Test
    public void sendBaseStudentRequest() throws IOException {
       client.post(PR.readProperty("baseUriForPost"),
               objectToJson(baseRequest));
    }

    @Test
    public void sendBaseStudentRequestWithModification() throws IOException {
        client.post(PR.readProperty("baseUriForPost"),
                objectToJson(baseRequest));
    }

    @Test
    public void sendBaseStudentRequestWithList() throws IOException {
        client.post(PR.readProperty("baseUriForPost"),
                objectToJson(baseRequestWithList));
    }

    @Test
    public void getStudentByIdNewWayWithList() throws IOException {
        Student student = client.getAllStudentsKopia(PR.readProperty("getAllStudents"));

        System.out.println(student.getId());
    }
}
