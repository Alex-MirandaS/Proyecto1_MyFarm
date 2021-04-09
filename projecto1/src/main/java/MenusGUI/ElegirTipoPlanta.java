/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenusGUI;

import Casillas.Pasto;
import Controladores.ControladorPlantas;
import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class ElegirTipoPlanta extends javax.swing.JFrame {

    private Pasto pasto;
    private JLabel img;

    public ElegirTipoPlanta(JLabel img, Pasto pasto) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pasto = pasto;
        this.img = img;
        pasto.getPlantas().llenarListaOpciones(tipoPlantas);
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
        aceptar = new javax.swing.JButton();
        cSemillas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tipoPlantas = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("  ");
        jPanel1.add(jLabel1, java.awt.BorderLayout.LINE_END);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        jPanel1.add(aceptar, java.awt.BorderLayout.CENTER);
        jPanel1.add(cSemillas, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        jLabel2.setText(" ");
        getContentPane().add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jLabel3.setText(" ");
        getContentPane().add(jLabel3, java.awt.BorderLayout.PAGE_END);

        jLabel4.setText("  ");
        getContentPane().add(jLabel4, java.awt.BorderLayout.LINE_START);

        tipoPlantas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoPlantasItemStateChanged(evt);
            }
        });
        getContentPane().add(tipoPlantas, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        pasto.siembra(img, tipoPlantas.getSelectedIndex());
        this.setVisible(false);
    }//GEN-LAST:event_aceptarActionPerformed

    private void tipoPlantasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoPlantasItemStateChanged
        cSemillas.setText("Semillas: " + pasto.getPlantas().getPlantasJuego().get(tipoPlantas.getSelectedIndex()).getSemillas());
    }//GEN-LAST:event_tipoPlantasItemStateChanged

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
            java.util.logging.Logger.getLogger(ElegirTipoPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElegirTipoPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElegirTipoPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElegirTipoPlanta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new ElegirTipoPlanta().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JLabel cSemillas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> tipoPlantas;
    // End of variables declaration//GEN-END:variables
}
