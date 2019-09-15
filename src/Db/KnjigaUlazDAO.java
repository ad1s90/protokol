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
import model.KnjigaUlaz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class KnjigaUlazDAO {

    HibernateUtil hb;
    Transaction tx;
    Session session;
    KnjigaUlaz knjigaUlaz;

    public void insertKU(KnjigaUlaz knjigaUlaz) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(knjigaUlaz);
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

    public void fillTableKU(JTable table) throws SQLException, IOException, ClassNotFoundException {
        knjigaUlaz = null;
        List<KnjigaUlaz> list = getAllKU();

        Object[] columnNames = {"Osnovni broj", "Opis", "Podbroj", "Datum prijema", "Pošiljalac", "Broj akta", "Org. jedinica", "ID"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (KnjigaUlaz k : list) {
            Object[] obj = new Object[8];
            obj[0] = k.getOsnovni_broj();
            obj[1] = k.getOpis();
            obj[2] = k.getPodbroj();
            obj[3] = k.getDatum_prijema();
            obj[4] = k.getPosiljalac();
            obj[5] = k.getBroj_akta();
            obj[6] = k.getOrg_jedinica();
            obj[7] = k.getId();
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

    public List getAllKU() throws IOException, ClassNotFoundException {

        List<KnjigaUlaz> list = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            //list = session.createCriteria(KnjigaUlaz.class).addOrder(Order.asc("osnovni_broj")).list();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<KnjigaUlaz> cq = cb.createQuery(KnjigaUlaz.class);
            Root<KnjigaUlaz> from = cq.from(KnjigaUlaz.class);
            TypedQuery<KnjigaUlaz> tq = session.createQuery(cq.orderBy(cb.asc(from.get("osnovni_broj"))));
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

    public int maxOsnovniBrojKU() throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(KnjigaUlaz.class).setProjection(Projections.max("osnovni_broj"));

        if (criteria.getExecutableCriteria(session).list().get(0) != null) {

            int maxBroj = (int) criteria.getExecutableCriteria(session).list().get(0);
            System.out.println(maxBroj);
            return maxBroj;

        } else {
            return 0;
        }

    }

    public void updateKU(int id, int osnovniBroj, String opis, int podBroj, Date datum_prijema, String posiljalac, String broj_akta, String org_jedinica) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            knjigaUlaz = (KnjigaUlaz) session.get(KnjigaUlaz.class, id);
            knjigaUlaz.setOsnovni_broj(osnovniBroj);
            knjigaUlaz.setOpis(opis);
            knjigaUlaz.setPodbroj(podBroj);
            knjigaUlaz.setDatum_prijema(datum_prijema);
            knjigaUlaz.setPosiljalac(posiljalac);
            knjigaUlaz.setBroj_akta(broj_akta);
            knjigaUlaz.setOrg_jedinica(org_jedinica);

            session.update(knjigaUlaz);
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

    public KnjigaUlaz getKU(int id) throws IOException, ClassNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            knjigaUlaz = (KnjigaUlaz) session.get(KnjigaUlaz.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return knjigaUlaz;
    }

}
