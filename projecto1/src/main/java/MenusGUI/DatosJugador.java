/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenusGUI;

import Juego.Juego;

/**
 *
 * @author alex
 */
public class DatosJugador extends javax.swing.JFrame {

    private Juego juego;

    public DatosJugador(Juego juego) {
        initComponents();
        this.setLocationRelativeTo(null);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        añadirPlanta = new javax.swing.JButton();
        añadirAnimal = new javax.swing.JButton();
        añadirProducto = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nick = new javax.swing.JTextField();
        guardarDatos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("    ");
        jPanel2.add(jLabel6, java.awt.BorderLayout.LINE_END);

        jLabel7.setText("    ");
        jPanel2.add(jLabel7, java.awt.BorderLayout.LINE_START);

        jPanel7.setLayout(new java.awt.GridLayout(3, 3, 2, 0));
        jPanel7.add(jLabel8);
        jPanel7.add(jLabel9);
        jPanel7.add(jLabel10);

        añadirPlanta.setText("Crear Planta");
        añadirPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirPlantaActionPerformed(evt);
            }
        });
        jPanel7.add(añadirPlanta);

        añadirAnimal.setText("Crear Animal");
        añadirAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirAnimalActionPerformed(evt);
            }
        });
        jPanel7.add(añadirAnimal);

        añadirProducto.setText("Crear Producto");
        añadirProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirProductoActionPerformed(evt);
            }
        });
        jPanel7.add(añadirProducto);
        jPanel7.add(jLabel11);
        jPanel7.add(jLabel12);
        jPanel7.add(jLabel13);

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel3.setText("               ");
        getContentPane().add(jLabel3, java.awt.BorderLayout.LINE_END);

        jLabel4.setText("               ");
        getContentPane().add(jLabel4, java.awt.BorderLayout.LINE_START);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.GridLayout(3, 0, 0, 5));

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setText("Nombre:");
        jPanel5.add(jLabel1);
        jPanel5.add(nombre);

        jPanel4.add(jPanel5);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jLabel2.setText("NickName:");
        jPanel6.add(jLabel2);
        jPanel6.add(nick);

        jPanel4.add(jPanel6);

        guardarDatos.setText("EMPEZAR PARTIDA");
        guardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarDatosActionPerformed(evt);
            }
        });
        jPanel4.add(guardarDatos);

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel5.setText("   ");
        getContentPane().add(jLabel5, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void añadirPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirPlantaActionPerformed
        this.setEnabled(false);
        juego.getControlPlantas().iniciar();
        this.setEnabled(true);
    }//GEN-LAST:event_añadirPlantaActionPerformed

    private void añadirAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirAnimalActionPerformed
        this.setEnabled(false);
        juego.getControlAnimales().iniciar();
        this.setEnabled(true);
    }//GEN-LAST:event_añadirAnimalActionPerformed

    private void añadirProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirProductoActionPerformed
        this.setEnabled(false);
        juego.getControlProductos().iniciar();
        this.setEnabled(true);
    }//GEN-LAST:event_añadirProductoActionPerformed

    private void guardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarDatosActionPerformed
        juego.crearJugador(nombre.getText(), nick.getText());
        this.setVisible(false);
        juego.iniciarJuego();
    }//GEN-LAST:event_guardarDatosActionPerformed

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
            java.util.logging.Logger.getLogger(DatosJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatosJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatosJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatosJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new DatosJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirAnimal;
    private javax.swing.JButton añadirPlanta;
    private javax.swing.JButton añadirProducto;
    private javax.swing.JButton guardarDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField nick;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
