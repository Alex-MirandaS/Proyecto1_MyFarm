/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import CasillasGUI.AguaGUI;
import Controladores.ControladorAgua;
import Controladores.ControladorConstantes;
import Juego.Barco;
import Juego.Bodega;
import Juego.Jugador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Agua extends Casilla {

    private Bodega bodega;
    private ControladorAgua controlador;
    private Barco barco;

    public Agua(int indice, Jugador jug, Bodega bodega) {
        super(indice, jug);
        this.jug = jug;
        this.bodega = bodega;
        this.controlador = new ControladorAgua();
        figura = new AguaGUI(indice, this);
    }

    public void ponerBarco(JLabel img) {

        Barco barcoTemp = new Barco();
        if (jug.getOro() >= barcoTemp.getPrecio()) {
            barco = barcoTemp;
            jug.restarOro(barco.getPrecio());
            controlador.añadirBarco(img, barco.getNombre());
            //  pescar(img, planta.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "No tiene el oro suficiente");
        }
    }

    public boolean barcoExiste() {
        if (barco != null) {
            return true;
        } else {
            return false;
        }
    }

    public void recolectarPeces() {
        bodega.getContenedor().get(7).agregartExistencia(barco.getPeces());
    }

    @Override
    public AguaGUI getFigura() {
        return (AguaGUI) figura;
    }
}
