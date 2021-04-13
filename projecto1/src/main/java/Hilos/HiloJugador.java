/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Hilos;

import Juego.Jugador;
import JuegoGUI.JuegoGUI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author alex
 */
public class HiloJugador extends Thread{

    private Jugador jug;
    private JuegoGUI juegoGUI;
    private int segundos= 2;
    private int vidaRestadaSeg = 2;

    public HiloJugador(Jugador jug, JuegoGUI juegoGUI) {
        this.jug = jug;
        this.juegoGUI = juegoGUI;
    }
    
    private void restarVida() throws InterruptedException{
        do{
            sleep(segundos*1000);
            jug.restarVida(vidaRestadaSeg);
            juegoGUI.getVida().setText(jug.getVida()+"%");
            juegoGUI.getOro().setText(""+jug.getOro());
        }while (jug.getVida()>0);
        JOptionPane.showMessageDialog(null, "EL JUGADOR HA MUERTO");
        
    }
    
    @Override
    public void run(){
        try {
            restarVida();
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
