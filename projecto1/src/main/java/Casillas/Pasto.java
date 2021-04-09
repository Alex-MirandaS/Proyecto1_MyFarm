/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Casillas;

import CasillasGUI.PastoGUI;
import Controladores.*;
import Juego.Bodega;
import Juego.Jugador;
import Juego.Parcela;
import MenusGUI.ElegirTipoAnimal;
import MenusGUI.ElegirTipoPlanta;
import Plantas.Planta;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author alex
 */
public class Pasto extends Casilla {

    private ElegirTipoPlanta elegirTipoPlanta;
    private ElegirTipoAnimal elegirTipoAnimal;

    private ControladorPlantas plantas;
    private ControladorAnimales animales;
    private ControladorPasto cPasto = new ControladorPasto();
    private Planta planta;
    private Parcela parcela;
    private Bodega bodega;
    private int fertilidad = (int) (Math.random() * 100 + 1);

    public Pasto(int indice, Jugador jug, ControladorPlantas plantas, ControladorAnimales animales, Bodega bodega) {
        super(indice, jug);
        figura = new PastoGUI(indice, this);
        this.jug = jug;
        this.plantas = plantas;
        this.bodega = bodega;
        this.animales = animales;

    }

    public void siembra(JLabel img, int selección) {
        planta = plantas.getPlantasJuego().get(selección);
        if (jug.getSemillas() >= planta.getSemillas() && img.getText() == "") {
            jug.restarSemillas(planta.getSemillas());
            img.setText(planta.getNombre());
            agregarParcelaCultivo(img);
        } else if (img.getText() != "") {
            JOptionPane.showMessageDialog(null, "Esta casilla ya esta ocupada");
        } else {
            JOptionPane.showMessageDialog(null, "No tiene las semillas necesarias");
        }
    }

    public void sembrar(JLabel img) {
        this.elegirTipoPlanta = new ElegirTipoPlanta(img, this);
        elegirTipoPlanta.setVisible(true);
    }

    public void cosecha(JLabel img) {
        int selección = 0;
        if (planta.isPlantaLista()) {
            bodega.getContenedor().get(selección).agregartExistencia(1 * fertilidad);
            planta.cosechar(img);
            planta = planta.getPlantaCosechada();
        } else {
            JOptionPane.showMessageDialog(null, "Esta casilla no tienen nada que cosechar, o la cosecha aun no esta lista");
        }
    }

    public void crearParcela(JLabel img) {
        this.elegirTipoAnimal = new ElegirTipoAnimal(img, this);
        elegirTipoAnimal.setVisible(true);
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

    public void agregarParcela(JLabel img, int selección) {

        if ("".equals(img.getText())) {
            if (jug.getOro() >= ControladorConstantes.PRECIO_PARCELA) {
                parcela = new Parcela(animales.getAnimalesJuego().get(selección));
                jug.restarOro(ControladorConstantes.PRECIO_PARCELA);
                img.setText(parcela.getFiguraParcelaCasilla().getText());
                agregarParcelaCultivo(img);
            } else {
                JOptionPane.showMessageDialog(null, "No posee el oro necesario");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No posee el oro necesario");
        }
    }

    public void desplegarParcela() {
        parcela.mostrarParcela();
    }

    private void agregarParcelaCultivo(JLabel img) {
        cPasto.añadirParcelaCultivo(img);
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

    public ElegirTipoPlanta getElegirTipoPlanta() {
        return elegirTipoPlanta;
    }

    public ControladorPlantas getPlantas() {
        return plantas;
    }

    public ControladorAnimales getAnimales() {
        return animales;
    }

}
