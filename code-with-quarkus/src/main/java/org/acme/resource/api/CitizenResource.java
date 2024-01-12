package org.acme.resource.api;
import java.util.List;

import org.acme.model.Citizens;
import org.acme.services.management.ICitizenMgtService;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

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
    @Path("/updateCitizen/{id}")
    public Citizens updateCitizen(@PathParam("id") int id, Citizens updatedCitizens) {
        return citizenMgtService.updateCitizen(id, updatedCitizens);
    }

    @DELETE
    @Path("/deleteCitizen/{id}")
    public void deleteCitizen(@PathParam("id") int id) {
        citizenMgtService.deleteCitizen(id);
    }
}