/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Juego.Barco;
import JuegoGUI.BarcoGUI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alex
 */
public class HiloBarco extends Thread {

    private Barco barco;
    private BarcoGUI barcoGUI;
    private int segundos = 1;
    private int pecesRecolectados = 1;
    private int contEdad = 0;

    public HiloBarco(Barco barco, BarcoGUI barcoGUI) {
        this.barco = barco;
        this.barcoGUI = barcoGUI;
    }

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
