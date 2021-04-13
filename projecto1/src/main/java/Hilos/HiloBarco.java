/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Juego.Barco;
import JuegoGUI.BarcoGUI;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class HiloBarco implements Runnable {
//atributos
    private Barco barco;
    private BarcoGUI barcoGUI;
    private int segundos = 2;
    private int pecesRecolectados = 1;
//constructor
    public HiloBarco(Barco barco, BarcoGUI barcoGUI) {
        this.barco = barco;
        this.barcoGUI = barcoGUI;
    }
//es el encargado de agregar los peces, para luego recolectarlos, todo esto durante un tiempo especifico
    //cuando esto llega al final, el barco ya no puede recolectar mas peces, y se debe eliminar
    private void agregarPeces() throws InterruptedException {
        do {
            sleep(segundos * 1000);
            barco.agregarPecesRecolectados(pecesRecolectados);
            barcoGUI.getPecesRecolectados().setText("Peces Recolectados: " + barco.getPecesRecolectados());

        } while (barco.getPecesRecolectados() < barco.getPeces());
        barco.setLleno(true);
        barcoGUI.getPecesRecolectados().setText("BARCO LLENO");
    }

    @Override
    public void run() {
        try {
            agregarPeces();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloBarco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
