/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import javax.swing.JPanel;

/**
 *
 * @author alex
 */
public class Casilla {

    protected JPanel figura;
    protected int indice;
    protected boolean prepararDesbloqueo;

    public Casilla(int indice) {
        this.indice = indice;
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


    
}
