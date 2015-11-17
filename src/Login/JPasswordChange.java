/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Magnus
 */
public class JPasswordChange extends javax.swing.JFrame {

    private String gammelPass;
    private String newPass1;
    private String newPass2;
    private Bonde innloggetBonde;

    /**
     * Creates new form JPasswordChange
     */
    public JPasswordChange(Bonde innloggetBonde) {
        this.newPass2 = "";
        this.gammelPass = "";
        this.newPass1 = "";
        initComponents();
        this.innloggetBonde = innloggetBonde;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField2 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        oldPassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        newPassword1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        newPassword2 = new javax.swing.JPasswordField();
        changePassword = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        jPasswordField2.setText("jPasswordField2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Endre passord");

        jLabel1.setText("Gammelt passord");

        oldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPasswordActionPerformed(evt);
            }
        });

        jLabel2.setText("Nytt passord ");

        newPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassword1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Gjenta nytt passord");

        changePassword.setText("Endre passord");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });

        cancel.setText("Avbryt");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(changePassword)
                        .addGap(18, 18, 18)
                        .addComponent(cancel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(oldPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addComponent(newPassword1)
                        .addComponent(newPassword2)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePassword)
                    .addComponent(cancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void oldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPasswordActionPerformed

    private void newPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassword1ActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        // TODO add your handling code here:
        this.newPass2 = newPassword2.getText();
        this.gammelPass = oldPassword.getText();
        this.newPass1 = newPassword1.getText();
        try {
            if (this.innloggetBonde.makeSHA1Hash(gammelPass).equals(innloggetBonde.getPassword()) && newPass1.equals(newPass2) && !gammelPass.equals(newPass1)) {
                innloggetBonde.setPassword(innloggetBonde.makeSHA1Hash(newPass2));
                MySQLmetoder.updateFarmer(innloggetBonde);
                JOptionPane.showMessageDialog(null, "Passord oppdatert!");
                this.dispose();
            } else if (gammelPass.equals(newPass1)) {
                JOptionPane.showMessageDialog(null, "Hvorfor vil du endre til det samme passordet som du hadde?\nDette glemmer du jo bare!");
            } else {
                JOptionPane.showMessageDialog(null, "DU HAR SKREVET INN FEIL PASSORD!");
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(JPasswordChange.class.getName()).log(Level.SEVERE, null, ex);
        }



    }//GEN-LAST:event_changePasswordActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JPasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JPasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JPasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JPasswordChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JButton changePassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField newPassword1;
    private javax.swing.JPasswordField newPassword2;
    private javax.swing.JPasswordField oldPassword;
    // End of variables declaration//GEN-END:variables
}
