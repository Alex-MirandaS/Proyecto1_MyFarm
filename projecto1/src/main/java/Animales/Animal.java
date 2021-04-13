/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import Listas.Lista;
import Productos.Producto;
import javax.swing.JLabel;

/**
 *
 * @author alex
 */
public class Animal {

    protected Lista<Producto> destace, sinDestace;
    protected String nombre, obtenerProducto;
    protected int edad = 1, alimentoConsumido, vida = 100, precio;
    protected double espacio;
    protected boolean muerto;
    protected JLabel figuraAnimal = new JLabel();

    public Animal(String nombre, double espacio, String obtenerProducto, int precio) {
        destace = new Lista<>();
        sinDestace = new Lista<>();
        this.nombre = nombre;
        this.espacio = espacio;
        this.obtenerProducto = obtenerProducto;
        this.precio = precio;
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

    public int getPrecio() {
        return precio;
    }

    public int getVida() {
        return vida;
    }

    public void sumarVida(int vida) {
        this.vida += vida;
    }

    public void restarVida(int vida) {
        this.vida -= vida;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

}
