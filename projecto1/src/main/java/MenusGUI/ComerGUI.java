/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenusGUI;

import Juego.Juego;
import javax.swing.JComboBox;

/**
 *
 * @author alex
 */
public class ComerGUI extends javax.swing.JFrame {

    private Juego juego;

    public ComerGUI(Juego juego) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.juego = juego;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cComida = new javax.swing.JTextField();
        comer = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        existencias = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        alimentos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("  ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_END);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));
        jPanel2.add(cComida);

        comer.setText("¡Comer!");
        comer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comerActionPerformed(evt);
            }
        });
        jPanel2.add(comer);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jLabel2.setText("Opciones                        Cantidad a consumir");
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        existencias.setText(" ");
        getContentPane().add(existencias, java.awt.BorderLayout.PAGE_END);

        jLabel4.setText("  ");
        getContentPane().add(jLabel4, java.awt.BorderLayout.LINE_START);

        alimentos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                alimentosItemStateChanged(evt);
            }
        });
        getContentPane().add(alimentos, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alimentosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_alimentosItemStateChanged
        existencias.setText("Existencias: " + juego.getBodega().getContenedor().get(juego.obtenerIndiceProducto((String) alimentos.getSelectedItem())).getExistencia());
    }//GEN-LAST:event_alimentosItemStateChanged

    private void comerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comerActionPerformed
        juego.comer(juego.obtenerIndiceProducto((String) alimentos.getSelectedItem()), Integer.parseInt((String) cComida.getText()));
    }//GEN-LAST:event_comerActionPerformed

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
            java.util.logging.Logger.getLogger(ComerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ComerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ComerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ComerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ElegirTipoPlanta().setVisible(true);
            }
        });
    }

    public JComboBox<String> getAlimentos() {
        return alimentos;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alimentos;
    private javax.swing.JTextField cComida;
    private javax.swing.JButton comer;
    private javax.swing.JLabel existencias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
