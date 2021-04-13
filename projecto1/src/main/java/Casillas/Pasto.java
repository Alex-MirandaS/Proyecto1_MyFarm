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
import JuegoGUI.SiembraGUI;
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
//atributosGUI
    private ElegirTipoPlanta elegirTipoPlanta;
    private ElegirTipoAnimal elegirTipoAnimal;
    private SiembraGUI siembraGUI;
//atributos
    private ControladorPlantas plantas;
    private ControladorAnimales animales;
    private ControladorPasto cPasto = new ControladorPasto();
    private Planta planta;
    private Parcela parcela;
    private Bodega bodega;
    private int fertilidad = (int) (Math.random() * 100 + 1);
//constructor
    public Pasto(Jugador jug, ControladorPlantas plantas, ControladorAnimales animales, Bodega bodega) {
        super(jug);
        figura = new PastoGUI(this);
        this.jug = jug;
        this.plantas = plantas;
        this.bodega = bodega;
        this.animales = animales;

    }
//Se encarga de verificar si la casilla puede ser sembrada, al sembrar se restan las semillas del jugador, y se agrega el cultivo
    public void siembra(JLabel img, int selección) {
        planta = plantas.getPlantasJuego().get(selección);
        if (jug.getSemillas() >= planta.getSemillas() && img.getText() == "") {
            jug.restarSemillas(planta.getSemillas());
            img.setText(planta.getNombre());
            agregarParcelaCultivo(img);
            siembraGUI = new SiembraGUI(this);
            planta.setPlantaLista(true);
        } else if (img.getText() != "") {
            JOptionPane.showMessageDialog(null, "Esta casilla ya esta ocupada");
        } else {
            JOptionPane.showMessageDialog(null, "No tiene las semillas necesarias");
        }
    }
//abre la ventana para especificar que tipo de planta se desea cosechar
    public void sembrar(JLabel img) {
        this.elegirTipoPlanta = new ElegirTipoPlanta(img, this);
        elegirTipoPlanta.setVisible(true);
    }
//Se encarga de verificar si la casilla contiene una siembra, y si la misma esta lista para cosecharse, cuando esta lista
//retorna cierta cantidad aleatoria, multiplicada por la fertilidad del pasto
    public void cosecha(JLabel img) {
        if (planta.isPlantaLista()) {
            bodega.getContenedor().get(buscarProducto()).agregartExistencia(1 * fertilidad);
            planta.cosechar(img, this.getFigura().getParcelaCultivo());
            planta = planta.getPlantaCosechada();

        } else {
            JOptionPane.showMessageDialog(null, "Esta casilla no tienen nada que cosechar, o la cosecha aun no esta lista");
        }
    }
//Se encargar de buscar los productos segund un nombre
    public int buscarProducto() {
        for (int i = 0; i < plantas.getPlantasJuego().getSize(); i++) {
            if (planta.getNombre().equals(bodega.getContenedor().get(i).getProducto().getNombre())) {
                return i;
            }
        }
        return 0;
    }
//muestra el menu de eleccion del cultivo
    public void desplegarCultivo() {
        siembraGUI.setVisible(true);
    }
//Se encarga de crear una Parcela, dependiendo del tipo de animales que contendran las parcelas
    public void crearParcela(JLabel img) {
        this.elegirTipoAnimal = new ElegirTipoAnimal(img, this);
        elegirTipoAnimal.setVisible(true);
    }
//devuelve un booleano que nos dice si hay un cultivo dentro y valido
    public boolean plantaExistente() {
        if (planta != null) {
            return true;
        } else {
            return false;
        }
    }
//devuelve un booleano que nos dice si hay una parcela dentro y valida
    public boolean parcelaExistente() {
        if (parcela != null) {
            return true;
        } else {
            return false;
        }
    }
//se encarga de verificar que la casilla pasto este desocupada para poder agregar una parcela
    public void agregarParcela(JLabel img, int selección) {

        if ("".equals(img.getText())) {//si esta vacia, entonces entra al ir
            if (jug.getOro() >= ControladorConstantes.PRECIO_PARCELA) {//si el jugador tiene oro suficiente, entra al if y crea una nueva parcela
                parcela = new Parcela(animales.getAnimalesJuego().get(selección), bodega, jug);
                jug.restarOro(ControladorConstantes.PRECIO_PARCELA);//resta eloro de la parcela
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
