package org.acme.model;

import java.sql.Date;

public class State {
    public int id_state;
    public String wording;
    public Date date_state;

    public State(int id_state, String wording, Date date_state) {
        this.id_state = id_state;
        this.wording = wording;
        this.date_state = date_state;
    }
}

  
