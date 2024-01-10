package org.acme.controller;

import org.acme.model.User;
import org.acme.services.IUserService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    
    

    @Inject
    IUserService svc;


    @POST
    public void createUser(User user) {
        svc.createUser(user);
    }
}
