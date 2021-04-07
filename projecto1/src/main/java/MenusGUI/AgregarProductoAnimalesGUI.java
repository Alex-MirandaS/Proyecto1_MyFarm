/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenusGUI;

import Controladores.ControladorAnimales;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

/**
 *
 * @author alex
 */
public class AgregarProductoAnimalesGUI extends javax.swing.JFrame {

    private ControladorAnimales controlador;

    public AgregarProductoAnimalesGUI(ControladorAnimales controlador) {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.controlador = controlador;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelArriba = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tituloDestace = new javax.swing.JLabel();
        tituloSinDestace = new javax.swing.JLabel();
        PanelAbajo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        productosDisponibles1 = new javax.swing.JComboBox<>();
        agregarProductosConDestace = new javax.swing.JToggleButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        productosDisponibles2 = new javax.swing.JComboBox<>();
        agregarProductosSinDestace = new javax.swing.JToggleButton();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jToggleButton4 = new javax.swing.JToggleButton();
        PanelCentro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoPporDestace = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaTextoPsinDestace = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelArriba.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("   ");
        PanelArriba.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(1, 2));

        tituloDestace.setText("Productos Generados por Destace");
        jPanel1.add(tituloDestace);

        tituloSinDestace.setText("Productos Generados sin Destace");
        jPanel1.add(tituloSinDestace);

        PanelArriba.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelArriba, java.awt.BorderLayout.PAGE_START);

        PanelAbajo.setLayout(new java.awt.GridLayout(1, 2));

        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("   ");
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jLabel3.setText("   ");
        jPanel2.add(jLabel3, java.awt.BorderLayout.LINE_END);

        jLabel4.setText("   ");
        jPanel2.add(jLabel4, java.awt.BorderLayout.LINE_START);

        jPanel4.setLayout(new java.awt.GridLayout(4, 4));
        jPanel4.add(jLabel6);
        jPanel4.add(jLabel5);

        jPanel4.add(productosDisponibles1);

        agregarProductosConDestace.setText("+");
        agregarProductosConDestace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductosConDestaceActionPerformed(evt);
            }
        });
        jPanel4.add(agregarProductosConDestace);
        jPanel4.add(jLabel9);
        jPanel4.add(jLabel10);
        jPanel4.add(jLabel11);
        jPanel4.add(jLabel12);
        jPanel4.add(jLabel13);
        jPanel4.add(jLabel14);
        jPanel4.add(jLabel16);
        jPanel4.add(jLabel8);
        jPanel4.add(jLabel15);
        jPanel4.add(jLabel17);
        jPanel4.add(jLabel18);
        jPanel4.add(jLabel19);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        PanelAbajo.add(jPanel2);

        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel20.setText("   ");
        jPanel5.add(jLabel20, java.awt.BorderLayout.PAGE_START);

        jLabel21.setText("   ");
        jPanel5.add(jLabel21, java.awt.BorderLayout.LINE_END);

        jLabel22.setText("   ");
        jPanel5.add(jLabel22, java.awt.BorderLayout.LINE_START);

        jPanel6.setLayout(new java.awt.GridLayout(4, 4));
        jPanel6.add(jLabel23);
        jPanel6.add(jLabel24);

        jPanel6.add(productosDisponibles2);

        agregarProductosSinDestace.setText("+");
        agregarProductosSinDestace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProductosSinDestaceActionPerformed(evt);
            }
        });
        jPanel6.add(agregarProductosSinDestace);
        jPanel6.add(jLabel26);
        jPanel6.add(jLabel27);
        jPanel6.add(jLabel28);
        jPanel6.add(jLabel29);
        jPanel6.add(jLabel30);
        jPanel6.add(jLabel31);
        jPanel6.add(jLabel32);
        jPanel6.add(jLabel33);
        jPanel6.add(jLabel34);
        jPanel6.add(jLabel35);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel36.setText("  ");
        jPanel7.add(jLabel36, java.awt.BorderLayout.PAGE_END);

        jToggleButton3.setText("Aceptar");
        jPanel7.add(jToggleButton3, java.awt.BorderLayout.PAGE_START);

        jPanel6.add(jPanel7);

        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel37.setText("  ");
        jPanel9.add(jLabel37, java.awt.BorderLayout.PAGE_END);

        jToggleButton4.setText("Salir");
        jPanel9.add(jToggleButton4, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel6.add(jPanel8);

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        PanelAbajo.add(jPanel3);

        getContentPane().add(PanelAbajo, java.awt.BorderLayout.PAGE_END);

        PanelCentro.setLayout(new java.awt.GridLayout(1, 2));

        areaTextoPporDestace.setColumns(20);
        areaTextoPporDestace.setRows(5);
        jScrollPane1.setViewportView(areaTextoPporDestace);

        PanelCentro.add(jScrollPane1);

        areaTextoPsinDestace.setColumns(20);
        areaTextoPsinDestace.setRows(5);
        jScrollPane2.setViewportView(areaTextoPsinDestace);

        PanelCentro.add(jScrollPane2);

        getContentPane().add(PanelCentro, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarProductosConDestaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductosConDestaceActionPerformed
        controlador.agregarProductos(areaTextoPporDestace);
    }//GEN-LAST:event_agregarProductosConDestaceActionPerformed

    private void agregarProductosSinDestaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProductosSinDestaceActionPerformed
        controlador.agregarProductos(areaTextoPsinDestace);
    }//GEN-LAST:event_agregarProductosSinDestaceActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarProductoAnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoAnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoAnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProductoAnimalesGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new AgregarProductoAnimalesGUI().setVisible(true);
            }
        });
    }

    public JToggleButton getAgregarProductosConDestace() {
        return agregarProductosConDestace;
    }

    public JToggleButton getAgregarProductosSinDestace() {
        return agregarProductosSinDestace;
    }

    public JTextArea getAreaTextoPporDestace() {
        return areaTextoPporDestace;
    }

    public JTextArea getAreaTextoPsinDestace() {
        return areaTextoPsinDestace;
    }

    public JLabel getTituloDestace() {
        return tituloDestace;
    }

    public JLabel getTituloSinDestace() {
        return tituloSinDestace;
    }

    public JComboBox<String> getProductosDisponibles1() {
        return productosDisponibles1;
    }

    public JComboBox<String> getProductosDisponibles2() {
        return productosDisponibles2;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAbajo;
    private javax.swing.JPanel PanelArriba;
    private javax.swing.JPanel PanelCentro;
    private javax.swing.JToggleButton agregarProductosConDestace;
    private javax.swing.JToggleButton agregarProductosSinDestace;
    private javax.swing.JTextArea areaTextoPporDestace;
    private javax.swing.JTextArea areaTextoPsinDestace;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JComboBox<String> productosDisponibles1;
    private javax.swing.JComboBox<String> productosDisponibles2;
    private javax.swing.JLabel tituloDestace;
    private javax.swing.JLabel tituloSinDestace;
    // End of variables declaration//GEN-END:variables
}
