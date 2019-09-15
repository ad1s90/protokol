package Db;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ProtokolIzlaz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class ProtokolIzlazDAO {

    HibernateUtil hb;
    Transaction tx;
    Session session;
    ProtokolIzlaz protokolIzlaz;

    public void insertPI(ProtokolIzlaz protokolIzlaz) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(protokolIzlaz);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }
    }

    public List getAllPI() throws IOException, ClassNotFoundException {

        List<ProtokolIzlaz> list = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ProtokolIzlaz> cq = cb.createQuery(ProtokolIzlaz.class);
            Root<ProtokolIzlaz> from = cq.from(ProtokolIzlaz.class);
            TypedQuery<ProtokolIzlaz> tq = session.createQuery(cq.orderBy(cb.asc(from.get("redni_broj"))));
            list = tq.getResultList();

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return list;
    }

    public void fillTablePI(JTable table) throws SQLException, IOException, ClassNotFoundException {
        protokolIzlaz = null;
        List<ProtokolIzlaz> list = getAllPI();

        Object[] columnNames = {"Redni broj", "Datum", "Opis", "Org. jedinica", "Uradio", "Registrator", "ID"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (ProtokolIzlaz k : list) {
            Object[] obj = new Object[7];
            obj[0] = k.getRedni_broj();
            obj[1] = k.getDatum();
            obj[2] = k.getOpis();
            obj[3] = k.getOrg_jedinica();
            obj[4] = k.getUradio();
            obj[5] = k.getRegistrator();
            obj[6] = k.getId_protokol_izlaz();
            model.addRow(obj);
        }

        table.setModel(model);

        table.getColumnModel().removeColumn(table.getColumn("ID"));

        table.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                table.scrollRectToVisible(table.getCellRect(table.getRowCount() - 1, 0, true));
            }
        });
    }

    public int maxRedniBrojPI() throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(ProtokolIzlaz.class).setProjection(Projections.max("redni_broj"));

        if (criteria.getExecutableCriteria(session).list().get(0) != null) {

            int maxBroj = (int) criteria.getExecutableCriteria(session).list().get(0);
            System.out.println(maxBroj);
            return maxBroj;

        } else {
            return 0;
        }
    }

    public void updatePI(int id, int redniBroj, Date datum, String opis, String orgJedinica, String uradio, String registrator) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            protokolIzlaz = (ProtokolIzlaz) session.get(ProtokolIzlaz.class, id);
            protokolIzlaz.setRedni_broj(redniBroj);
            protokolIzlaz.setDatum(datum);
            protokolIzlaz.setOpis(opis);
            protokolIzlaz.setOrg_jedinica(orgJedinica);
            protokolIzlaz.setUradio(uradio);
            protokolIzlaz.setRegistrator(registrator);

            session.update(protokolIzlaz);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

    }
    
        public ProtokolIzlaz getPI(int id) throws IOException, ClassNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            protokolIzlaz = (ProtokolIzlaz) session.get(ProtokolIzlaz.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return protokolIzlaz;
    }

}
