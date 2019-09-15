package model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "knjiga_izlaz")
public class KnjigaIzlaz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ki")
    private int id_ki;
    @Column(name = "redni_broj")
    private int redni_broj;
    @Column(name = "primalac")
    private String primalac;
    @Column(name = "opis")
    private String opis;
    @Column(name ="datum_slanja")
    private Date datum_slanja;
    @Column(name = "kolicina")
    private int kolicina;
    @Column(name = "vrsta")
    private String vrsta;
    @Column (name = "poslao")
    private String poslao;

    public KnjigaIzlaz() {
    }

    public KnjigaIzlaz(int redni_broj, String adresa, String opis, Date datum_slanja, int kolicina, String vrsta, String poslao) {
        this.redni_broj = redni_broj;
        this.primalac = adresa;
        this.opis = opis;
        this.datum_slanja = datum_slanja;
        this.kolicina = kolicina;
        this.vrsta = vrsta;
        this.poslao = poslao;
    }


    public int getId_ki() {
        return id_ki;
    }

    public void setId_ki(int id_ki) {
        this.id_ki = id_ki;
    }

    public int getRedni_broj() {
        return redni_broj;
    }

    public void setRedni_broj(int redni_broj) {
        this.redni_broj = redni_broj;
    }
    
    

    public String getPrimalac() {
        return primalac;
    }

    public void setPrimalac(String primalac) {
        this.primalac = primalac;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Date getDatum_slanja() {
        return datum_slanja;
    }

    public void setDatum_slanja(Date datum_slanja) {
        this.datum_slanja = datum_slanja;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getPoslao() {
        return poslao;
    }

    public void setPoslao(String poslao) {
        this.poslao = poslao;
    }
    
    

}
