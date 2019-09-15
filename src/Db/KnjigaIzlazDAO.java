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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.KnjigaIzlaz;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class KnjigaIzlazDAO {

    HibernateUtil hb;
    Transaction tx;
    Session session;
    KnjigaIzlaz knjigaIzlaz;
    
    

    public void insertKI(KnjigaIzlaz knjigaIzlaz) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
    
        tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(knjigaIzlaz);
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

    public void fillTableKI(JTable table) throws SQLException, IOException, ClassNotFoundException {
        knjigaIzlaz = null;
        List<KnjigaIzlaz> list = getAllKI();

        Object[] columnNames = {"Redni broj", "Primalac", "Opis", "Datum slanja", "Količina", "Vrsta", "Poslao", "ID"};
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columnNames);

        for (KnjigaIzlaz k : list) {
            Object[] obj = new Object[8];
            obj[0] = k.getRedni_broj();
            obj[1] = k.getPrimalac();
            obj[2] = k.getOpis();
            obj[3] = k.getDatum_slanja();
            obj[4] = k.getKolicina();
            obj[5] = k.getVrsta();
            obj[6] = k.getPoslao();
            obj[7] = k.getId_ki();
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

    public List getAllKI() throws IOException, ClassNotFoundException {

        List<KnjigaIzlaz> list = new ArrayList();
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
                 
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<KnjigaIzlaz> cq = cb.createQuery(KnjigaIzlaz.class);
            Root<KnjigaIzlaz> from = cq.from(KnjigaIzlaz.class);
            TypedQuery<KnjigaIzlaz> tq = session.createQuery(cq.orderBy(cb.asc(from.get("redni_broj"))));
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

    public int maxRedniBrojKI() throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        DetachedCriteria criteria = DetachedCriteria.forClass(KnjigaIzlaz.class).setProjection(Projections.max("redni_broj"));

        if (criteria.getExecutableCriteria(session).list().get(0) != null) {

            int maxBroj = (int) criteria.getExecutableCriteria(session).list().get(0);
            System.out.println(maxBroj);
            return maxBroj;

        } else {
            return 0;
        }

    }

    public void updateKI(int id_ki, int redni_broj, String primalac, String opis, Date datum_slanja, int kolicina, String vrsta, String poslao) throws IOException, ClassNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            knjigaIzlaz = (KnjigaIzlaz) session.get(KnjigaIzlaz.class, id_ki);
            knjigaIzlaz.setRedni_broj(redni_broj);
            knjigaIzlaz.setPrimalac(primalac);
            knjigaIzlaz.setOpis(opis);
            knjigaIzlaz.setDatum_slanja(datum_slanja);
            knjigaIzlaz.setKolicina(kolicina);
            knjigaIzlaz.setVrsta(vrsta);
            knjigaIzlaz.setPoslao(poslao);

            session.update(knjigaIzlaz);
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

    public KnjigaIzlaz getKI(int id_ki) throws IOException, ClassNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = null;

        try {
            tx = session.beginTransaction();
            knjigaIzlaz = (KnjigaIzlaz) session.get(KnjigaIzlaz.class, id_ki);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e);
        } finally {
            HibernateUtil.close();
        }

        return knjigaIzlaz;
    }

}
