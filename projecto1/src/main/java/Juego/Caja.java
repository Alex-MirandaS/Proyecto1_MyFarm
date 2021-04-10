/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Plantas.Planta;
import Productos.Producto;

/**
 *
 * @author alex
 */
public class Caja {

    private Producto producto;
    private int existencia;

    public Caja(Producto producto) {
        this.producto = producto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public void agregartExistencia(int existencia) {
        this.existencia += existencia;
    }

    public void restarExistencia(int existencia) {
        this.existencia -= existencia;
    }

    public Producto getProducto() {
        return producto;
    }

}
