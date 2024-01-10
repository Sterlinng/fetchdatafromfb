package org.acme.services;

import java.util.List;

import org.acme.model.User;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IUserService {

    /*
     * @param user -> User
     */
    public void createUser(User usr);

    /*
     * @returns List of users
     */
    public List<User> getAllUsers();
}
