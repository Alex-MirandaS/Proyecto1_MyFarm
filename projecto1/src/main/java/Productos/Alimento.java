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
public class Alimento extends Producto{
    
    private int vidaAgregada;

    public Alimento(String nombre, int precio, int vidaAgregada) {
        super(nombre, precio);
        this.vidaAgregada = vidaAgregada;
    }

    public int getVidaAgregada() {
        return vidaAgregada;
    }



}
