package org.acme.services.management.impl;

import java.util.List;

import org.acme.model.Mission;
import org.acme.services.management.IMissionMgtService;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class MissionMgtService implements IMissionMgtService{
    @Inject
    EntityManager entityManager;

    @Override
    @Transactional
    public Mission createMission(Mission mission) {
        entityManager.persist(mission);
        return mission;
    }

    @Override
    @Transactional
    public Mission getMissionById(int missionId) {
        return entityManager.find(Mission.class, missionId);
    }

    @Override
    @Transactional
    public List<Mission> getAllMissions() {
        return entityManager.createQuery("SELECT m FROM Mission m", Mission.class).getResultList();
    }

    @Override
    @Transactional
    public Mission updateMission(int missionId, Mission updatedMission) {
        Mission existingMission = entityManager.find(Mission.class, missionId);
        if (existingMission != null) {
            existingMission.wording = updatedMission.wording;
            existingMission.date_mission = updatedMission.date_mission;
            existingMission.name = updatedMission.name;
            existingMission.note = updatedMission.note;
            existingMission.ZIP_code = updatedMission.ZIP_code;
            existingMission.address = updatedMission.address;
            existingMission.beginning_hour = updatedMission.beginning_hour;
            existingMission.end_hour = updatedMission.end_hour;
            existingMission.description = updatedMission.description;
        }
        return existingMission;
    }

    @Override
    @Transactional
    public void deleteMission(int missionId) {
        Mission missionToDelete = entityManager.find(Mission.class, missionId);
        if (missionToDelete != null) {
            entityManager.remove(missionToDelete);
        }
    }
}
