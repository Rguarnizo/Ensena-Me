/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Data.Profesor;
import static Logic.Crud.guardarBloques;
import static Logic.Crud.guardarProfesores;
import static Logic.Crud.guardarUsuarios;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.text.TableView;

/**
 *
 * @author Ruben Dario Guarnizo
 */
public class PedirClase extends javax.swing.JFrame {

    /**
     * Creates new form SerProfesor
     */
    public PedirClase() {
        initComponents();
        this.setLocationRelativeTo(null);
        botonesTransparentes();
        mostrarProfesores(cbxAreaDeEstudio1.getItemAt(0));
    }

    public void botonesTransparentes() {

        btnPedir.setOpaque(false);
        btnPedir.setContentAreaFilled(false);
        btnPedir.setBorderPainted(false);

        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);

        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);

        btn4.setOpaque(false);
        btn4.setContentAreaFilled(false);
        btn4.setBorderPainted(false);

        btn5.setOpaque(false);
        btn5.setContentAreaFilled(false);
        btn5.setBorderPainted(false);

        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);

        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);

    }

    private void mostrarProfesores(String areaDeEstudio) {
        DefaultListModel modelo = new DefaultListModel();
        for (Profesor profe : Logic.Crud.listaProfesores) {
            if ((!(profe.getUsuario().getCorreo().equals(Logic.Login.usuarioLogeado))) && (profe.getMateriaDictada().equals(areaDeEstudio))) {
                modelo.addElement(profe);
            }
        }
        lstProfesores.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPedir = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHorario = new javax.swing.JTable();
        cbxLugar = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProfesores = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();
        cbxAreaDeEstudio1 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPedir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedirActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedir, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 440, 240, 50));

        btn2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, 50));

        btn3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, 50));

        btn4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 200, 50));

        btn5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 200, 50));

        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 50, 50));

        tblHorario.setForeground(new java.awt.Color(49, 50, 51));
        tblHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "", "", "", "", ""},
                {null, "", "", "", "", ""},
                {null, "", "", "", "", ""},
                {null, "", "", "", "", ""},
                {null, "", "", "", "", ""},
                {null, "", "", "", "", ""}
            },
            new String [] {
                "Hora", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHorario.setColumnSelectionAllowed(true);
        tblHorario.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblHorario);
        tblHorario.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tblHorario.getColumnModel().getColumnCount() > 0) {
            tblHorario.getColumnModel().getColumn(0).setResizable(false);
            tblHorario.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblHorario.getColumnModel().getColumn(1).setResizable(false);
            tblHorario.getColumnModel().getColumn(2).setResizable(false);
            tblHorario.getColumnModel().getColumn(3).setResizable(false);
            tblHorario.getColumnModel().getColumn(4).setResizable(false);
            tblHorario.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 300, 130));

        cbxLugar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Hemeroteca Nacional Universitaria\t", "Biblioteca Central", "Edificio de Ciencia y Tecnologia", "Edificio Julio Garavito", "Torre Central de Informatica", " " }));
        getContentPane().add(cbxLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 190, 30));

        lstProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstProfesoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstProfesores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 200, 170));

        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 70, 60));

        cbxAreaDeEstudio1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ciencias exactas", "Ciencias naturales", "Ciencias humanas", "Ciencias medicas" }));
        cbxAreaDeEstudio1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAreaDeEstudio1ItemStateChanged(evt);
            }
        });
        getContentPane().add(cbxAreaDeEstudio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 164, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI Recursos/Pedir_Clase.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirActionPerformed
        int fila = tblHorario.getSelectedRow();
        int columna = tblHorario.getSelectedColumn();

        if (lstProfesores.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(rootPane, "Primero seleccione un profesor y un horario", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            if (tblHorario.getValueAt(fila, columna) == null) {
                JOptionPane.showMessageDialog(rootPane, "Horario invalido, por favor verifique", "Error horario", JOptionPane.ERROR_MESSAGE);
            } else {
                Logic.PedirClase.pedirClase(Integer.parseInt(tblHorario.getValueAt(fila, columna).toString()), cbxLugar.getSelectedItem().toString(), (Profesor) lstProfesores.getSelectedValue(), Logic.Login.listaUsuarios.get(Logic.Login.usuarioLogeado));
                JOptionPane.showMessageDialog(rootPane, "Clase creada con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                tblHorario.setValueAt(null, fila, columna);
                Logic.PedirClase.actualizarHorario((Profesor) lstProfesores.getSelectedValue(), tblHorario.getModel());
            }
        }
        
        


    }//GEN-LAST:event_btnPedirActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lstProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstProfesoresMouseClicked
        JList list = (JList) evt.getSource();
        if (evt.getClickCount() == 1) {
            Profesor profesor = new Profesor();
            profesor = (Profesor) lstProfesores.getSelectedValue();
            profesor.toString();
            profesor.transformarModeloTabla();
            tblHorario.setModel(profesor.getHorario());
        }
        
    }//GEN-LAST:event_lstProfesoresMouseClicked

    private void cbxAreaDeEstudio1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAreaDeEstudio1ItemStateChanged
        mostrarProfesores(cbxAreaDeEstudio1.getSelectedItem().toString());
    }//GEN-LAST:event_cbxAreaDeEstudio1ItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
         java.util.logging.Logger.getLogger(PedirClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
         java.util.logging.Logger.getLogger(PedirClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
         java.util.logging.Logger.getLogger(PedirClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
         java.util.logging.Logger.getLogger(PedirClase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         */
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PedirClase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btnPedir;
    private javax.swing.JComboBox<String> cbxAreaDeEstudio1;
    private javax.swing.JComboBox<String> cbxLugar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList lstProfesores;
    private javax.swing.JTable tblHorario;
    // End of variables declaration//GEN-END:variables
}
