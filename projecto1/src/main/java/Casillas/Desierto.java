/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import CasillasGUI.DesiertoGUI;
import Juego.Jugador;

/**
 *
 * @author alex
 */
public class Desierto extends Casilla {

    public Desierto(int indice, Jugador jug) {
        super(indice, jug);
        figura = new DesiertoGUI(indice, this);
    }

    @Override
    public DesiertoGUI getFigura() {
        return (DesiertoGUI) figura;
    }

}
