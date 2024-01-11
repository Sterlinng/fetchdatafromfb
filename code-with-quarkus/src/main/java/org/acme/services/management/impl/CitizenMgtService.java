package org.acme.services.management.impl;


import org.acme.model.Citizen;
import org.acme.services.management.ICitizenMgtService;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CitizenMgtService implements ICitizenMgtService {

    
    @Inject
    EntityManager entityManager;
    

    @Override
    @Transactional
    public Citizen createCitizen(Citizen citizen) {
        entityManager.persist(citizen);
        return citizen;
    }

    @Override
    @Transactional
    public Citizen getCitizenById(Integer citizenId) {
        return entityManager.find(Citizen.class, citizenId);
    }

    @Override
    @Transactional
    public Citizen updateCitizen(Integer citizenId, Citizen updatedCitizen) {
        Citizen existingCitizen = entityManager.find(Citizen.class, citizenId);
        if (existingCitizen != null) {
            existingCitizen.firstname = updatedCitizen.firstname;
            existingCitizen.id = updatedCitizen.id;
        }
        return existingCitizen;
    }

    @Override
    @Transactional
    public void deleteCitizen(Integer citizenId) {
        Citizen citizenToDelete = entityManager.find(Citizen.class, citizenId);
        if (citizenToDelete != null) {
            entityManager.remove(citizenToDelete);
        }
    }

    
    
}
