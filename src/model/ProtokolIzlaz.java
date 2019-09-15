package model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "protokol_izlaz")
public class ProtokolIzlaz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_protokol_izlaz")
    private int id_protokol_izlaz;
    @Column(name = "redni_broj")
    private int redni_broj;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "opis")
    private String opis;
    @Column(name = "org_jedinica")
    private String org_jedinica;
    @Column(name = "uradio")
    private String uradio;
    @Column(name = "registrator")
    private String registrator;

    public ProtokolIzlaz() {
    }

    public ProtokolIzlaz(int redni_broj, Date datum, String opis, String org_jedinica, String uradio, String registrator) {
        this.redni_broj = redni_broj;
        this.datum = datum;
        this.opis = opis;
        this.org_jedinica = org_jedinica;
        this.uradio = uradio;
        this.registrator = registrator;
    }

    public int getId_protokol_izlaz() {
        return id_protokol_izlaz;
    }

    public void setId_protokol_izlaz(int id_protokol_izlaz) {
        this.id_protokol_izlaz = id_protokol_izlaz;
    }

    public int getRedni_broj() {
        return redni_broj;
    }

    public void setRedni_broj(int redni_broj) {
        this.redni_broj = redni_broj;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getOrg_jedinica() {
        return org_jedinica;
    }

    public void setOrg_jedinica(String org_jedinica) {
        this.org_jedinica = org_jedinica;
    }

    public String getUradio() {
        return uradio;
    }

    public void setUradio(String uradio) {
        this.uradio = uradio;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getRegistrator() {
        return registrator;
    }

    public void setRegistrator(String registrator) {
        this.registrator = registrator;
    }
    
    

    
    

}
