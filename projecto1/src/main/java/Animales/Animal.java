/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import JuegoGUI.AnimalGUI;
import Listas.Lista;
import Productos.Producto;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class Animal {

    protected Lista<Producto> destace, sinDestace;
    protected String nombre, obtenerProducto;
    protected int edad, alimentoConsumido, vida;
    protected double espacio;
    protected JLabel figuraAnimal = new JLabel();

    public Animal(String nombre, double espacio, String obtenerProducto) {
        destace = new Lista<>();
        sinDestace = new Lista<>();
        this.nombre = nombre;
        this.espacio = espacio;
        this.obtenerProducto = obtenerProducto;
        this.figuraAnimal.setText(nombre);
    }

    public double getEspacio() {
        return espacio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getObtenerProducto() {
        return obtenerProducto;
    }

    public Lista<Producto> getDestace() {
        return destace;
    }

    public Lista<Producto> getSinDestace() {
        return sinDestace;
    }

    public JLabel getFiguraAnimal() {
        return figuraAnimal;
    }
   

}
