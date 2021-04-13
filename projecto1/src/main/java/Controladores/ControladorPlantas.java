/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Listas.Lista;
import MenusGUI.AgregarPlantasGUI;
import Plantas.Fruta;
import Plantas.Grano;
import Plantas.Planta;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ControladorPlantas {
//atributos
    private Lista<Planta> plantasJuego;
    private AgregarPlantasGUI agregarPlanta;
//constructor
    public ControladorPlantas() {
        plantasJuego = new Lista<>();
        llenadoInicial();
        agregarPlanta = new AgregarPlantasGUI(this);
    }
//inicia el menu para agregar plantas al juego
    public void iniciar() {
        agregarPlanta.setVisible(true);
    }
//crea una planta en base al nombre, la cantidad de semillas, y si sera fruto o grano
    public void crearPlanta(String nombre, int semillas, String elección) {
        if (nombre == "") {//Verifica que haya ingresado un nombre para la planta
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre de la Planta");
        } else {
            if (elección == "Fruta") {
                plantasJuego.add(new Fruta(semillas, nombre));
            } else {
                plantasJuego.add(new Grano(semillas, nombre));
            }
        }
    }
//muestra la lista de plantas que se han creado
    public void mostrarListaPlantas(JTextArea pantalla) {
        for (int i = 0; i < plantasJuego.getSize(); i++) {
            pantalla.append(plantasJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }
//lleman la lista de opciones de los tipos de simbras que hay, dentro de una lista para el usuario
    public void llenarListaOpciones(JComboBox opciones) {
        for (int i = 0; i < plantasJuego.getSize(); i++) {
            opciones.addItem(plantasJuego.get(i).getNombre());
        }
    }
//Se crean las plantas predeterminadas del juego
    private void llenadoInicial() {
        plantasJuego.add(new Fruta(ControladorConstantes.C_SEMILLAS_F1, ControladorConstantes.FRUTA1));
        plantasJuego.add(new Grano(ControladorConstantes.C_SEMILLAS_G1, ControladorConstantes.GRANO1));
    }

    public Lista<Planta> getPlantasJuego() {
        return plantasJuego;
    }

}
