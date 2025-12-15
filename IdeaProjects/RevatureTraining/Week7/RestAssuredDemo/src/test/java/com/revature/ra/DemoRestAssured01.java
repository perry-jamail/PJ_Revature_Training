package com.revature.ra;

// REST Assured static imports (recommended)
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

// Standard imports
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DemoRestAssured01 {

//    @BeforeEach
//    public void setUp() {
//        RestAssured.
//    }

    @Test
    public void testUserDetails() {
        given()
                .when()
                .get("users/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Leanne Graham"));
    }
}
