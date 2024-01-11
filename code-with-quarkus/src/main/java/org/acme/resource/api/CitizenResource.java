package org.acme.resource.api;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.acme.model.Citizen;
import org.acme.services.management.ICitizenMgtService;

import jakarta.inject.Inject;

@Path("/citizen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitizenResource {

    @Inject
    ICitizenMgtService citizenMgtService;

    @POST
    public Citizen createCitizen(Citizen citizen) {
        return citizenMgtService.createCitizen(citizen);
    }
}