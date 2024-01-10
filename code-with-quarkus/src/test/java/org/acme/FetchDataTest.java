package org.acme;

import io.quarkus.test.junit.QuarkusTest;

import org.acme.services.FetchDataService;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class FetchDataTest {

    @Inject
    FetchDataService svc;


    @Test
    public void testGetAllNamesEndpoint() {

        given()
            .when()
            .get("/namelist")
            .then()
            .statusCode(200)
            .contentType(MediaType.APPLICATION_JSON)
            .body(is("[]"));
    }

}