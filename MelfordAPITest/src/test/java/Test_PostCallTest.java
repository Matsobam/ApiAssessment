import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

class Test_PostCallTest {

    @BeforeAll
    public static void setup(){

        RestAssured.baseURI= "https://jsonplaceholder.typicode.com";
    }

    private String requestbody = "{\n" +
            " \"PostId\": \"1\",\n" +
            " \"Name\": \"Melford\",\n" +
            " \"Email\": \"tshepomelford1@gmail.com\",\n" +
            " \"Body\": \"29/6/2023\" \n}";

    @Test
    public void verifyThatWhenAuserPostuserDetailsCorrectStatusCodeIsDisplayed()
    {

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestbody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.getStatusCode()); //

}

}