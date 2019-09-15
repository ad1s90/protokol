/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.ProtokolIzlaz;

import Db.OrgJediniceDAO;
import Db.ProtokolIzlazDAO;
import static GUI.ProtokolIzlaz.ProtokolIzlazGUI.jTablePrikazProtokolIzlaz;
import Util.HelpClass;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.OrgJedinice;
import model.ProtokolIzlaz;

/**
 *
 * @author Home
 */
public class EditProtokolIzlazGUI extends javax.swing.JDialog {

    /**
     * Creates new form UnosKnjigaIzlazGUI
     *
     * @param parent
     * @param modal
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public EditProtokolIzlazGUI(java.awt.Frame parent, boolean modal) throws IOException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        tfOpis.requestFocus();

        ProtokolIzlazDAO db = new ProtokolIzlazDAO();
        OrgJediniceDAO datab = new OrgJediniceDAO();
        List<OrgJedinice> list;
        list = datab.getAllOrgJed();
        List<String> stringList = new ArrayList<>();

        comboOrgJedinica.setModel(new DefaultComboBoxModel(list.toArray()));

        int row = jTablePrikazProtokolIzlaz.getSelectedRow();
        String value = jTablePrikazProtokolIzlaz.getModel().getValueAt(row, 6).toString();

        ProtokolIzlaz protokolIzlaz = db.getPI(Integer.valueOf(value));

        Date date = protokolIzlaz.getDatum();
        tfRedniBroj.setText(String.valueOf(protokolIzlaz.getRedni_broj()));
        tfDatum.setText(value);
        tfOpis.setText(protokolIzlaz.getOpis());
        tfUradio.setText(protokolIzlaz.getUradio());
        tfRegistrator.setText(protokolIzlaz.getRegistrator());

        String datum = HelpClass.dateFormatter(date);
        tfDatum.setText(datum);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOsnovniBroj = new javax.swing.JLabel();
        lblOpis = new javax.swing.JLabel();
        lblPodbroj = new javax.swing.JLabel();
        lblPosiljalac = new javax.swing.JLabel();
        lblBrojAkta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfRedniBroj = new javax.swing.JTextField();
        tfOpis = new javax.swing.JTextField();
        tfUradio = new javax.swing.JTextField();
        tfRegistrator = new javax.swing.JTextField();
        comboOrgJedinica = new javax.swing.JComboBox<>();
        btnSnimi = new javax.swing.JButton();
        tfDatum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblOsnovniBroj.setText("Redni broj");

        lblOpis.setText("Datum");

        lblPodbroj.setText("Opis");

        lblPosiljalac.setText("Uradio");

        lblBrojAkta.setText("Registrator");

        jLabel1.setText("Org. jedinica");

        tfRedniBroj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRedniBrojActionPerformed(evt);
            }
        });

        tfOpis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfOpisActionPerformed(evt);
            }
        });

        comboOrgJedinica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Racunovodsvo", "Item 2", "Item 3", "Item 4" }));

        btnSnimi.setText("Snimi");
        btnSnimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnimiActionPerformed(evt);
            }
        });

        tfDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDatumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSnimi))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPodbroj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPosiljalac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBrojAkta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOsnovniBroj, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(lblOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboOrgJedinica, 0, 220, Short.MAX_VALUE)
                            .addComponent(tfRegistrator)
                            .addComponent(tfUradio)
                            .addComponent(tfDatum)
                            .addComponent(tfOpis)
                            .addComponent(tfRedniBroj))))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOsnovniBroj)
                    .addComponent(tfRedniBroj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpis)
                    .addComponent(tfDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPodbroj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboOrgJedinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfUradio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosiljalac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBrojAkta)
                    .addComponent(tfRegistrator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(btnSnimi)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfRedniBrojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRedniBrojActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRedniBrojActionPerformed

    private void btnSnimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnimiActionPerformed
        ProtokolIzlazDAO db = new ProtokolIzlazDAO();

        try {

            if (!HelpClass.isNum(tfRedniBroj.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Redni broj mora biti cijeli broj!");
                return;
            }

            if (!HelpClass.dateMatcher(tfDatum.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Datum mora biti u formatu dd.MM.yyyy!");
                return;
            }

            int row = jTablePrikazProtokolIzlaz.getSelectedRow();
            String value = jTablePrikazProtokolIzlaz.getModel().getValueAt(row, 6).toString();
            int id = Integer.valueOf(value);

            int redniBoj = Integer.valueOf(tfRedniBroj.getText());
            String opis = tfOpis.getText();
            Date date = HelpClass.stringToDate(tfDatum.getText());
            String uradio = tfUradio.getText();
            String registrator = tfRegistrator.getText();
            String orgJedinica = comboOrgJedinica.getSelectedItem().toString();

            db.updatePI(id, redniBoj, date, opis, orgJedinica, uradio, registrator);

            db.fillTablePI(ProtokolIzlazGUI.jTablePrikazProtokolIzlaz);

        } catch (HeadlessException | NumberFormatException | SQLException | ParseException e) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EditProtokolIzlazGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();


    }//GEN-LAST:event_btnSnimiActionPerformed

    private void tfOpisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOpisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOpisActionPerformed

    private void tfDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDatumActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProtokolIzlazGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                EditProtokolIzlazGUI dialog = new EditProtokolIzlazGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(EditProtokolIzlazGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnimi;
    private javax.swing.JComboBox<String> comboOrgJedinica;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBrojAkta;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblOsnovniBroj;
    private javax.swing.JLabel lblPodbroj;
    private javax.swing.JLabel lblPosiljalac;
    private javax.swing.JTextField tfDatum;
    private javax.swing.JTextField tfOpis;
    private javax.swing.JTextField tfRedniBroj;
    private javax.swing.JTextField tfRegistrator;
    private javax.swing.JTextField tfUradio;
    // End of variables declaration//GEN-END:variables
}
