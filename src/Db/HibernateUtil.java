package Db;

import java.io.IOException;
import javax.swing.JOptionPane;
import model.KnjigaIzlaz;
import model.KnjigaUlaz;
import model.OrgJedinice;
import model.ProtokolIzlaz;
import model.ProtokolUlaz;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory() throws IOException, ClassNotFoundException {

        if (!TestConnection.testConnection()) {
            JOptionPane.showMessageDialog(null, "Konekcija ne može biti uspotavljena, provjerite konekcione parametre");
            return null;
        } else {

            Configuration cfg = new Configuration();
            MyProperties m = new MyProperties();

            cfg.setProperties(m.myprop());
            cfg.addAnnotatedClass(KnjigaUlaz.class);
            cfg.addAnnotatedClass(KnjigaIzlaz.class);
            cfg.addAnnotatedClass(ProtokolIzlaz.class);
            cfg.addAnnotatedClass(ProtokolUlaz.class);
            cfg.addAnnotatedClass(OrgJedinice.class);

            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    cfg.getProperties()).build();

            sessionFactory = cfg.buildSessionFactory(serviceRegistry);

            return sessionFactory;

        }
    }

    public static void close() {
        StandardServiceRegistryBuilder.destroy(serviceRegistry);
    }

}
