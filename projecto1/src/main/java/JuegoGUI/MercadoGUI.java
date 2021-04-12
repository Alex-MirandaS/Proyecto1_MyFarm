/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoGUI;

import Juego.Mercado;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class MercadoGUI extends javax.swing.JFrame {

    private Mercado mercado;

    public MercadoGUI(Mercado mercado) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.mercado = mercado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dineroJugador = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        listaProductosVenta = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cExistencias = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        oroObtenido = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cExistenciaVenta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        listaProductosCompra = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cComprar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        aceptar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dineroJugador.setText("  ");
        getContentPane().add(dineroJugador, java.awt.BorderLayout.PAGE_END);

        jLabel3.setText("   ");
        getContentPane().add(jLabel3, java.awt.BorderLayout.LINE_START);

        jLabel4.setText("   ");
        getContentPane().add(jLabel4, java.awt.BorderLayout.LINE_END);

        jLabel1.setText("  ");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("Venta");
        jPanel2.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout(5, 3));

        jLabel7.setText("Producto:");
        jPanel4.add(jLabel7);

        listaProductosVenta.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaProductosVentaItemStateChanged(evt);
            }
        });
        jPanel4.add(listaProductosVenta);

        jLabel8.setText("Existencias:");
        jPanel4.add(jLabel8);
        jPanel4.add(cExistencias);

        jLabel9.setText("Oro:");
        jPanel4.add(jLabel9);
        jPanel4.add(oroObtenido);

        jLabel12.setText("Cantidad:");
        jPanel4.add(jLabel12);
        jPanel4.add(cExistenciaVenta);
        jPanel4.add(jLabel10);

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        jPanel4.add(aceptar);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel6.setText("Compra");
        jPanel3.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.GridLayout(4, 3));

        jLabel11.setText("Producto:");
        jPanel5.add(jLabel11);

        listaProductosCompra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                listaProductosCompraItemStateChanged(evt);
            }
        });
        jPanel5.add(listaProductosCompra);

        jLabel13.setText("Precio:");
        jPanel5.add(jLabel13);
        jPanel5.add(precio);

        jLabel15.setText("Cantidad:");
        jPanel5.add(jLabel15);
        jPanel5.add(cComprar);
        jPanel5.add(jLabel14);

        aceptar1.setText("Aceptar");
        aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar1ActionPerformed(evt);
            }
        });
        jPanel5.add(aceptar1);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        mercado.realizarVenta(mercado.buscarIndice((String) listaProductosVenta.getSelectedItem()), Integer.parseInt(cExistenciaVenta.getText()));
    }//GEN-LAST:event_aceptarActionPerformed

    private void aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar1ActionPerformed
        mercado.realizarCompra(mercado.buscarIndice((String) listaProductosCompra.getSelectedItem()), Integer.parseInt(cComprar.getText()));
    }//GEN-LAST:event_aceptar1ActionPerformed

    private void listaProductosVentaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaProductosVentaItemStateChanged
        cExistencias.setText("" + mercado.getBodega().getContenedor().get(mercado.buscarIndice((String) listaProductosVenta.getSelectedItem())).getExistencia());
        oroObtenido.setText("" + mercado.getBodega().getContenedor().get(mercado.buscarIndice((String) listaProductosVenta.getSelectedItem())).getProducto().getPrecio());
    }//GEN-LAST:event_listaProductosVentaItemStateChanged

    private void listaProductosCompraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_listaProductosCompraItemStateChanged
        precio.setText("" + mercado.getBodega().getContenedor().get(mercado.buscarIndice((String) listaProductosCompra.getSelectedItem())).getProducto().getPrecio());
    }//GEN-LAST:event_listaProductosCompraItemStateChanged

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
            java.util.logging.Logger.getLogger(MercadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MercadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MercadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MercadoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new MercadoGUI().setVisible(true);
            }
        });
    }

    public JLabel getcExistencias() {
        return cExistencias;
    }

    public JComboBox<String> getListaProductosCompra() {
        return listaProductosCompra;
    }

    public JComboBox<String> getListaProductosVenta() {
        return listaProductosVenta;
    }

    public JLabel getOroObtenido() {
        return oroObtenido;
    }

    public JLabel getPrecio() {
        return precio;
    }

    public JLabel getDineroJugador() {
        return dineroJugador;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JButton aceptar1;
    private javax.swing.JTextField cComprar;
    private javax.swing.JTextField cExistenciaVenta;
    private javax.swing.JLabel cExistencias;
    private javax.swing.JLabel dineroJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> listaProductosCompra;
    private javax.swing.JComboBox<String> listaProductosVenta;
    private javax.swing.JLabel oroObtenido;
    private javax.swing.JLabel precio;
    // End of variables declaration//GEN-END:variables
}
