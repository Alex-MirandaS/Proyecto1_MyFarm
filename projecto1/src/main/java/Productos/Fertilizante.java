/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

/**
 *
 * @author alex
 */
public class Fertilizante extends Producto {

    private int cantidad;

    public Fertilizante(String nombre, int precio, int cantidad) {
        super(nombre, precio);
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

}
