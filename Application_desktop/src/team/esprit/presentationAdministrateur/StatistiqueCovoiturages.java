package team.esprit.presentationAdministrateur;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import team.esprit.controllers.StatCovoiturageController;
import team.esprit.util.GenererPDFCovoiturage;

public class StatistiqueCovoiturages extends javax.swing.JFrame {

    public File directoryCovoitureur = new File("./pictures/covoiturages");
    public String date;

    public StatistiqueCovoiturages() {
        initComponents();
        setTitle("Statistiques des covoiturages");
        initialise();
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        directoryCovoitureur.mkdirs();
        date = new Date().toString();
        date = date.substring(4, 10);
        date = date.replaceAll("\\s+", "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        boutton_CovoituragesCreesAnnee = new javax.swing.JButton();
        boutton_CovoiturageCreesMois = new javax.swing.JButton();
        boutton_VillesPlusVisitees = new javax.swing.JButton();
        boutton_GenererRapport = new javax.swing.JButton();
        boutton_Retour = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boutton_CovoituragesCreesAnnee.setText("Covoiturages crées par année");
        boutton_CovoituragesCreesAnnee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_CovoituragesCreesAnneeActionPerformed(evt);
            }
        });

        boutton_CovoiturageCreesMois.setText("Covoiturages crées par mois");
        boutton_CovoiturageCreesMois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_CovoiturageCreesMoisActionPerformed(evt);
            }
        });

        boutton_VillesPlusVisitees.setText("Frequences de visites des villes");
        boutton_VillesPlusVisitees.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_VillesPlusVisiteesActionPerformed(evt);
            }
        });

        boutton_GenererRapport.setText("Générer Rapport");
        boutton_GenererRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_GenererRapportActionPerformed(evt);
            }
        });

        boutton_Retour.setText("Retour");
        boutton_Retour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_RetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(boutton_GenererRapport, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addGap(116, 116, 116)
                        .addComponent(boutton_Retour)
                        .addGap(86, 86, 86))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(boutton_VillesPlusVisitees, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutton_CovoiturageCreesMois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boutton_CovoituragesCreesAnnee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(boutton_CovoituragesCreesAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_CovoiturageCreesMois, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boutton_VillesPlusVisitees, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_GenererRapport)
                    .addComponent(boutton_Retour))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_RetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_RetourActionPerformed
        GenererStatistiques genererLesStatistique = new GenererStatistiques();
        genererLesStatistique.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_RetourActionPerformed

    private void boutton_CovoituragesCreesAnneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_CovoituragesCreesAnneeActionPerformed
        StatCovoiturageController statCovoiturageController = new StatCovoiturageController();
        JFreeChart chart = statCovoiturageController.statistiqueCovoiturageParAn();
        try {
            ChartUtilities.saveChartAsJPEG(new File(directoryCovoitureur + "\\" + date + "_chartNombreCovoiturageParAn.jpg"), chart, 1366, 768);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ChartFrame frame = new ChartFrame("Covoiturages crées par Année", chart);
        frame.setVisible(true);
        frame.setSize(450, 400);
    }//GEN-LAST:event_boutton_CovoituragesCreesAnneeActionPerformed

    private void boutton_CovoiturageCreesMoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_CovoiturageCreesMoisActionPerformed
        StatCovoiturageController statCovoiturageController = new StatCovoiturageController();
        JFreeChart chart = statCovoiturageController.statistiqueCovoiturageParMois();
        try {
            ChartUtilities.saveChartAsJPEG(new File(directoryCovoitureur + "\\" + date + "_chartNombreCovoiturageParMois.jpg"), chart, 1366, 768);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ChartFrame frame = new ChartFrame("Covoiturages crées pas mois", chart);
        frame.setVisible(true);
        frame.setSize(450, 400);
    }//GEN-LAST:event_boutton_CovoiturageCreesMoisActionPerformed

    private void boutton_VillesPlusVisiteesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_VillesPlusVisiteesActionPerformed
        StatCovoiturageController statCovoiturageController = new StatCovoiturageController();
        JFreeChart chart = statCovoiturageController.statistiqueCovoiturageFrequenceVille();
        try {
            ChartUtilities.saveChartAsJPEG(new File(directoryCovoitureur + "\\" + date + "_hartFrequenceVillesVisites.jpg"), chart, 1366, 768);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        ChartFrame frame = new ChartFrame("Frequence par ville", chart);
        frame.setVisible(true);
        frame.setSize(450, 400);
    }//GEN-LAST:event_boutton_VillesPlusVisiteesActionPerformed

    private void boutton_GenererRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_GenererRapportActionPerformed
        GenererPDFCovoiturage.main(null);
        JOptionPane.showMessageDialog(this, "Les rapport on été crées.");
    }//GEN-LAST:event_boutton_GenererRapportActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatistiqueCovoiturages().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_CovoiturageCreesMois;
    private javax.swing.JButton boutton_CovoituragesCreesAnnee;
    private javax.swing.JButton boutton_GenererRapport;
    private javax.swing.JButton boutton_Retour;
    private javax.swing.JButton boutton_VillesPlusVisitees;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}