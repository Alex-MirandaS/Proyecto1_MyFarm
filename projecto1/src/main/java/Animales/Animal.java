/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animales;

import JuegoGUI.AnimalGUI;

/**
 *
 * @author alex
 */
public class Animal {

    protected String nombre;
    protected int edad, alimentoConsumido, vida;
    protected double espacio;
    protected AnimalGUI figuraAnimal = new AnimalGUI();

    public Animal(String nombre, double espacio) {
        this.nombre = nombre;
        this.espacio = espacio;
    }

    public String getNombre() {
        return nombre;
    }   
    
}
