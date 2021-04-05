/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Casillas.Casilla;
import Listas.Lista;
import MenusGUI.AgregarPlantasGUI;
import Plantas.Fruta;
import Plantas.Grano;
import Plantas.Planta;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ControladorPlantas {

    private Lista<Planta> plantasJuego;
    private AgregarPlantasGUI agregarPlanta;

    public ControladorPlantas() {
        plantasJuego = new Lista<>();
        llenadoInicial();
        agregarPlanta = new AgregarPlantasGUI(this);
        //panel
    }

    public void iniciar() {
        agregarPlanta.setVisible(true);
    }

    public void crearPlanta(String nombre, int semillas, String elección) {
        if (nombre == "") {
            JOptionPane.showMessageDialog(null, "No ha ingresado el nombre de la Planta");
        } else {
            if (elección == "Fruta") {
                plantasJuego.add(new Fruta(semillas, nombre));
            } else {
                plantasJuego.add(new Grano(semillas, nombre));
            }
        }
    }

    public void mostrarListaPlantas(JTextArea pantalla) {
        for (int i = 0; i < plantasJuego.getSize(); i++) {
            pantalla.append(plantasJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }

    private void llenadoInicial() {
        plantasJuego.add(new Fruta(ControladorConstantes.C_SEMILLAS_F1, ControladorConstantes.FRUTA1));
        plantasJuego.add(new Grano(ControladorConstantes.C_SEMILLAS_G1, ControladorConstantes.GRANO1));
    }

    public Lista<Planta> getPlantasJuego() {
        return plantasJuego;
    }

}
