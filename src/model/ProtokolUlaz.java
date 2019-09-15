package model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "protokol_ulaz")
public class ProtokolUlaz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_protokol_ulaz")
    private int id_protokol_ulaz;
    @Column(name = "datum")
    private Date datum;
    @Column(name = "redni_broj")
    private int redni_broj;
    @Column(name = "dostavljeno")
    private String dostavljeno;
    @Column(name = "naziv_dokumenta")
    private String naziv_dokumenta;
    @Column(name = "org_jedinica")
    private String org_jedinica;

    public ProtokolUlaz() {
    }

    public ProtokolUlaz(Date datum, int redni_broj, String dostavljeno, String naziv_dokumenta, String org_jedinica) {
        this.datum = datum;
        this.redni_broj = redni_broj;
        this.dostavljeno = dostavljeno;
        this.naziv_dokumenta = naziv_dokumenta;
        this.org_jedinica = org_jedinica;
    }

    public int getId_protokol_ulaz() {
        return id_protokol_ulaz;
    }

    public void setId_protokol_ulaz(int id_protokol_ulaz) {
        this.id_protokol_ulaz = id_protokol_ulaz;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public int getRedni_broj() {
        return redni_broj;
    }

    public void setRedni_broj(int redni_broj) {
        this.redni_broj = redni_broj;
    }
    
    

    public String getDostavljeno() {
        return dostavljeno;
    }

    public void setDostavljeno(String dostavljeno) {
        this.dostavljeno = dostavljeno;
    }

    public String getNaziv_dokumenta() {
        return naziv_dokumenta;
    }

    public void setNaziv_dokumenta(String naziv_dokumenta) {
        this.naziv_dokumenta = naziv_dokumenta;
    }

    public String getOrg_jedinica() {
        return org_jedinica;
    }

    public void setOrg_jedinica(String org_jedinica) {
        this.org_jedinica = org_jedinica;
    }

}
