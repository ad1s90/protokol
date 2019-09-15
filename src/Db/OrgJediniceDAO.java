package Db;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.OrgJedinice;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OrgJediniceDAO {

    HibernateUtil hb;
    Transaction tx;
    Session session;
    OrgJedinice orgJedinice;

    public void insertOrgJed(OrgJedinice orgJedinice) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(orgJedinice);
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

    public void fillTableOrgJed(JTable table) throws SQLException, IOException, ClassNotFoundException {
        orgJedinice = null;
        List<OrgJedinice> list = getAllOrgJed();

        Object[] columnNames = {"Naziv", "ID"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (OrgJedinice k : list) {
            Object[] obj = new Object[2];
            obj[0] = k.getNaziv();
            obj[1] = k.getId_org_jedinice();
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

    public List getAllOrgJed() throws IOException, ClassNotFoundException {

        List<OrgJedinice> list = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            //list = session.createCriteria(KnjigaIzlaz.class).addOrder(Order.asc("redni_broj")).list();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<OrgJedinice> cq = cb.createQuery(OrgJedinice.class);
            Root<OrgJedinice> from = cq.from(OrgJedinice.class);
            TypedQuery<OrgJedinice> tq = session.createQuery(cq.orderBy(cb.asc(from.get("naziv"))));
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

    public void updateOrgJed(int id_org_jed, String naziv) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            orgJedinice = (OrgJedinice) session.get(OrgJedinice.class, id_org_jed);
            orgJedinice.setNaziv(naziv);

            session.update(orgJedinice);
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

    public OrgJedinice getOrgJed(int id_orgJed) throws IOException, ClassNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            orgJedinice = (OrgJedinice) session.get(OrgJedinice.class, id_orgJed);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return orgJedinice;
    }

    public void deleteOrgJed(int id) throws IOException, ClassNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            orgJedinice = (OrgJedinice) session.get(OrgJedinice.class, id);
            session.delete(orgJedinice);
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

}
