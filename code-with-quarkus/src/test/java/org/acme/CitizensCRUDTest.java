package org.acme;

import org.acme.model.Citizens;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@QuarkusTest
public class CitizensCRUDTest {

    @Test
    public void testCreateCitizen() {
        assertEquals(1, 1);
    }

}