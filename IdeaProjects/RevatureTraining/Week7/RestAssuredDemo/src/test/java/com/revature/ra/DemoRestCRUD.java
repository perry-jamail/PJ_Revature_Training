package com.revature.ra;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DemoRestCRUD {

    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;
    static int createdPostId;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("X-Custom-Header", "RestAssuredDemo")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    @AfterAll
    static void teardown() {
        RestAssured.reset();
    }

    @Test
    public void getPost() {
        given()
                .spec(requestSpec)
                .when()
                .get("/posts/1")
                .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    @Test
    @Order(1)
    @DisplayName("CREATE - POST new post")
    void create_post_returnsCreatedResource() {
        String requestBody = """
                {
                    "title": "Test Post from REST Assured",
                    "body": "This post was created during our demo",
                    "userId": 1
                }
                """;

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("Test Post from REST Assured"))
                .body("body", containsString("demo"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();

        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }


    @Test
    @Order(2)
    @DisplayName("Create - Post with Java Object")
    public void testSerialObject() {
        Post newPost = new Post("POJO Test", "Testing a POJO Object", 1);

        Response response = given()
                .spec(requestSpec)
                .body(newPost)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("POJO Test"))
                .body("body", containsString("Testing"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();

        createdPostId = response.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + createdPostId);
    }

    // Write a new class to test the get method for an individual Post. That Post number comes from a value source
    @ParameterizedTest(name = "GET /posts/{0} returns 200")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Order(3)
    @DisplayName("GET multiple posts by ID")
    public void getMultiplePostsById(int id) {
        given()
                .spec(requestSpec)
                .when()
                .get("/posts/{id}", id)
                .then()
                .spec(responseSpec)
                .statusCode(200);
    }

    // Make a GET call to the users endpoint with the user's ID.
    // Fetch the name, and make sure the name matches the returned name.
    // Use CSV, do this for 5 different users
    @ParameterizedTest(name = "GET /users/{0} name = {1}")
    @CsvSource({
            "1, Leanne Graham",
            "2, Ervin Howell",
            "3, Clementine Bauch",
            "4, Patricia Lebsack",
            "5, Chelsey Dietrich"
    })
    @Order(4)
    @DisplayName("GET user by user id and confirm username is correct")
    public void getUserById(int id, String expectedUsername) {
        given()
                .spec(requestSpec)
                .when()
                .get("/users/{id}", id)
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .body("name", equalTo(expectedUsername));
    }
}
