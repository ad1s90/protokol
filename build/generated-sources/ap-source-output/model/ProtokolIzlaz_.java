package model;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProtokolIzlaz.class)
public abstract class ProtokolIzlaz_ {

	public static volatile SingularAttribute<ProtokolIzlaz, Date> datum;
	public static volatile SingularAttribute<ProtokolIzlaz, Integer> redni_broj;
	public static volatile SingularAttribute<ProtokolIzlaz, String> org_jedinica;
	public static volatile SingularAttribute<ProtokolIzlaz, Integer> id_protokol_izlaz;
	public static volatile SingularAttribute<ProtokolIzlaz, String> registrator;
	public static volatile SingularAttribute<ProtokolIzlaz, String> uradio;
	public static volatile SingularAttribute<ProtokolIzlaz, String> opis;

	public static final String DATUM = "datum";
	public static final String REDNI_BROJ = "redni_broj";
	public static final String ORG_JEDINICA = "org_jedinica";
	public static final String ID_PROTOKOL_IZLAZ = "id_protokol_izlaz";
	public static final String REGISTRATOR = "registrator";
	public static final String URADIO = "uradio";
	public static final String OPIS = "opis";

}

