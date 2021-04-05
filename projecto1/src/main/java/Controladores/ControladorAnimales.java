/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Animales.Animal;
import Animales.Herbívoro;
import Animales.Omnívoro;
import Listas.Lista;
import MenusGUI.AgregarParcelasGUI;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author alex
 */
public class ControladorAnimales {

    private Lista<Animal> animalesJuego;
    private AgregarParcelasGUI agregarAnimal;

    public ControladorAnimales() {
        animalesJuego = new Lista<>();
        llenadoInicial();
        agregarAnimal = new AgregarParcelasGUI(this);
    }

    public void iniciar() {
        agregarAnimal.setVisible(true);
    }

    public void crearAnimal(String nombre, double espacio, String elección) {
        if (nombre == "") {
           JOptionPane.showMessageDialog(null, "No ha ingresado el nombre del Animal");
        }else{
        if (elección == "Herbívoro") {
            animalesJuego.add(new Herbívoro(nombre, (double)espacio));
        } else {
            animalesJuego.add(new Omnívoro(nombre, (double)espacio));
        }
        }
    }

    public void mostrarListaAnimales(JTextArea pantalla) {
        for (int i = 0; i < animalesJuego.getSize(); i++) {
            pantalla.append(animalesJuego.get(i).getNombre());
            pantalla.append(System.getProperty("line.separator"));
        }
    }

    private void llenadoInicial() {
        animalesJuego.add(new Herbívoro(ControladorConstantes.HERBÍVORO1, ControladorConstantes.ESPACIO_HERBÍVORO1));
        animalesJuego.add(new Omnívoro(ControladorConstantes.OMNÍVORO1, ControladorConstantes.ESPACIO_OMNÍVORO1));
    }

    public Lista<Animal> getAnimalesJuego() {
        return animalesJuego;
    }

}
