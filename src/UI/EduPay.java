package UI;

import Data.Bloque;
import Data.Monedero;
import Data.Transaccion;
import Data.TransaccionEntrada;
import Data.TransaccionSaliente;
import static UI.Registro.correo;
import java.awt.ComponentOrientation;
import java.security.Security;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class EduPay extends javax.swing.JFrame {
    
    public static Monedero monederoA=new Monedero();
    public static Transaccion bloqueGenesis;
    public static int dificultad = 3;
    public static float transaccionMinima = 0.1f;
    public static ArrayList<Bloque> blockchain = new ArrayList<>();
    public static HashMap<String,TransaccionSaliente> UTXOs = new HashMap<>();
    
    public EduPay() {
        initComponents();
        this.setLocationRelativeTo(null);
        botonesTransparentes();
        listKey.
        //jLabel2.setText(Logic.Login.listaUsuarios.get(correo).monedero.llavePublica.toString());
    }
    public static Boolean cadenaEsValida() {
		Bloque bloqueActual; 
		Bloque bloqueAnterior;
		String hashObjetivo = new String(new char[dificultad]).replace('\0', '0');
		HashMap<String,TransaccionSaliente> UTXOsTemporal = new HashMap<>(); //lista temporal transacciones no gastadas
		UTXOsTemporal.put(bloqueGenesis.salidas.get(0).id, bloqueGenesis.salidas.get(0));
		for(int i=1; i < blockchain.size(); i++) {
			bloqueActual = blockchain.get(i);
			bloqueAnterior = blockchain.get(i-1);
			if(!bloqueActual.hash.equals(bloqueActual.calcularHash())){ //Comparar hash registrado y hash calculado
				JOptionPane.showMessageDialog(null, "Error, el hash no es igual", "Error" ,JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(!bloqueAnterior.hash.equals(bloqueActual.hashAnterior)){
				JOptionPane.showMessageDialog(null, "Error, el hash anterior no es igual", "Error" ,JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if(!bloqueActual.hash.substring( 0, dificultad).equals(hashObjetivo)) {
				JOptionPane.showMessageDialog(null, "Error, este bloque no puede ser minado", "Error" ,JOptionPane.ERROR_MESSAGE);
				return false;
			}
			TransaccionSaliente salidaTemporal;
			for(int t=0; t <bloqueActual.transacciones.size(); t++) {
				Transaccion transaccionActual = bloqueActual.transacciones.get(t);
				if(!transaccionActual.verificarFirma()) {
					JOptionPane.showMessageDialog(null, "Firma en Transaccion(" +t+ ") is invalida", "Error" ,JOptionPane.ERROR_MESSAGE);
					return false; 
				}
				if(transaccionActual.obtenerValorEntrada() != transaccionActual.obtenerValorSalida()) {
					JOptionPane.showMessageDialog(null, "Las entradas no son iguales para las salidas en la Transaccion(" +t+ ")"
					, "Error" ,JOptionPane.ERROR_MESSAGE);
					return false; 
				}
				for(TransaccionEntrada entrada: transaccionActual.entradas) {	
					salidaTemporal = UTXOsTemporal.get(entrada.idTransaccionSalida);
					if(salidaTemporal == null) {
						JOptionPane.showMessageDialog(null, "Hace falta referencia de entrada en transaccion("+t+")"
						, "Error" ,JOptionPane.ERROR_MESSAGE);
						return false;
					}
					if(entrada.UTXO.valor != salidaTemporal.valor){
						JOptionPane.showMessageDialog(null, "El valor de la transaccion("+t+") es invalido"
						, "Error" ,JOptionPane.ERROR_MESSAGE);
						return false;
					}
					UTXOsTemporal.remove(entrada.idTransaccionSalida);
				}
				for(TransaccionSaliente salida: transaccionActual.salidas){
					UTXOsTemporal.put(salida.id, salida);
				}
				if(transaccionActual.salidas.get(0).destinatario != transaccionActual.destinatario){
					JOptionPane.showMessageDialog(null, "Transaccion("+t+") destinatario incorrecto"
					, "Error" ,JOptionPane.ERROR_MESSAGE);
					return false;
				}
				if(transaccionActual.salidas.get(1).destinatario != transaccionActual.remitente){
					JOptionPane.showMessageDialog(null, "Transaccion(" + t + ") remitente incorrecto"
					, "Error" ,JOptionPane.ERROR_MESSAGE);
					return false;
				}}}
		ImageIcon icono=new ImageIcon(".//recourses/emojiFeliz.png");
		ImageIcon icono1=new ImageIcon(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		JOptionPane.showMessageDialog(null, "La cadena de bloques es valida", "Felicitaciones" ,JOptionPane.INFORMATION_MESSAGE, icono1);
		return true;
	}
	
	public static void añadirBloque(Bloque nuevoBloque){
		nuevoBloque.minarBloque(dificultad);
		blockchain.add(nuevoBloque);
	}
    
    public void botonesTransparentes(){
        
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);
        
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
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        cbUsuarios = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        listKey = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
<<<<<<< HEAD
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 430, 190, 50));

        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
=======
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 420, 190, 50));

        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
>>>>>>> 3a540e6f43626508045ac2fdc22dc257cdc41f1f
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 200, 50));
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 200, 50));

        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 200, 50));
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, 200, 50));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 40, 40));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 60, 50));
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 400, 30));

        cbUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        getContentPane().add(cbUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 400, 40));

        listKey.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listKey);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 400, 90));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UI Recursos/EduPay.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        new MenuPrincipal().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
           System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EduPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EduPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EduPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EduPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EduPay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JComboBox<String> cbUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listKey;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
