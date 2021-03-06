/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.Profesor;
import Data.Usuario;

import Logic.Crud;
import static Logic.Crud.guardarBloques;
import static Logic.Crud.guardarProfesores;
import static Logic.Crud.guardarUsuarios;
import static Logic.Login.listaUsuarios;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class Login extends javax.swing.JFrame {

    public static String correo;
    /**
     * Creates new form Login
     */
    public Login() {
        
        initComponents();

        this.setLocationRelativeTo(null);
        botonesTransparentes();

        
    }

/**
     * Creates new form Login
     */
        public void botonesTransparentes() {

        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);

        btnEntrar.setOpaque(false);
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setBorderPainted(false);

        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
        
       

    }

    private boolean camposVacios() {
        if (txtContraseña.getText().isEmpty() || txtUsuario.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btnEntrar = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 50, 50));

        btnEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 110, 50));

        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 270, 30));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 200, 30));
        getContentPane().add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 180, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI Recursos/Login.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Guardando Usuarios...");
        guardarUsuarios();
        System.out.println("Los Usuarios se han guardado con exito ");
        System.out.println("Guardando Profesores...");
        guardarProfesores();
        System.out.println("Los Profesores se han guardado con exito");
        System.out.println("Guardando Blockchain...");
        guardarBloques();
        System.out.println("BlockchainGuardado Exitosamente");
       
        System.exit(0);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        new Registro().setVisible(true);
        dispose();
    }//GEN-LAST:event_btn3ActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:

        correo = txtUsuario.getText();
        String contraseña = txtContraseña.getText();
        if (camposVacios()) {
            JOptionPane.showMessageDialog(rootPane, "Campos vacios, verifique", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (Logic.Login.iniciarSesion(correo, contraseña)) {
                new MenuPrincipal().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Por favor verifique sus datos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


    }//GEN-LAST:event_btnEntrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("Cargando Archivo de Usuarios,Profesores y bloques...");
       try {
            
            
            ObjectInputStream inputUsers = new ObjectInputStream(new FileInputStream("Usuarios.txt"));
            listaUsuarios = (TreeMap<String,Usuario>) inputUsers.readObject();
            inputUsers.close();
            
            ObjectInputStream inputProfesores = new ObjectInputStream(new FileInputStream("Profesores.txt"));
            Logic.Crud.listaProfesores = (ArrayList<Profesor>) inputProfesores.readObject();
            inputProfesores.close();
           
         
            for (Usuario user : listaUsuarios.values()) {
                System.out.println(user.toString());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        

        /////////////////////////!!!!!
        ////////////////////////////////////////////////////////////
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */ 
        
        /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        } catch (Exception e) {
            e.printStackTrace();
        } */
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            new Login().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
