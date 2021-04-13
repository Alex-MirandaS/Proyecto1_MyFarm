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
//atributos
    private Jugador jug;
    private Bodega bodega;
    private MercadoGUI figuraMercado;
//constructor
    public Mercado(Jugador jug, Bodega bodega) {
        this.jug = jug;
        this.bodega = bodega;
        this.figuraMercado = new MercadoGUI(this);
        llenarListas();
    }
//muestra la ventana correspondiente al mercado
    public void iniciar() {
        figuraMercado.setVisible(true);
        dineroJugador();
    }
//es el encargado de llenar las dos listas en donde se despliegan las opciones para comprar
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
//retorna el indice de un producto, para obtener asi el precio del mismo
    public int buscarIndice(String objetoSeleccionado) {
        for (int i = 0; i < bodega.getContenedor().getSize(); i++) {
            if (objetoSeleccionado.equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }
//si las condiciones son validas, se realiza una venta, restando de las existencias del jugador, cierto producto, a cambio de una cantidad de oro agregada
    public void realizarVenta(int indiceProducto, int cantidad) {
        if (cantidad < 0 || cantidad > bodega.getContenedor().get(indiceProducto).getExistencia()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        } else {
            bodega.getContenedor().get(indiceProducto).restarExistencia(cantidad);
            jug.agregarOro(bodega.getContenedor().get(cantidad*indiceProducto).getProducto().getPrecio());
            jug.agregarOroGeneradoGranja(cantidad*bodega.getContenedor().get(indiceProducto).getProducto().getPrecio());
        }
        dineroJugador();
    }
//si las condiciones son validas, se realiza una venta, añadiendo a las existencias del jugador, cierto producto, a cambio de una cantidad de oro restada
    public void realizarCompra(int indiceProducto, int cantidad) {
        if (cantidad < 0 || cantidad * bodega.getContenedor().get(indiceProducto).getProducto().getPrecio() > jug.getOro()) {
            JOptionPane.showMessageDialog(null, "Cantidad invalida");
        } else {
            bodega.getContenedor().get(indiceProducto).agregartExistencia(cantidad);
            jug.restarOro(bodega.getContenedor().get(indiceProducto).getProducto().getPrecio()*cantidad);
        }
        dineroJugador();
    }
//imprime el oro del jugador
    private void dineroJugador() {
        figuraMercado.getDineroJugador().setText("Oro disponible: " + jug.getOro());
    }

    public Bodega getBodega() {
        return bodega;
    }

}
