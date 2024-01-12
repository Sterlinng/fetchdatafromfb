package org.acme.resource.api;
import org.acme.model.Citizens;
import org.acme.resource.api.dto.CreateUserDTO;
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
<<<<<<< HEAD
    @Path("/createCitizen")
    public Citizens createCitizen(CreateUserDTO NewUserDTO) {
        return citizenMgtService.createCitizen(NewUserDTO);
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
=======
    public Citizens createCitizen(Citizens citizen) {
        return citizenMgtService.createCitizen(citizen);
>>>>>>> bf21fa4229dd7191f0bcd08bd0cd99ce4cf24100
    }
}