package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.acme.model.Corporation;
import org.acme.services.management.ICorporationMgtService;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CorporationCRUDTest {

    @Inject
    ICorporationMgtService testCorp;

    @Test
    public void testCreateCorporation() {
        Corporation corporation = new Corporation();
        corporation.name = "theo";
        corporation.Siret = "FODIL-CHERIF";
        corporation.Siren = "DZFEEFE";
        corporation.mail = "testmail";
        corporation.note = 3;
        corporation.address = "15 rue de là bas";
        corporation.phone_number = "0622639026";
        corporation.ZIP_code = "33700";
        corporation.login = "aminefodil";
        corporation.password = "aminefodil";
        Corporation newCorp = testCorp.createCorporation(corporation);

        assertNotNull(newCorp);
    }
}
