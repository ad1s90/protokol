package model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knjiga_ulaz")
public class KnjigaUlaz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ku")
    private int id_ku;
    @Column(name = "osnovni_broj")
    private int osnovni_broj;
    @Column(name = "opis")
    private String opis;
    @Column(name = "podbroj")
    private int podbroj;
    @Column(name = "datum_prijema")
    private Date datum_prijema;
    @Column(name = "posiljalac")
    private String posiljalac;
    @Column(name = "broj_akta")
    private String broj_akta;
    @Column(name = "org_jedinica")
    private String org_jedinica;

    public KnjigaUlaz() {
    }

    public KnjigaUlaz(int osnovni_broj, String opis, int podbroj, Date datum_prijema, String posiljalac, String broj_akta, String org_jedinica) {
        this.osnovni_broj = osnovni_broj;
        this.opis = opis;
        this.podbroj = podbroj;
        this.datum_prijema = datum_prijema;
        this.posiljalac = posiljalac;
        this.broj_akta = broj_akta;
        this.org_jedinica = org_jedinica;
    }

    public KnjigaUlaz(int osnovni_broj, String opis, Date datum_prijema, String posiljalac, String broj_akta, String org_jedinica) {
        this.osnovni_broj = osnovni_broj;
        this.opis = opis;
        this.podbroj = podbroj;
        this.datum_prijema = datum_prijema;
        this.posiljalac = posiljalac;
        this.broj_akta = broj_akta;
        this.org_jedinica = org_jedinica;
    }

    public int getId() {
        return id_ku;
    }

    public void setId(int id) {
        this.id_ku = id;
    }

    public int getOsnovni_broj() {
        return osnovni_broj;
    }

    public void setOsnovni_broj(int osnovni_broj) {
        this.osnovni_broj = osnovni_broj;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getPodbroj() {
        return podbroj;
    }

    public void setPodbroj(int podbroj) {
        this.podbroj = podbroj;
    }

    public Date getDatum_prijema() {
        return datum_prijema;
    }

    public void setDatum_prijema(Date datum_prijema) {
        this.datum_prijema = datum_prijema;
    }

    public String getPosiljalac() {
        return posiljalac;
    }

    public void setPosiljalac(String posiljalac) {
        this.posiljalac = posiljalac;
    }

    public String getBroj_akta() {
        return broj_akta;
    }

    public void setBroj_akta(String broj_akta) {
        this.broj_akta = broj_akta;
    }

    public String getOrg_jedinica() {
        return org_jedinica;
    }

    public void setOrg_jedinica(String org_jedinica) {
        this.org_jedinica = org_jedinica;
    }

}
