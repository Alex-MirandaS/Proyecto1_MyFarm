/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import CasillasGUI.AguaGUI;
import Juego.Jugador;
import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class Agua extends Casilla{
    
    private Jugador jug;
    public Agua(int indice, Jugador jug) {
        super(indice);
        this.jug = jug;
        figura = new AguaGUI(indice);
    }

    @Override
    public AguaGUI getFigura() {
        return (AguaGUI) figura;
    }
    
}
