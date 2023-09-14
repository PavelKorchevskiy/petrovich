package service.controller;

import io.restassured.RestAssured;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChattingControllerTest {

//    @Test
    public void get_request_to_chatting_controller_check_response_code() {
        RequestSpecification request = RestAssured.given();
        request.body("Test request body");
        request.get("http://localhost:8081/chat/message").then().assertThat().statusCode(200);
    }

//    @Test
    public void get_request_to_chatting_controller_check_response_body_not_null() {
        RequestSpecification request = RestAssured.given();
        request.body("Test request body");
        ResponseBodyExtractionOptions body = request.get("http://localhost:8081/chat/message").then().extract().body();
        assertNotNull(request.get("http://localhost:8081/chat/message").then().extract().body().asString());
    }
}
