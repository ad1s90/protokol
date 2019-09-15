package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KnjigaUlaz.class)
public abstract class KnjigaUlaz_ {

	public static volatile SingularAttribute<KnjigaUlaz, String> posiljalac;
	public static volatile SingularAttribute<KnjigaUlaz, Integer> podbroj;
	public static volatile SingularAttribute<KnjigaUlaz, Integer> osnovni_broj;
	public static volatile SingularAttribute<KnjigaUlaz, String> org_jedinica;
	public static volatile SingularAttribute<KnjigaUlaz, Integer> id_ku;
	public static volatile SingularAttribute<KnjigaUlaz, Date> datum_prijema;
	public static volatile SingularAttribute<KnjigaUlaz, String> broj_akta;
	public static volatile SingularAttribute<KnjigaUlaz, String> opis;

	public static final String POSILJALAC = "posiljalac";
	public static final String PODBROJ = "podbroj";
	public static final String OSNOVNI_BROJ = "osnovni_broj";
	public static final String ORG_JEDINICA = "org_jedinica";
	public static final String ID_KU = "id_ku";
	public static final String DATUM_PRIJEMA = "datum_prijema";
	public static final String BROJ_AKTA = "broj_akta";
	public static final String OPIS = "opis";

}

