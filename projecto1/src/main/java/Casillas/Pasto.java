/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import Animales.Animal;
import CasillasGUI.PastoGUI;
import Controladores.ControladorAnimales;
import Controladores.ControladorConstantes;
import Controladores.ControladorPasto;
import Controladores.ControladorPlantas;
import Juego.Bodega;
import Juego.Jugador;
import Juego.Parcela;
import Plantas.Planta;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Pasto extends Casilla {

    private Jugador jug;
    private ControladorPlantas plantas;
    private ControladorAnimales animales;
    private ControladorPasto cPasto = new ControladorPasto();
    private Planta planta;
    private Parcela parcela;
    private Bodega bodega;
    private int fertilidad = (int) (Math.random() * 100 + 1);

    public Pasto(int indice, Jugador jug, ControladorPlantas plantas, ControladorAnimales animales, Bodega bodega) {
        super(indice);
        figura = new PastoGUI(indice, this);
        this.jug = jug;
        this.plantas = plantas;
        this.bodega = bodega;
        this.animales = animales;
    }

    public void siembra(JLabel img) {
        int selección = 0;
        planta = plantas.getPlantasJuego().get(selección);
        if (jug.getSemillas() >= planta.getSemillas()) {
            jug.restarSemillas(planta.getSemillas());
            agregarParcelaCultivo(img, planta.getNombre());
        } else {
            JOptionPane.showMessageDialog(null, "No tiene las semillas necesarias");
        }
    }

    public void cosecha(JLabel img) {
        if (planta.isPlantaLista()) {
            int selección = 0;
            bodega.getContenedor().get(selección).agregartExistencia(1*fertilidad);
            planta = null;
            img.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Esta casilla no tienen nada que cosechar, o la cosecha aun no esta lista");
        }

    }

    public boolean plantaExistente() {
        if (planta != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean parcelaExistente() {
        if (parcela != null) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarParcela(JLabel img) {

        if ("".equals(img.getText())) {
            if (jug.getOro() >= ControladorConstantes.PRECIO_PARCELA) {
                parcela = new Parcela(animales.getAnimalesJuego().get(0), animales);
                jug.restarOro(ControladorConstantes.PRECIO_PARCELA);
                agregarParcelaCultivo(img, "Parcela" + Parcela.getCParcelas());
            } else {
                JOptionPane.showMessageDialog(null, "No posee el oro necesario");
            }
        }
    }
    
    public void desplegarParcela(){
        parcela.mostrarParcela();
    }

    private void agregarParcelaCultivo(JLabel img, String nombre) {
        cPasto.añadirParcelaCultivo(img, nombre);
    }

    @Override
    public PastoGUI getFigura() {
        return (PastoGUI) figura;
    }

    public Planta getPlanta() {
        return planta;
    }

    public Parcela getParcela() {
        return parcela;
    }

    public int getFertilidad() {
        return fertilidad;
    }  

}
