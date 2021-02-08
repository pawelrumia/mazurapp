package api;

import com.example.mazur.p.mazurapp.furthertrainingapp.utils.JsonMapper;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(TestClass.class);
    private JsonMapper jsonMapper = new JsonMapper();
    private final RequestsSpecification requestSpec = new RequestsSpecification();

    public Response basicGetRequest(String endpoint) {
        return requestSpec.buildGetRequest(endpoint).get();
    }

    public Response basicPostRequest(String body, String endpoint) {
        return requestSpec.buildPostRequest(body, endpoint).post();
    }

    public Response basicGetRequestWithId(String endpoint, int id) {
        return requestSpec.buildGetRequestWithId(endpoint, id).get();
    }
}
