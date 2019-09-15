/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.KnjigaIzlaz;

import Db.KnjigaIzlazDAO;
import Util.HelpClass;
import java.awt.HeadlessException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.KnjigaIzlaz;

/**
 *
 * @author Home
 */
public class UnosKnjigaIzlazGUI extends javax.swing.JDialog {

    /**
     * Creates new form UnosKnjigaIzlazGUI
     *
     * @param parent
     * @param modal
     * @throws java.io.IOException
     */
    public UnosKnjigaIzlazGUI(java.awt.Frame parent, boolean modal) throws IOException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        tfAdresa.requestFocus();
        String datum = HelpClass.localDateFormatter(LocalDate.now());
        tfDatumSlanja.setText(datum);
        KnjigaIzlazDAO db = new KnjigaIzlazDAO();

        tfRedniBroj.setText(String.valueOf(db.maxRedniBrojKI() + 1));

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
        lblDatumPrijema = new javax.swing.JLabel();
        lblPosiljalac = new javax.swing.JLabel();
        lblBrojAkta = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfRedniBroj = new javax.swing.JTextField();
        tfOpis = new javax.swing.JTextField();
        tfKoličina = new javax.swing.JTextField();
        btnSnimi = new javax.swing.JButton();
        tfAdresa = new javax.swing.JTextField();
        tfDatumSlanja = new javax.swing.JTextField();
        tfPoslao = new javax.swing.JTextField();
        jComboVrsta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblOsnovniBroj.setText("Redni broj");

        lblOpis.setText("Adresa");

        lblPodbroj.setText("Opis");

        lblDatumPrijema.setText("Datum slanja");

        lblPosiljalac.setText("Količina");

        lblBrojAkta.setText("Vrsta");

        jLabel1.setText("Poslao");

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

        btnSnimi.setText("Snimi");
        btnSnimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSnimiActionPerformed(evt);
            }
        });

        tfAdresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAdresaActionPerformed(evt);
            }
        });

        jComboVrsta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Obično", "Preporučeno", "Preporučeno sa dostavnicom" }));
        jComboVrsta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboVrstaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDatumPrijema, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPodbroj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPosiljalac, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBrojAkta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOsnovniBroj, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(lblOpis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSnimi)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfKoličina, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(tfAdresa)
                            .addComponent(tfOpis)
                            .addComponent(tfDatumSlanja)
                            .addComponent(tfRedniBroj)
                            .addComponent(tfPoslao)
                            .addComponent(jComboVrsta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(48, 48, 48))))
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
                    .addComponent(lblDatumPrijema)
                    .addComponent(tfDatumSlanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOpis)
                    .addComponent(tfAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfOpis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPodbroj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPosiljalac)
                    .addComponent(tfKoličina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBrojAkta)
                    .addComponent(jComboVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfPoslao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSnimi)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfRedniBrojActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRedniBrojActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRedniBrojActionPerformed

    private void btnSnimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSnimiActionPerformed
        KnjigaIzlazDAO db = new KnjigaIzlazDAO();

        try {

            if (!HelpClass.isNum(tfRedniBroj.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Osnovni broj mora biti cijeli broj!");
                return;
            }

            if (!HelpClass.dateMatcher(tfDatumSlanja.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Datum mora biti u formatu dd.MM.yyyy!");
                return;
            }
            
            if(!HelpClass.isNum(tfKoličina.getText())){
                JOptionPane.showMessageDialog(rootPane, "Količina mora biti cijeli broj!");
                return;
            }

            int redniBroj = Integer.valueOf(tfRedniBroj.getText());
            String adresa = tfAdresa.getText();
            String opis = tfOpis.getText();
            Date date = HelpClass.stringToDate(tfDatumSlanja.getText());
            int kolicina = Integer.valueOf(tfKoličina.getText());
            String vrsta = jComboVrsta.getSelectedItem().toString();
            String poslao = tfPoslao.getText();

            KnjigaIzlaz ki = new KnjigaIzlaz(redniBroj, adresa, opis, date, kolicina, vrsta, poslao);
            db.insertKI(ki);

            db.fillTableKI(KnjigaIzlazGUI.jTablePrikazKnjigaIzlaz);

        } catch (HeadlessException | NumberFormatException | SQLException | ParseException e) {
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UnosKnjigaIzlazGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        HelpClass.clrFields(tfAdresa, tfRedniBroj, tfOpis, tfKoličina, tfPoslao);

        String datum = HelpClass.localDateFormatter(LocalDate.now());
        tfDatumSlanja.setText(datum);
        try {
            tfRedniBroj.setText(String.valueOf(db.maxRedniBrojKI() + 1));
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UnosKnjigaIzlazGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSnimiActionPerformed

    private void tfOpisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfOpisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfOpisActionPerformed

    private void tfAdresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAdresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAdresaActionPerformed

    private void jComboVrstaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboVrstaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboVrstaActionPerformed

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
            java.util.logging.Logger.getLogger(UnosKnjigaIzlazGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                UnosKnjigaIzlazGUI dialog = new UnosKnjigaIzlazGUI(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(UnosKnjigaIzlazGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSnimi;
    private javax.swing.JComboBox<String> jComboVrsta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBrojAkta;
    private javax.swing.JLabel lblDatumPrijema;
    private javax.swing.JLabel lblOpis;
    private javax.swing.JLabel lblOsnovniBroj;
    private javax.swing.JLabel lblPodbroj;
    private javax.swing.JLabel lblPosiljalac;
    private javax.swing.JTextField tfAdresa;
    private javax.swing.JTextField tfDatumSlanja;
    private javax.swing.JTextField tfKoličina;
    private javax.swing.JTextField tfOpis;
    private javax.swing.JTextField tfPoslao;
    private javax.swing.JTextField tfRedniBroj;
    // End of variables declaration//GEN-END:variables
}