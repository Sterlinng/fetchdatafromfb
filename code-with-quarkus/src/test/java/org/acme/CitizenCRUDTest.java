package org.acme;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;



@QuarkusTest
public class CitizenCRUDTest {

    @Inject
    ICitizenMgtService svc;

    @Test
    @Disabled
    public void testCreateCitizen() {
        Citizens citizen = new Citizens();
        citizen.firstname = "theo";
        citizen.lastname = "FODIL-CHERIF";
        citizen.ZIP_code = "33700";
        citizen.phone_number = "0622639026";
        citizen.Point = "15";
        citizen.address = "merignac";
        citizen.level = 10;
        citizen.Note = 5;
        citizen.mail = "afodil@gmail.com";
        citizen.login = "aminefodil";
        citizen.password = "aminefodil";
        Citizens newCtiz = svc.createCitizen(citizen);

        assertNotNull(newCtiz);
    }

    @Test
    public void testDeleteCitizen() {
        svc.deleteCitizen(2);
    }
}