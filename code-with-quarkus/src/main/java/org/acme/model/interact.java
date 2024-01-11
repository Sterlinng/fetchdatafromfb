package org.acme.model;

import jakarta.persistence.Entity;

@Entity
public class interact {
    public String Status;


    public interact(String Status) {
        this.Status = Status;
    }

}
