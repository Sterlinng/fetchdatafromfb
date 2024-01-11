package org.acme.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class State {

    @Id
    public int id_state;
    public String wording;
    public Date date_state;

    public State(){

    }

    public State(int id_state, String wording, Date date_state) {
        this.id_state = id_state;
        this.wording = wording;
        this.date_state = date_state;
    }
}

  
