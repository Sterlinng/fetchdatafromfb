package org.acme.model;

import java.sql.Date;

public class Certificate {
    public int id_certificate;
    public String wording;
    public String name;
    public Date date_certificate;


    public Certificate(int id_certificate, String wording, String name, Date date_certificate) {
        this.id_certificate = id_certificate;
        this.wording = wording;
        this.name = name;
        this.date_certificate = date_certificate;
    }

}
