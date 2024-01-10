package org.acme.model;

import jakarta.persistence.Entity;

@Entity
public class Give {
    public String notice_mission;


    public Give(String notice_mission) {
        this.notice_mission = notice_mission;
    }

}
