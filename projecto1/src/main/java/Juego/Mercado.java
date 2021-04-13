/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import JuegoGUI.MercadoGUI;
import Productos.ComidaAnimales;
import Productos.Fertilizante;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Mercado {

    private Jugador jug;
    private Bodega bodega;
    private MercadoGUI figuraMercado;

    public Mercado(Jugador jug, Bodega bodega) {
        this.jug = jug;
        this.bodega = bodega;
        this.figuraMercado = new MercadoGUI(this);
        llenarListas();
    }

    public void iniciar() {
        figuraMercado.setVisible(true);
        dineroJugador();
    }

    private void llenarListas() {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (bodega.getContenedor().get(i).getProducto() instanceof ComidaAnimales
                    || bodega.getContenedor().get(i).getProducto() instanceof Fertilizante) {

            } else {
                figuraMercado.getListaProductosVenta().addItem(bodega.getContenedor().get(i).getProducto().getNombre());
            }
        }

        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (bodega.getContenedor().get(i).getProducto() instanceof ComidaAnimales
                    || bodega.getContenedor().get(i).getProducto() instanceof Fertilizante) {
                figuraMercado.getListaProductosCompra().addItem(bodega.getContenedor().get(i).getProducto().getNombre());
            }
        }

    }

    public int buscarIndice(String objetoSeleccionado) {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (objetoSeleccionado.equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }

    public void realizarVenta(int indiceProducto, int cantidad) {
        if (cantidad < 0 || cantidad > bodega.getContenedor().get(indiceProducto).getExistencia()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        } else {
            bodega.getContenedor().get(indiceProducto).restarExistencia(cantidad);
            jug.agregarOro(bodega.getContenedor().get(cantidad*indiceProducto).getProducto().getPrecio());
        }
        dineroJugador();
    }

    public void realizarCompra(int indiceProducto, int cantidad) {
        if (cantidad < 0 || cantidad * bodega.getContenedor().get(indiceProducto).getProducto().getPrecio() > jug.getOro()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        } else {
            bodega.getContenedor().get(indiceProducto).agregartExistencia(cantidad);
            jug.restarOro(bodega.getContenedor().get(indiceProducto).getProducto().getPrecio()*cantidad);
        }
        dineroJugador();
    }

    private void dineroJugador() {
        figuraMercado.getDineroJugador().setText("Oro disponible: " + jug.getOro());
    }

    public Bodega getBodega() {
        return bodega;
    }

}
