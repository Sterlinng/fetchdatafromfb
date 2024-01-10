package org.acme.resource.api;

import java.util.List;

import org.acme.dtos.NameListDTO;
import org.acme.services.FetchDataService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/namelist")
public class NameListResource {

    @Inject
    FetchDataService svc;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<NameListDTO> getAllNames() {
        List<NameListDTO> names = svc.getAllData();
        return names;
    }
}
