package team.esprit.presentationAdministrateur;

import javax.swing.JOptionPane;
import team.esprit.util.MailSender;
import team.esprit.dao.ReclamationDAO;
import team.esprit.entities.Reclamation;

public class RepondreReclamation extends javax.swing.JFrame {

    MailSender mailController = new MailSender();
    Reclamation reclamation = new Reclamation();
    ReclamationDAO reclamationDAO = new ReclamationDAO();
    int idReclamation;

    public RepondreReclamation() {
        this.dispose();
        initialise();
    }

    public RepondreReclamation(int idReclamation) {
        initComponents();
        setTitle("Répondre à une réclamation");
        initialise();
        this.idReclamation = idReclamation;
        reclamation = reclamationDAO.afficherReclamation(idReclamation);
        tf_Email.setText(reclamation.getEmail());
    }

    public void initialise() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ta_Message.setLineWrap(true);
        ta_Message.setWrapStyleWord(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_Message = new javax.swing.JTextArea();
        boutton_Envoyer = new javax.swing.JButton();
        tf_Email = new javax.swing.JTextField();
        boutton_Annuler = new javax.swing.JButton();
        rb_Traite = new javax.swing.JRadioButton();
        rb_NonTraite = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("To : ");

        ta_Message.setColumns(20);
        ta_Message.setRows(5);
        jScrollPane1.setViewportView(ta_Message);

        boutton_Envoyer.setText("Envoyer");
        boutton_Envoyer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_EnvoyerActionPerformed(evt);
            }
        });

        tf_Email.setToolTipText("");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tf_Email, org.jdesktop.beansbinding.ELProperty.create("${editable==false}"), tf_Email, org.jdesktop.beansbinding.BeanProperty.create("editable"));
        bindingGroup.addBinding(binding);

        tf_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_EmailActionPerformed(evt);
            }
        });

        boutton_Annuler.setText("Annuler");
        boutton_Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutton_AnnulerActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_Traite);
        rb_Traite.setText("Traitée");
        rb_Traite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_TraiteMouseClicked(evt);
            }
        });

        buttonGroup1.add(rb_NonTraite);
        rb_NonTraite.setText("Non traitée");
        rb_NonTraite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rb_NonTraiteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(boutton_Envoyer)
                        .addGap(54, 54, 54)
                        .addComponent(boutton_Annuler))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(rb_Traite)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rb_NonTraite)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_Traite)
                    .addComponent(rb_NonTraite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boutton_Envoyer)
                    .addComponent(boutton_Annuler))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boutton_AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_AnnulerActionPerformed
        new GestionReclamations().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_boutton_AnnulerActionPerformed

    private void boutton_EnvoyerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutton_EnvoyerActionPerformed
        String destinataire = tf_Email.getText();
        String msg = ta_Message.getText();
        if (mailController.repondreReclamation(destinataire, msg) == true) {
            reclamationDAO.modifierReclamation(idReclamation);
            JOptionPane.showMessageDialog(this, "Votre message a été transmis vers l'adresse: " + destinataire);
        } else {
            JOptionPane.showMessageDialog(this, "Votre message n'a pas été transmis vers l'adresse: " + destinataire);
        }
    }//GEN-LAST:event_boutton_EnvoyerActionPerformed

    private void rb_TraiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_TraiteMouseClicked
        ta_Message.setText("Bonjour,\n\nS'il vous plaît ne pas répondre à ce message. Les réponses à ce message sont acheminées vers une boîte aux lettres sans surveillance. "
                + "\n\nVotre réclamation a été traitée avec succés. \n\nSi vous avez besoins de plus d'infomations, veuillez nous contacter sur http://www.covoiturage-tn.com/contactus.");
    }//GEN-LAST:event_rb_TraiteMouseClicked

    private void rb_NonTraiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rb_NonTraiteMouseClicked
        ta_Message.setText("Bonjour,\n\nS'il vous plaît ne pas répondre à ce message. Les réponses à ce message sont acheminées vers une boîte aux lettres sans surveillance. "
                + "\n\nVotre réclamation n'a pas été traitée. \n\nSi vous avez besoins de plus d'infomations, veuillez nous contacter sur http://www.covoiturage-tn.com/contactus.");
    }//GEN-LAST:event_rb_NonTraiteMouseClicked

    private void tf_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_EmailActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RepondreReclamation.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RepondreReclamation().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boutton_Annuler;
    private javax.swing.JButton boutton_Envoyer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_NonTraite;
    private javax.swing.JRadioButton rb_Traite;
    private javax.swing.JTextArea ta_Message;
    private javax.swing.JTextField tf_Email;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}