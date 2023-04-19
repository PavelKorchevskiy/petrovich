package petrovich.controller;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class ChattingControllerTest {

    @Test
    public void get_request_to_chatting_controller_check_response_code() {
        RequestSpecification request = RestAssured.given();
        request.body("Test request body");
        request.get("http://localhost:8081/chat/message").then().assertThat().statusCode(200);
    }
}
