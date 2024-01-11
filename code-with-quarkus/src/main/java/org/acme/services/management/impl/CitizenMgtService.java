package org.acme.services.management.impl;


import jakarta.persistence.NoResultException;
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
    public Citizens createCitizen(Citizens citizens) {
        entityManager.persist(citizens);
        return citizens;
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
        }
        return existingCitizens;
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
