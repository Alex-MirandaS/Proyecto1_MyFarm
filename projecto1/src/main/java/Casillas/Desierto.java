/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import CasillasGUI.DesiertoGUI;

/**
 *
 * @author alex
 */
public class Desierto extends Casilla {

    public Desierto(int indice) {
        super(indice);
        figura = new DesiertoGUI(indice);
    }

    @Override
    public DesiertoGUI getFigura() {
        return (DesiertoGUI) figura;
    }

}
