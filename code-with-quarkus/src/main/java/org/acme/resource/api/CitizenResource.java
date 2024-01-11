package org.acme.resource.api;
import jakarta.ws.rs.*;
import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/citizen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitizenResource {

    @Inject
    ICitizenMgtService citizenMgtService;

    @POST
    @Path("/createCitizen")
    public Citizens createCitizen(Citizens citizens) {
        return citizenMgtService.createCitizen(citizens);
    }

    @GET
    @Path("/getAllCitizens")
    public List<Citizens> getAllCitizens() {
        return citizenMgtService.getAllCitizens();
    }

    @GET
    @Path("/getCitizenById/{id}")
    public Citizens getCitizenById(@PathParam("id") int id) {
        Citizens citizen = citizenMgtService.getCitizenById(id);
        System.out.println(citizen);
        return citizen;
    }

    @PUT
    @Path("/updateCitizen")
    public Citizens updateCitizen(@PathParam("id") int id, Citizens updatedCitizens) {
        return citizenMgtService.updateCitizen(id, updatedCitizens);
    }

    @DELETE
    @Path("/deleteCitizen")
    public void deleteCitizen(@PathParam("id") int id) {
        citizenMgtService.deleteCitizen(id);
    }
}