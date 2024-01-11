package org.acme.model;

import jakarta.persistence.Entity;

@Entity
public class Send {
    public String notice_user;


    public Send(String notice_user) {
        this.notice_user = notice_user;
    }

}
