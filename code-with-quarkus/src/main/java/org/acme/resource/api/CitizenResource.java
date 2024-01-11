package org.acme.resource.api;
import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("/citizen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitizenResource {

    @Inject
    ICitizenMgtService citizenMgtService;

    @POST
    public Citizens createCitizen(Citizens citizen) {
        return citizenMgtService.createCitizen(citizen);
    }
}