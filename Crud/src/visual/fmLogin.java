/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.sql.*;
import DAL.ConectaBd;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo lazzari
 */
public class fmLogin extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form fmLogin
     *
     * @throws java.lang.ClassNotFoundException
     */
    public fmLogin() throws ClassNotFoundException {
        initComponents();
        con = ConectaBd.conectabd();
    }//fecha fmlogin()

    public void Logar() {
        String sql = "SELECT * FROM login WHERE usuario = ? AND senha = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, jtfUser.getText());
            pst.setString(2, jpfSenha.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
               fmPrincipal frm;
                frm = new fmPrincipal();
                frm.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "usuario e senha incorretos");
            }//fecha if
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error);
        }
    }//fecha logar

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        user = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        jtfUser = new javax.swing.JTextField();
        jbtEntrar = new javax.swing.JButton();
        jpfSenha = new javax.swing.JPasswordField();
        login = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login de usuarios");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        user.setText("Usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 34, 0, 0);
        getContentPane().add(user, gridBagConstraints);

        password.setText("Senha:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 40, 0, 0);
        getContentPane().add(password, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 254;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 4, 0, 66);
        getContentPane().add(jtfUser, gridBagConstraints);

        jbtEntrar.setText("Entrar");
        jbtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEntrarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(40, 82, 74, 0);
        getContentPane().add(jbtEntrar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 254;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 4, 0, 66);
        getContentPane().add(jpfSenha, gridBagConstraints);

        login.setText("Login");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 105, 0, 0);
        getContentPane().add(login, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEntrarActionPerformed
        Logar();
    }//GEN-LAST:event_jbtEntrarActionPerformed

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
            java.util.logging.Logger.getLogger(fmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new fmLogin().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(fmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }//fecha main

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtEntrar;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JTextField jtfUser;
    private javax.swing.JLabel login;
    private javax.swing.JLabel password;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
