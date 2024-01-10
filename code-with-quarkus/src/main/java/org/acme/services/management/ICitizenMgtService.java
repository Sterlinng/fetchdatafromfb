package org.acme.services.management;

import org.acme.model.Citizen;

public interface ICitizenMgtService {

    /**
     * Create a new citizen in the DataBase
     *
     * @param citizen -> The citizen we want to create
     * @return The created citizen with a valid id.
     */
    public Citizen createCitizen(Citizen citizen);

    /**
     * Read a citizen by an id
     * 
     * @param citizenId -> The citizen's id
     * @return The Citizen
     */
    public Citizen getCitizenById(Integer citizenId);

    /**
     * Update a citizen's information
     * 
     * @param citizenId -> The Citizen we want to update
     * @param updatedCitizen -> The updated citizen
     * @return Updated Citizen
     */
    public Citizen updateCitizen(Integer citizenId, Citizen updatedCitizen);

    /**
     * Delete a Citizen
     * 
     * @param citizenId -> The Citizen's Id
     * @return None
     */
    public void deleteCitizen(Integer citizenId);
    
    
}