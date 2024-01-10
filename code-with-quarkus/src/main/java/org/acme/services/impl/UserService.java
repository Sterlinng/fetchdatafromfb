package org.acme.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.acme.model.User;
import org.acme.services.IUserService;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService implements IUserService {
    
    private List<User> userList = new ArrayList<>();

    @Override
    public void createUser(User usr){
        userList.add(usr);
    }

    @Override
    public List<User> getAllUsers() {
        return userList;
    }
}
