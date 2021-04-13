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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Agua extends Casilla {
//atributos
    private Bodega bodega;
    private ControladorAgua controlador;
    private Barco barco;
//constructor
    public Agua(Jugador jug, Bodega bodega) {
        super(jug);
        this.jug = jug;
        this.bodega = bodega;
        this.controlador = new ControladorAgua();
        figura = new AguaGUI(this);
    }
//verifica que se tenga la cantidad necesaria para agregar un barco, si ese es el caso, resta el oro del jugador y añade el barco, iniciando su hilo
    public void ponerBarco(JLabel img) {

        if (jug.getOro() >= ControladorConstantes.PRECIO_BARCO) {
            barco = new Barco(this);
            jug.restarOro(barco.getPrecio());
            controlador.añadirBarco(img, barco.getNombre());
            Thread hiloBarco = new Thread(new HiloBarco(barco, barco.getFiguraBarco()));
            hiloBarco.start();
        } else {
            JOptionPane.showMessageDialog(null, "No tiene el oro suficiente");
        }
    }
//muestra el barco
    public void desplegarBarco(JLabel barco) {
        this.barco.mostrarBarco();
    }
//cuando el barco esta lleno, se encarga de quitarlo de la casilla, de lo contrario informa que el barco esta pescando aun
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
//retorna si hay un barco en el agua
    public boolean barcoExiste() {
        if (barco != null) {
            return true;
        } else {
            return false;
        }
    }
//obtiene los peces que va recolectando
    public void recolectarPeces() {
        bodega.getContenedor().get(7).agregartExistencia(barco.getPecesRecolectados());
        barco.setPecesRecolectados(0);
    }

    @Override
    public AguaGUI getFigura() {
        return (AguaGUI) figura;
    }

    public Barco getBarco() {
        return barco;
    }

}
