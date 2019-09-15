package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "org_jedinice")
public class OrgJedinice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_org_jedinice")
    private int id_org_jedinice;
    @Column(name = "naziv")
    private String naziv;

    public OrgJedinice() {
    }

    public OrgJedinice(String naziv) {
        this.naziv = naziv;
    }

    public int getId_org_jedinice() {
        return id_org_jedinice;
    }

    public void setId_org_jedinice(int id_org_jedinice) {
        this.id_org_jedinice = id_org_jedinice;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return  naziv ;
    }
    
    
    

}
