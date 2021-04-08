/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Juego;

import Controladores.ControladorConstantes;

/**
 * 
 * @author alex
 */
public class Barco {
private int peces  = (int) (Math.random() * 50 + 1);
private static int cBarcos;
private String nombre = "Barco"+cBarcos;

    public Barco() {
        cBarcos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return ControladorConstantes.PRECIO_BARCO*cBarcos;
    }

    public int getPeces() {
        return peces;
    }


}
