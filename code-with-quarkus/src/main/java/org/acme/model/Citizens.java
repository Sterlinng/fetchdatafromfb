package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Citizens {

    @Id
    public int id_citizens;
    public String lastname;
    public String firstname;
    public String ZIP_code;
    public String phone_number;
    public String Point;
    public String address;
    public int level;
    public int Note;

    public Citizens(
        int id_citizens, String firstname, String lastname, String ZIP_code, String phone_number, 
        String Point, String address, int level, int Note) {

            this.id_citizens = id_citizens;
            this.firstname = firstname;
            this.lastname = lastname;
            this.ZIP_code = ZIP_code;
            this.phone_number = phone_number;
            this.address = address;
            this.Point = Point;
            this.Note = Note;
            this.level = level;
    }
}