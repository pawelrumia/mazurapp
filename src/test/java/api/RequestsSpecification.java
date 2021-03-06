package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;

import java.io.IOException;

import static com.example.mazur.p.mazurapp.furthertrainingapp.utils.RequestLogger.logged;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class RequestsSpecification {

    public RequestsSpecification() {
    }

    public RequestSpecification buildPostRequest(String requestBody, String address) {
        return given()
                .contentType(JSON)
                .baseUri(address)
                .body(requestBody);
    }

    public RequestSpecification buildPostRequestWithId(String requestBody, String address, int id) {
        return given()
                .contentType(JSON)
                .baseUri(address)
                .queryParam("id", id)
                .body(requestBody);
    }

    public RequestSpecification buildGetRequestWithId(String address, int id) {
        return logged(new RequestSpecBuilder()
                .addHeader("Content-Type", "application/json")
                .setBaseUri(address)
                .addPathParam("id", id)
                .build());
    }

    public RequestSpecification buildGetRequest(String address) {
        return given()
                .contentType(JSON)
                .baseUri(address);
    }
}
