package org.acme.model;


public class User {
    public String name;
    public Long id;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
