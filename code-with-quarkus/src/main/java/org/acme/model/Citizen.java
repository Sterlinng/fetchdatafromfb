package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Citizen {
    @Id
    public Long id;
    
    public String name;
}
