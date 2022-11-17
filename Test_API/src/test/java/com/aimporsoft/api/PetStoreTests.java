package com.aimporsoft.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetStoreTests {
    private final static String URL = "https://petstore.swagger.io/v2";

    @BeforeClass
    public void usingSpec() {
        Specifications.installSpecifications(Specifications.responseSpecOK200(), Specifications.requestSpec(URL));
    }

    @Test

    public void checkResponseWithStatusSold() {

        Response response = given()
                .when()
                .get("/pet/findByStatus?status=sold")
                .then().log().all()

                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("status", notNullValue())
                .body("photoUrls", notNullValue())

                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<String> statuses = jsonPath.get("status");

        Assert.assertTrue(statuses.stream().allMatch(x -> x.endsWith("sold")), "All animals with a 'sold' status");
    }

    @Test

    public void checkResponseWithStatusAvailable() {

        Response response = given()
                .when()
                .get("/pet/findByStatus?status=available")
                .then().log().all()

                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("status", notNullValue())
                .body("photoUrls", notNullValue())

                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        List<String> statuses = jsonPath.get("status");

        Assert.assertTrue(statuses.stream().allMatch(x -> x.endsWith("available")), "All animals with a 'Available' status");
    }

    @Test

    public void checkResponseWithStatusPending() {

        Response response = given()
                .when()
                .get("/pet/findByStatus?status=pending")
                .then().log().all()

                .body("id", notNullValue())
                .body("name", notNullValue())
                .body("status", notNullValue())
                .body("photoUrls", notNullValue())

                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        List<String> statuses = jsonPath.get("status");

        Assert.assertTrue(statuses.stream().allMatch(x -> x.endsWith("pending")), "All animals with a 'Pending' status");
    }

    @Test

    public void successUserRegistration() {
        SoftAssert softAssert = new SoftAssert();


        String massage = "232323";
        Integer code = 200;
        User user = new User(232323, "Dmytro88", "Dmytro", "Savchenko", "papamama@mail.com", "471666", "80661936660", 21);
        APIResponse APIResponse = given()
                .body(user)
                .when()
                .post("/user")
                .then().log().all()
                .extract().as(APIResponse.class);
        softAssert.assertNotNull(APIResponse.getCode());
        softAssert.assertNotNull(APIResponse.getMessage());
        softAssert.assertEquals(massage, APIResponse.getMessage());
        softAssert.assertEquals(code, APIResponse.getCode());

    }

    @Test

    public void unSuccessUserRegistration() {
        Specifications.installSpecifications(Specifications.responseSpecOK500(), Specifications.requestSpec(URL));

        Map<String, String> registrationBodyData = new HashMap<>();
        registrationBodyData.put("id", "qwerty");
        given()
                .body(registrationBodyData)
                .when()
                .post("/user")
                .then().log().all();

    }
}
