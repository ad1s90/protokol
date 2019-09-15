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
import model.ProtokolUlaz;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class ProtokolUlazDAO {

    HibernateUtil hb;
    Transaction tx;
    Session session;
    ProtokolUlaz protokolUlaz;

    public void insertPU(ProtokolUlaz protokolUlaz) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(protokolUlaz);
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

    public List getAllPU() throws IOException, ClassNotFoundException {

        List<ProtokolUlaz> list = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ProtokolUlaz> cq = cb.createQuery(ProtokolUlaz.class);
            Root<ProtokolUlaz> from = cq.from(ProtokolUlaz.class);
            TypedQuery<ProtokolUlaz> tq = session.createQuery(cq.orderBy(cb.asc(from.get("datum"))));
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

    public void fillTablePU(JTable table) throws SQLException, IOException, ClassNotFoundException {
        protokolUlaz = null;
        List<ProtokolUlaz> list = getAllPU();

        Object[] columnNames = {"Datum", "Redni broj", "Dostavljeno", "Naziv dokumenta", "Org. jedinica", "ID"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (ProtokolUlaz k : list) {
            Object[] obj = new Object[7];
            obj[0] = k.getDatum();
            obj[1] = k.getRedni_broj();
            obj[2] = k.getDostavljeno();
            obj[3] = k.getNaziv_dokumenta();
            obj[4] = k.getOrg_jedinica();
            obj[5] = k.getId_protokol_ulaz();
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

   
    public int maxRedniBrojPU() throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(ProtokolUlaz.class).setProjection(Projections.max("redni_broj"));

        if (criteria.getExecutableCriteria(session).list().get(0) != null) {

            int maxBroj = (int) criteria.getExecutableCriteria(session).list().get(0);
            System.out.println(maxBroj);
            return maxBroj;

        } else {
            return 0;
        }
    }

    public void updatePU(int id, Date datum, int broj, String dostavljeno, String nazivDokumenta, String orgJedinica) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            protokolUlaz = (ProtokolUlaz) session.get(ProtokolUlaz.class, id);
            protokolUlaz.setDatum(datum);
            protokolUlaz.setRedni_broj(broj);
            protokolUlaz.setDostavljeno(dostavljeno);
            protokolUlaz.setNaziv_dokumenta(nazivDokumenta);
            protokolUlaz.setOrg_jedinica(orgJedinica);

            session.update(protokolUlaz);
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

    public ProtokolUlaz getPU(int id) throws IOException, ClassNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            protokolUlaz = (ProtokolUlaz) session.get(ProtokolUlaz.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return protokolUlaz;
    }

}
