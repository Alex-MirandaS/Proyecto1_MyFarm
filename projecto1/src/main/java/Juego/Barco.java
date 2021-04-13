/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Casillas.Agua;
import Controladores.ControladorConstantes;
import JuegoGUI.BarcoGUI;

/**
 *
 * @author alex
 */
public class Barco {
//atributos
    private int peces = (int) (Math.random() * 50 + 1), pecesRecolectados;
    private static int cBarcos;
    private String nombre;
    private BarcoGUI figuraBarco;
    private boolean lleno;
//constructor
    public Barco(Agua agua) {
        nombre = "Barco" + cBarcos;
        figuraBarco = new BarcoGUI(agua);
        cBarcos++;
    }

    public BarcoGUI getFiguraBarco() {
        return figuraBarco;
    }
//muestra la figura del barco y sus opciones
    public void mostrarBarco() {
        figuraBarco.setVisible(true);
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return ControladorConstantes.PRECIO_BARCO * cBarcos;
    }

    public int getPecesRecolectados() {
        return pecesRecolectados;
    }
//va agregando mas peces a los peces recolectados en tiempo real
    public void agregarPecesRecolectados(int pecesRecolectados) {
        this.pecesRecolectados += pecesRecolectados;
    }

    public boolean isLleno() {
        return lleno;
    }

    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }

    public int getPeces() {
        return peces;
    }

    public void setPecesRecolectados(int pecesRecolectados) {
        this.pecesRecolectados = pecesRecolectados;
    }

}
