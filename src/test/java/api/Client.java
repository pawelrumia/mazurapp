package api;

import com.example.mazur.p.mazurapp.furthertrainingapp.student.Student;
import com.example.mazur.p.mazurapp.furthertrainingapp.student.University;
import com.example.mazur.p.mazurapp.furthertrainingapp.utils.JsonMapper;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.StringJoiner;

import static io.restassured.RestAssured.given;

public class Client {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestClass.class);
    private static final Header HEADER_CONTENT_TYPE =
            new Header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
    private JsonMapper jsonMapper = new JsonMapper();

    Response post(String address, String requestBody) {
        Response response = buildPostRequest(requestBody, address).post();
        logRequestAndResponseInfo("POST", address, requestBody, response);
        return response;
    }

    Response getAllStudents(String address) {
        Response response = buildGetRequest(address).get();
        logRequestAndResponseInfo("GET", address, null, response);
        return response;
    }

    Response getStudentById(String address, int id) throws IOException {
        return buildGetRequestByID(address, id).get();
    }

    University getAllStudentsNew(String address) {
        Response res = buildGetRequest(address).get();
        String response = res.getBody().asString();
        res.prettyPrint();
        return jsonMapper.read(response, University.class);
    }

    Student getStudentByIdNew(String address, int id) throws IOException {
        Response res = buildGetRequestByID(address, id).get();
        String response = res.getBody().asString();
        return jsonMapper.read(response, Student.class);
    }

    private RequestSpecification buildPostRequest(String requestBody, String address) {
        return given()
                .header(HEADER_CONTENT_TYPE)
                .baseUri(address)
                .body(requestBody);
    }

    private RequestSpecification buildGetRequest(String address) {
        return given()
                .header(HEADER_CONTENT_TYPE)
                .baseUri(address);
    }

    private RequestSpecification buildGetRequestByID(String address, int id) throws IOException {
        return given()
                .header(HEADER_CONTENT_TYPE)
                .baseUri(address + id);
    }

    private void logRequestAndResponseInfo(String httpMethod, String endpoint,
                                           String requestBody, Response response) {
        LOGGER.info(new StringJoiner("\n")
                .add("\b")
                .add("Sending request: " + httpMethod + " " + endpoint)
                .add(HEADER_CONTENT_TYPE.toString())
                .add("Request body: " + requestBody)
                .add("Response: " + response).toString());
    }
}
