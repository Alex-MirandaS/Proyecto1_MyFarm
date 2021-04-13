/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import Juego.Jugador;
import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class Casilla {
//atributos
    protected JPanel figura;
    protected boolean prepararDesbloqueo;
    protected Jugador jug;
//constructor
    public Casilla(Jugador jug) {
        this.jug = jug;
    }

    public JPanel getFigura() {
        return figura;
    }

    public void setPrepararDesbloqueo(boolean prepararDesbloqueo) {
        this.prepararDesbloqueo = prepararDesbloqueo;
    }

    public boolean getPrepararDesbloqueo() {
        return prepararDesbloqueo;
    }

    public Jugador getJug() {
        return jug;
    }

}
