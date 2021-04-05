/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import Animales.Animal;
import JuegoGUI.ParcelaGUI;
import Listas.Lista;

/**
 *
 * @author alex
 */
public class Parcela {

    private Lista<Animal> animales;
    private static int cParcelas=0;
    private ParcelaGUI figuraParcela;

//GUI
    public Parcela(Animal tipo) {    
        animales = new Lista<>();
        figuraParcela = new ParcelaGUI(this);
        cParcelas++;
    }
    
    public void mostrarParcela(){
        figuraParcela.setVisible(true);//poner boton recolectar
    }

    public Lista<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(Lista<Animal> animales) {
        this.animales = animales;
    }

    public static int getCParcelas(){
        return cParcelas;
    }
    
}
