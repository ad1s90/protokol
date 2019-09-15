package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KnjigaIzlaz.class)
public abstract class KnjigaIzlaz_ {

	public static volatile SingularAttribute<KnjigaIzlaz, String> vrsta;
	public static volatile SingularAttribute<KnjigaIzlaz, Integer> redni_broj;
	public static volatile SingularAttribute<KnjigaIzlaz, Integer> id_ki;
	public static volatile SingularAttribute<KnjigaIzlaz, String> poslao;
	public static volatile SingularAttribute<KnjigaIzlaz, String> primalac;
	public static volatile SingularAttribute<KnjigaIzlaz, Integer> kolicina;
	public static volatile SingularAttribute<KnjigaIzlaz, Date> datum_slanja;
	public static volatile SingularAttribute<KnjigaIzlaz, String> opis;

	public static final String VRSTA = "vrsta";
	public static final String REDNI_BROJ = "redni_broj";
	public static final String ID_KI = "id_ki";
	public static final String POSLAO = "poslao";
	public static final String PRIMALAC = "primalac";
	public static final String KOLICINA = "kolicina";
	public static final String DATUM_SLANJA = "datum_slanja";
	public static final String OPIS = "opis";

}

