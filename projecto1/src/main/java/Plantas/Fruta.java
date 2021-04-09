/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Plantas;

import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class Fruta extends Planta {

    public Fruta(int semillas, String nombre) {
        super(semillas, nombre);
    }

    @Override
    public void marchitar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cosechar(JLabel img, JLabel imgCasilla) {
        img.setText(nombre);
        plantaCosechada = this;
    }

}
