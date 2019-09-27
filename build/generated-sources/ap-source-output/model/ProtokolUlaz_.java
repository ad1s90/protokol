package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProtokolUlaz.class)
public abstract class ProtokolUlaz_ {

	public static volatile SingularAttribute<ProtokolUlaz, Date> datum;
	public static volatile SingularAttribute<ProtokolUlaz, Integer> redni_broj;
	public static volatile SingularAttribute<ProtokolUlaz, String> org_jedinica;
	public static volatile SingularAttribute<ProtokolUlaz, String> dostavljeno;
	public static volatile SingularAttribute<ProtokolUlaz, Integer> id_protokol_ulaz;
	public static volatile SingularAttribute<ProtokolUlaz, String> naziv_dokumenta;

	public static final String DATUM = "datum";
	public static final String REDNI_BROJ = "redni_broj";
	public static final String ORG_JEDINICA = "org_jedinica";
	public static final String DOSTAVLJENO = "dostavljeno";
	public static final String ID_PROTOKOL_ULAZ = "id_protokol_ulaz";
	public static final String NAZIV_DOKUMENTA = "naziv_dokumenta";

}

