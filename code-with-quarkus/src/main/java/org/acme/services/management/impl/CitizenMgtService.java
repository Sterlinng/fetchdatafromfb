package org.acme.services.management.impl;


import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class CitizenMgtService implements ICitizenMgtService {


    @Inject
    EntityManager entityManager;


    @Override
    @Transactional
    public Citizens createCitizen(Citizens newCitizen) {

        Citizens createdCitizen = new Citizens();

        createdCitizen.firstname = newCitizen.firstname;
        createdCitizen.lastname = newCitizen.lastname;
        createdCitizen.ZIP_code = newCitizen.ZIP_code;
        createdCitizen.phone_number = newCitizen.phone_number;
        createdCitizen.login = newCitizen.login;
        createdCitizen.password = newCitizen.password;
        createdCitizen.address = newCitizen.address;
        createdCitizen.Note = newCitizen.Note;
        createdCitizen.Point = newCitizen.Point;
        createdCitizen.id_citizens = newCitizen.id_citizens;
        createdCitizen.level = newCitizen.level;

        entityManager.persist(createdCitizen);

        return createdCitizen;
    }

    @Override
    @Transactional
    public Citizens getCitizenById(Integer citizenId) {
        return entityManager.find(Citizens.class, citizenId);
    }

    @Override
    @Transactional
    public List<Citizens> getAllCitizens() {
        return entityManager.createQuery("SELECT c FROM Citizens c", Citizens.class).getResultList();
    }

    @Override
    @Transactional
    public Citizens updateCitizen(Integer citizenId, Citizens updatedCitizens) {
        Citizens existingCitizens = entityManager.find(Citizens.class, citizenId);
        if (existingCitizens != null) {
            existingCitizens.firstname = updatedCitizens.firstname;
            existingCitizens.id_citizens = updatedCitizens.id_citizens;
            existingCitizens.lastname = updatedCitizens.lastname;
            existingCitizens.ZIP_code = updatedCitizens.ZIP_code;
            existingCitizens.phone_number = updatedCitizens.phone_number;
            existingCitizens.Point = updatedCitizens.Point;
            existingCitizens.address = updatedCitizens.address;
            existingCitizens.level = updatedCitizens.level;
            existingCitizens.Note = updatedCitizens.Note;
        }
        return updatedCitizens;
    }

    @Override
    @Transactional
    public void deleteCitizen(Integer citizenId) {
        Citizens citizensToDelete = entityManager.find(Citizens.class, citizenId);
        if (citizensToDelete != null) {
            entityManager.remove(citizensToDelete);
        }
    }

}
