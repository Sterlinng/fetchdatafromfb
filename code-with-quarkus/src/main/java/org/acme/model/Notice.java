package org.acme.model;

import java.sql.Date;

public class Notice {
    public String wording;
    public int id_notice;
    public String contained;
    public Date date_notice;

    public Notice(int id_avis, String name, String contenue, Date date_avis) {
        this.id_notice = id_avis;
        this.wording = name;
        this.contained = contenue;
        this.date_notice = date_avis;
    }
}