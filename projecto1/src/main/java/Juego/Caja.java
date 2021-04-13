/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Productos.Alimento;
import Productos.Producto;

/**
 *
 * @author alex
 */
public class Caja {
//atributos
    private Producto producto;
    private int existencia, alimentoGenerado=0;
//constructor
    //es la encargada de almacenar un solo tipo de producto, y añadirle sus existencias correspondientes
    public Caja(Producto producto) {
        this.producto = producto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
//agrega y resta las existencias del producto en especifico
    public void agregartExistencia(int existencia) {
        if (producto instanceof Alimento) {
            alimentoGenerado+=existencia;
        }
        this.existencia += existencia;
    }

    public int getAlimentoGenerado() {
        return alimentoGenerado;
    }

    public void restarExistencia(int existencia) {
        this.existencia -= existencia;
    }

    public Producto getProducto() {
        return producto;
    }

}
