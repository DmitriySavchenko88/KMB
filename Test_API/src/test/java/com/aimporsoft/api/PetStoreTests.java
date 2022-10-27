package com.aimporsoft.api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetStoreTests {
    private final static String URL = "https://petstore.swagger.io/v2";

    @Test

    public void checkResponseWithStatusSold() {
        Specifications.installSpecifications(Specifications.responseSpecOK200(), Specifications.requestSpec(URL));
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
        List<String> ids = jsonPath.get("id");
        List<String> names = jsonPath.get("name");
        List<String> statuses = jsonPath.get("status");

        Assert.assertTrue(statuses.stream().allMatch(x -> x.endsWith("sold")));
    }

    @Test

    public void checkResponseWithStatusAvailable() {
        Specifications.installSpecifications(Specifications.responseSpecOK200(), Specifications.requestSpec(URL));
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
        List<String> ids = jsonPath.get("id");
        List<String> names = jsonPath.get("name");
        List<String> statuses = jsonPath.get("status");

        Assert.assertTrue(statuses.stream().allMatch(x -> x.endsWith("available")));
    }

    @Test

    public void checkResponseWithStatusPending() {
        Specifications.installSpecifications(Specifications.responseSpecOK200(), Specifications.requestSpec(URL));
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
        List<String> ids = jsonPath.get("id");
        List<String> names = jsonPath.get("name");
        List<String> statuses = jsonPath.get("status");

        Assert.assertTrue(statuses.stream().allMatch(x -> x.endsWith("pending")));
    }

    @Test

    public void successUserRegistration() {
        Specifications.installSpecifications(Specifications.responseSpecOK200(), Specifications.requestSpec(URL));
        String massage = "232323";
        Integer code = 200;
        Register user = new Register(232323, "Dmytro88", "Dmytro", "Savchenko", "papamama@mail.com", "471666", "80661936660", 21);
        SuccessReg successReg = given()
                .body(user)
                .when()
                .post("/user")
                .then().log().all()
                .extract().as(SuccessReg.class);
        Assert.assertNotNull(successReg.getCode());
        Assert.assertNotNull(successReg.getMessage());
        Assert.assertEquals(massage, successReg.getMessage());
        Assert.assertEquals(code, successReg.getCode());
    }

    @Test

    public void unSuccessUserRegistration(){
        Specifications.installSpecifications(Specifications.responseSpecOK500(), Specifications.requestSpec(URL));

        Map<String, String> user = new HashMap<>();
        user.put ("id", "qwerty");
        given()
                .body(user)
                .when()
                .post("/user")
                .then().log().all();

    }
}
