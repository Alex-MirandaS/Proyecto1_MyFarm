/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Juego.Jugador;
import JuegoGUI.JuegoGUI;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class HiloJugador implements Runnable {
//atributos

    private Jugador jug;
    private JuegoGUI juegoGUI;
    private int segundos = 2;
    private int vidaRestadaSeg = 1;
//constructor

    public HiloJugador(Jugador jug, JuegoGUI juegoGUI) {
        this.jug = jug;
        this.juegoGUI = juegoGUI;
    }
    //este metodo es el encargado de restar la vida del jugador, cuando su vida llega a 0, este termina la partida
    private void restarVida() throws InterruptedException {
        do {
            sleep(segundos * 1000);
            jug.agregarTiempoVida(segundos*1000);
            jug.restarVida(vidaRestadaSeg);
            juegoGUI.getVida().setText(jug.getVida() + "%");
            juegoGUI.getOro().setText("" + jug.getOro());
        } while (jug.getVida() > 0);
        juegoGUI.setEnabled(false);
        JOptionPane.showMessageDialog(null, "EL JUGADOR HA MUERTO");
        sleep(5 * 1000);
        System.exit(0);
    }

    @Override
    public void run() {
        try {
            restarVida();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
