/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JuegoGUI;

import Casillas.Agua;
import CasillasGUI.AguaGUI;
import Juego.Juego;
import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class JuegoGUI extends javax.swing.JFrame {

    Juego juego;

    public JuegoGUI(Juego juego) {
        initComponents();
        this.juego = juego;
        this.nombre.setText(juego.getJug().getNombre());
        this.nick.setText(juego.getJug().getNickname());
        this.vida.setText(""+juego.getJug().getVida());
        this.oro.setText(""+juego.getJug().getOro());
        this.cSemillas.setText(""+juego.getJug().getSemillas());
        juego.getGranja().LlenarTablero(this.PanelCentral);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        accederBodega = new javax.swing.JButton();
        accederMercado = new javax.swing.JButton();
        accederReportes = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nick = new javax.swing.JLabel();
        figuritaPersonaje = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        vida = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        oro = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cSemillas = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        precioAgregarCasillas = new javax.swing.JLabel();
        agregarCasilla = new javax.swing.JToggleButton();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        precioAgregarCasillas1 = new javax.swing.JLabel();
        agregarBarco = new javax.swing.JToggleButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        precioAgregarCasillas2 = new javax.swing.JLabel();
        añadirPlanta = new javax.swing.JToggleButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        precioAgregarCasillas3 = new javax.swing.JLabel();
        añadirParcela = new javax.swing.JToggleButton();
        opciones = new javax.swing.JButton();
        PanelCentral = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        accederBodega.setText("Bodega");
        accederBodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accederBodegaActionPerformed(evt);
            }
        });
        jPanel1.add(accederBodega);

        accederMercado.setText("Mercado");
        jPanel1.add(accederMercado);

        accederReportes.setText("Reportes");
        jPanel1.add(accederReportes);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("   ");
        jPanel4.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jLabel2.setText("  ");
        jPanel4.add(jLabel2, java.awt.BorderLayout.LINE_START);

        jLabel3.setText("  ");
        jPanel4.add(jLabel3, java.awt.BorderLayout.LINE_END);

        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jPanel9.setLayout(new java.awt.GridLayout(2, 2));

        jLabel4.setText("Nombre:");
        jPanel9.add(jLabel4);
        jPanel9.add(nombre);

        jLabel5.setText("Nickname:");
        jPanel9.add(jLabel5);
        jPanel9.add(nick);

        jPanel7.add(jPanel9);
        jPanel7.add(figuritaPersonaje);

        jPanel6.add(jPanel7);

        jPanel8.setLayout(new java.awt.GridLayout(3, 3));

        jLabel6.setText("Vida:");
        jPanel8.add(jLabel6);
        jPanel8.add(vida);

        jLabel7.setText("Oro:");
        jPanel8.add(jLabel7);
        jPanel8.add(oro);

        jLabel12.setText("Semillas:");
        jPanel8.add(jLabel12);
        jPanel8.add(cSemillas);

        jPanel6.add(jPanel8);

        jPanel4.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(5, 0, 0, 3));

        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("  ");
        jPanel11.add(jLabel8, java.awt.BorderLayout.LINE_END);
        jPanel11.add(precioAgregarCasillas, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel11, java.awt.BorderLayout.LINE_END);

        agregarCasilla.setText("Agregar Casilla");
        agregarCasilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCasillaActionPerformed(evt);
            }
        });
        jPanel10.add(agregarCasilla, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel10);

        jPanel12.setLayout(new java.awt.BorderLayout());

        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("  ");
        jPanel13.add(jLabel9, java.awt.BorderLayout.LINE_END);
        jPanel13.add(precioAgregarCasillas1, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel13, java.awt.BorderLayout.LINE_END);

        agregarBarco.setText("Agregar Barco");
        agregarBarco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarBarcoActionPerformed(evt);
            }
        });
        jPanel12.add(agregarBarco, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel12);

        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel15.setLayout(new java.awt.BorderLayout());

        jLabel10.setText("  ");
        jPanel15.add(jLabel10, java.awt.BorderLayout.LINE_END);
        jPanel15.add(precioAgregarCasillas2, java.awt.BorderLayout.CENTER);

        jPanel14.add(jPanel15, java.awt.BorderLayout.LINE_END);

        añadirPlanta.setText("Añadir Siembra");
        añadirPlanta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirPlantaActionPerformed(evt);
            }
        });
        jPanel14.add(añadirPlanta, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel14);

        jPanel16.setLayout(new java.awt.BorderLayout());

        jPanel17.setLayout(new java.awt.BorderLayout());

        jLabel11.setText("  ");
        jPanel17.add(jLabel11, java.awt.BorderLayout.LINE_END);
        jPanel17.add(precioAgregarCasillas3, java.awt.BorderLayout.CENTER);

        jPanel16.add(jPanel17, java.awt.BorderLayout.LINE_END);

        añadirParcela.setText("Añadir Parcela");
        añadirParcela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirParcelaActionPerformed(evt);
            }
        });
        jPanel16.add(añadirParcela, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel16);

        opciones.setText("Opciones");
        jPanel5.add(opciones);

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout PanelCentralLayout = new javax.swing.GroupLayout(PanelCentral);
        PanelCentral.setLayout(PanelCentralLayout);
        PanelCentralLayout.setHorizontalGroup(
            PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 217, Short.MAX_VALUE)
        );
        PanelCentralLayout.setVerticalGroup(
            PanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        getContentPane().add(PanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarCasillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCasillaActionPerformed
        juego.prepararDesbloqueo();

        if (añadirPlanta.isSelected()) {
            juego.prepararAñadirCultivo();
            añadirPlanta.setSelected(false);
        }
        if (añadirParcela.isSelected()) {
            juego.prepararAñadirParcela();
            añadirParcela.setSelected(false);
        }
//        if (cosechar.isSelected()) {
//            juego.prepararCosechar();
//            cosechar.setSelected(false);
//        }
    }//GEN-LAST:event_agregarCasillaActionPerformed

    private void añadirPlantaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirPlantaActionPerformed
        juego.prepararAñadirCultivo();
        if (agregarCasilla.isSelected()) {
            juego.prepararDesbloqueo();
            agregarCasilla.setSelected(false);
        }
        if (añadirParcela.isSelected()) {
            juego.prepararAñadirParcela();
            añadirParcela.setSelected(false);
        }
//        if (cosechar.isSelected()) {
//            juego.prepararCosechar();
//            cosechar.setSelected(false);
//        }
    }//GEN-LAST:event_añadirPlantaActionPerformed

    private void añadirParcelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirParcelaActionPerformed
        juego.prepararAñadirParcela();
        if (agregarCasilla.isSelected()) {
            juego.prepararDesbloqueo();
            agregarCasilla.setSelected(false);
        }
        if (añadirPlanta.isSelected()) {
            juego.prepararAñadirCultivo();
            añadirPlanta.setSelected(false);
        }
//        if (cosechar.isSelected()) {
//            juego.prepararCosechar();
//            cosechar.setSelected(false);
//        }
    }//GEN-LAST:event_añadirParcelaActionPerformed

    private void accederBodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accederBodegaActionPerformed
        juego.mientras();
    }//GEN-LAST:event_accederBodegaActionPerformed

    private void agregarBarcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarBarcoActionPerformed
        juego.prepararAñadirBarco();
    }//GEN-LAST:event_agregarBarcoActionPerformed

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
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JuegoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new JuegoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCentral;
    private javax.swing.JButton accederBodega;
    private javax.swing.JButton accederMercado;
    private javax.swing.JButton accederReportes;
    private javax.swing.JToggleButton agregarBarco;
    private javax.swing.JToggleButton agregarCasilla;
    private javax.swing.JToggleButton añadirParcela;
    private javax.swing.JToggleButton añadirPlanta;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel cSemillas;
    private javax.swing.JLabel figuritaPersonaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel nick;
    private javax.swing.JLabel nombre;
    private javax.swing.JButton opciones;
    private javax.swing.JLabel oro;
    private javax.swing.JLabel precioAgregarCasillas;
    private javax.swing.JLabel precioAgregarCasillas1;
    private javax.swing.JLabel precioAgregarCasillas2;
    private javax.swing.JLabel precioAgregarCasillas3;
    private javax.swing.JLabel vida;
    // End of variables declaration//GEN-END:variables
}
