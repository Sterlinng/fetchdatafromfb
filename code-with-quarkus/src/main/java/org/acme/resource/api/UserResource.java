package org.acme.resource.api;

import java.util.ArrayList;
import java.util.List;

import org.acme.model.User;
import org.acme.services.impl.UserService;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/user-resource")
@Produces(MediaType.TEXT_HTML)
public class UserResource {

    @Inject
    UserService userService;

    

    @GET
    public String getUsers() {
        // Créez des utilisateurs factices pour la démonstration
        List<User> fakeUsers = new ArrayList<>();
        fakeUsers.add(new User(1L, "John Doe"));
        fakeUsers.add(new User(2L, "Jane Smith"));
        fakeUsers.add(new User(3L, "Alice Johnson"));

        // Générez le HTML pour afficher les utilisateurs factices
        StringBuilder html = new StringBuilder("<html><body><ul>");
        for (User user : fakeUsers) {
            html.append("<li>").append(user.name).append("</li>");
        }
        html.append("</ul></body></html>");

        return html.toString();
    }
}
