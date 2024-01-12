package org.acme.services.management.impl;

import java.util.List;

import org.acme.model.Corporation;
import org.acme.services.management.ICorporationMgtService;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


public class CorporationMgtService implements ICorporationMgtService {
    
    
    @Inject
    EntityManager entityManager;

    @Transactional
    public Corporation createCorporation(Corporation corporation) {
        entityManager.persist(corporation);
        return corporation;
    }

    @Transactional
    public List<Corporation> getAllCorporations() {
        return entityManager.createQuery("SELECT c FROM Corporation c", Corporation.class).getResultList();
    }

    @Transactional
    public Corporation getCorporationById(int id) {
        return entityManager.find(Corporation.class, id);
    }

    @Transactional
    public Corporation updateCorporation(Integer corporationId, Corporation updatedCorporation) {
        Corporation existingCorporation = entityManager.find(Corporation.class, corporationId);
        if (existingCorporation != null) {
            existingCorporation.name = updatedCorporation.name;
            existingCorporation.id_corporation = updatedCorporation.id_corporation;
            existingCorporation.Siret = updatedCorporation.Siret;
            existingCorporation.Siren = updatedCorporation.Siren;
            existingCorporation.phone_number = updatedCorporation.phone_number;
            existingCorporation.note = updatedCorporation.note;
            existingCorporation.address = updatedCorporation.address;
            existingCorporation.ZIP_code = updatedCorporation.ZIP_code;
        }
        return updatedCorporation;
    }

    @Transactional
    public void deleteCorporation(int id) {
        Corporation corpToDelete = entityManager.find(Corporation.class, id);
        if (corpToDelete != null) {
            entityManager.remove(corpToDelete);
        }
    }
}
