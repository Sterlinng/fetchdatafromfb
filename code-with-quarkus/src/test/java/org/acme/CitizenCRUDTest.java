package org.acme;

import org.acme.model.Citizen;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



@QuarkusTest
public class CitizenCRUDTest {


    @Test
    public void testCreateCitizen() {
        Citizen newCitizen = new Citizen();
        newCitizen.firstname = "Emmanuel GARNIER";

        given()
            .contentType(ContentType.JSON)
            .body(newCitizen)
        .when()
            .post("/citizen") 
        .then()
            .statusCode(201)
            .body("name", equalTo("Emmanuel GARNIER")); 
    }

}