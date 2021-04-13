/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import CasillasGUI.AguaGUI;
import Controladores.ControladorAgua;
import Controladores.ControladorConstantes;
import Hilos.HiloBarco;
import Juego.Barco;
import Juego.Bodega;
import Juego.Jugador;
import JuegoGUI.BarcoGUI;
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

    public Agua(Jugador jug, Bodega bodega) {
        super(jug);
        this.jug = jug;
        this.bodega = bodega;
        this.controlador = new ControladorAgua();
        figura = new AguaGUI(this);
    }

    public void ponerBarco(JLabel img) {

        if (jug.getOro() >= ControladorConstantes.PRECIO_BARCO) {
            barco = new Barco(this);
            jug.restarOro(barco.getPrecio());
            controlador.añadirBarco(img, barco.getNombre());
            HiloBarco hiloBarco = new HiloBarco(barco, barco.getFiguraBarco());
            hiloBarco.start();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene el oro suficiente");
        }
    }

    public void desplegarBarco(JLabel barco) {
        this.barco.mostrarBarco();
    }

    public void limpiar() {
        if (barco.isLleno()) {
            barco.getFiguraBarco().getFiguraBarco().setText("");
            AguaGUI figuraGUI = (AguaGUI) figura;
            figuraGUI.getBarco().setText("");
            barco = null;
        } else {
            JOptionPane.showMessageDialog(null, "Este barco aun esta pescando");
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
        bodega.getContenedor().get(7).agregartExistencia(barco.getPecesRecolectados());
    }

    @Override
    public AguaGUI getFigura() {
        return (AguaGUI) figura;
    }

    public Barco getBarco() {
        return barco;
    }

}
